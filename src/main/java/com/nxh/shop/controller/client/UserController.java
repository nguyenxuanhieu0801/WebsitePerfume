package com.nxh.shop.controller.client;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nxh.shop.domain.Order;
import com.nxh.shop.domain.OrderDetail;
import com.nxh.shop.domain.User;
import com.nxh.shop.model.OrderDto;
import com.nxh.shop.model.UserDto;
import com.nxh.shop.service.OrderDetailService;
import com.nxh.shop.service.OrderService;
import com.nxh.shop.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	OrderService orderService;

	@Autowired
	OrderDetailService orderDetailService;
	
	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	private HttpSession session;

	@GetMapping("/profile")
	public String edit(ModelMap model) {
		User entity = (User) session.getAttribute("user");
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(entity, dto);
		model.addAttribute("title", "Thông tin người dùng");
		model.addAttribute("user", dto);
		return "/client/profile";
	}

	@PostMapping("/update")
	public String update(ModelMap model, @ModelAttribute("user") UserDto dto, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (dto.getName().trim().length() == 0) {
			result.rejectValue("name", "user", "Vui lòng nhập tên");
		}

		if (dto.getAddress().trim().length() == 0) {
			result.rejectValue("address", "user", "Vui lòng nhập địa chỉ");
		}

		if (dto.getPhone().trim().length() == 0) {
			result.rejectValue("phone", "user", "Vui lòng nhập số điện thoại");
		}

		if (result.hasErrors()) {
			return "/client/profile";
		}

		User entity = (User) session.getAttribute("user");
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		entity.setPhone(dto.getPhone());
		entity.setSex(dto.isSex());
		userService.save(entity);
		session.setAttribute("user", entity);

		redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
		return "redirect:/user/profile";
	}

	@GetMapping("/orders")
	public String list(ModelMap model, @RequestParam("page") Optional<Integer> page) {

		int currentPage;
		if (page.isEmpty()) {
			currentPage = 0;
		} else {
			currentPage = page.get() - 1;
		}

		User user = (User) session.getAttribute("user");
		Page<Order> pageList = orderService.getOrderInUser(currentPage, 10, "orderId", "DESC", user);
		List<Order> list = pageList.getContent();
		int totalPage = pageList.getTotalPages();
		int totalItems = pageList.getTotalPages();
		model.addAttribute("title", "Danh sách đơn hàng");
		model.addAttribute("orders", list);
		model.addAttribute("currentPage", currentPage + 1);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPage", totalPage);
		return "/client/orders";
	}

	@GetMapping("/orders/{orderId}")
	public String edit(ModelMap model, @PathVariable("orderId") Long orderId) {
		Optional<Order> opt = orderService.findById(orderId);
		OrderDto dto = new OrderDto();
		if (opt.isPresent()) {			
			Order entity = opt.get();
			Set<OrderDetail> list = entity.getOrderDetails();			
			BeanUtils.copyProperties(entity, dto);
			dto.setUserId(entity.getUser().getUserId());			
			model.addAttribute("title", "Cập nhật đơn hàng");
			model.addAttribute("orderDetails", list);
			model.addAttribute("order", dto);
			return "client/orderDetail";
		}
		return "redirect:/user/orders";
	}
	
	@PostMapping("orders/update/{orderId}")
	public String update(@PathVariable("orderId") Long orderId, OrderDto dto,
			RedirectAttributes redirectAttributes) {
		Optional<Order> opt = orderService.findById(orderId);
		Order entity = opt.get();
		entity.setStatus(dto.getStatus());
		orderService.save(entity);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(entity.getUser().getEmail());
		String text;
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss dd-M-yyyy");
		if(entity.getStatus() == 2) {
			msg.setSubject("Xác nhận hủy đơn hàng " + orderId);
			text =  "Xin chào "+ entity.getUser().getName() + "\n"
					+ "Đơn hàng có mã là "+ orderId + " ngày "  + formatter.format(entity.getOrderDate())   +" của bạn đã bị hủy." + "\n"
					+ "Cảm ơn bạn đã mua hàng ở COZA STORE";
			msg.setText(text);
			javaMailSender.send(msg);
		}
		redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
		return "redirect:/user/orders/{orderId}";

	}
}