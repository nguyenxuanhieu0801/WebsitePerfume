package com.nxh.shop.controller.admin;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nxh.shop.domain.Order;
import com.nxh.shop.domain.OrderDetail;
import com.nxh.shop.model.OrderDto;
import com.nxh.shop.service.OrderService;
import com.nxh.shop.service.UserService;

@Controller
@RequestMapping("admin/orders")
public class OrderAdminController {
	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	 JavaMailSender javaMailSender;

	@GetMapping("")
	public String list(ModelMap model, @RequestParam("page") Optional<Integer> page) {
		
		int currentPage;
		if (page.isEmpty()) {
			currentPage = 0;
		} else {
			currentPage = page.get() - 1;
		}
	
		Pageable pageable = PageRequest.of(currentPage, 10, Direction.DESC, "orderId");	
		Page<Order> pageList = orderService.findAll(pageable);
		List<Order> list = pageList.getContent();
		int totalPage = pageList.getTotalPages();
		int totalItems = pageList.getTotalPages();
		model.addAttribute("title", "Danh sách đơn hàng");
		model.addAttribute("orders", list);
		model.addAttribute("currentPage", currentPage + 1);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPage", totalPage);
		return "admin/order/list";
	}

	@GetMapping("/edit/{orderId}")
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
			//model.addAttribute("order", entity.getUser());
			System.out.println(entity.getUser().toString());
			model.addAttribute("user", entity.getUser());
			return "admin/order/edit";
		}
		return "redirect:/admin/orders";
	}

	@PostMapping("update/{orderId}")
	public String update(@PathVariable("orderId") Long orderId, OrderDto dto,
			RedirectAttributes redirectAttributes) {
		Optional<Order> opt = orderService.findById(orderId);
		Order entity = opt.get();
		entity.setStatus(dto.getStatus());
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(entity.getUser().getEmail());
		String text;
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss dd-M-yyyy");
		
		orderService.save(entity);
		if(entity.getStatus() == 1) {
			msg.setSubject("Xác nhận đơn hàng " + orderId);
			
			text=  "Xin chào "+ entity.getUser().getName()  +"\n"
					+ "Đơn hàng có mã là "+ orderId  + " ngày " + formatter.format(entity.getOrderDate()) +" của bạn đã được xác nhận" + "\n"
			+ "Cảm ơn bạn đã mua hàng ở COZA STORE";
			msg.setText(text);
			javaMailSender.send(msg);
		}else if(entity.getStatus() == 2) {
			msg.setSubject("Xác nhận hủy đơn hàng " + orderId);
			text =  "Xin chào "+ entity.getUser().getName() + "\n"
					+ "Đơn hàng có mã là "+ orderId + " ngày "  + formatter.format(entity.getOrderDate())   +" của bạn đã bị hủy." + "\n"
					+ "Cảm ơn bạn đã mua hàng ở COZA STORE";
			msg.setText(text);
			javaMailSender.send(msg);
		}
		
		redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
		return "redirect:/admin/orders/edit/{orderId}";

	}

	
}