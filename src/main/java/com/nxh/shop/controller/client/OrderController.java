package com.nxh.shop.controller.client;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nxh.shop.domain.CartItem;
import com.nxh.shop.domain.Order;
import com.nxh.shop.domain.OrderDetail;
import com.nxh.shop.domain.User;
import com.nxh.shop.service.OrderDetailService;
import com.nxh.shop.service.OrderService;
import com.nxh.shop.service.ProductService;
import com.nxh.shop.service.UserService;
import com.nxh.shop.utils.Utils;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;

	@Autowired
	OrderDetailService orderDetailService;

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@Autowired
	private HttpSession session;

	@GetMapping("/add")
	public String add(RedirectAttributes redirectAttributes) {
		
			User user = (User) session.getAttribute("user");
		
			if(user == null) {
				return "redirect:/login";
			}	
			
			Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");			
	
			if(cart == null) {
				return "redirect:/";
			}
			Order order = new Order();
			order.setUser(userService.getById(user.getUserId()));
			order.setOrderDate(new Date());
			order.setAmount(Utils.sumAmount(cart));
			order.setStatus((short) 0);
			orderService.save(order);

			for (CartItem c : cart.values()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrder(order);
				orderDetail.setProduct(productService.getById(c.getProductId()));
				orderDetail.setPrice(c.getPrice());
				orderDetail.setQuantity(c.getQuantity());
				orderDetailService.save(orderDetail);
			}
			session.removeAttribute("cart");
			redirectAttributes.addFlashAttribute("message", "Thêm đơn hàng thành công");
			return "redirect:/cart";
	}
}
