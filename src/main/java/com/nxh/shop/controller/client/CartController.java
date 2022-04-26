package com.nxh.shop.controller.client;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nxh.shop.domain.CartItem;
import com.nxh.shop.domain.Product;
import com.nxh.shop.service.ProductService;
import com.nxh.shop.utils.Utils;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("")
	public String show(ModelMap model) {
		Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");
		
		if(cart != null) {
			model.addAttribute("cart", cart.values());
		}
		model.addAttribute("title","Giỏ hàng");
		return "/client/cart";
	}
	
	@GetMapping("/add")
	@ResponseBody
	public void addToCart(@RequestParam long productId) {
		Product product = productService.getById(productId);
		Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<>();
		}
		
		double temp;	
		
		if(cart.containsKey(productId) == true) {
			CartItem cartItem = cart.get(productId);
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		} else {
			CartItem cartItem = new CartItem();
			cartItem.setName(product.getName());
			
			if(product.getDiscount()/100 * product.getPrice() == 0) {
				cartItem.setPrice(product.getPrice());
			}else if(product.getDiscount() /100 * product.getPrice() >= 0){
				temp = product.getPrice() - (product.getPrice()  * product.getDiscount()/100);
				cartItem.setPrice(temp);
			}
			cartItem.setProductId(productId);
			cartItem.setQuantity(1);
			cartItem.setImage(product.getImage());
			cart.put(productId, cartItem);
		}
		session.setAttribute("cart", cart);	
	}
	
	@GetMapping("/update")
	@ResponseBody
	public void updateCart(@RequestParam long productId, @RequestParam int quatity) {
		Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<>();
		}
		
		if(cart.containsKey(productId) == true) {
			CartItem cartItem = cart.get(productId);
			cartItem.setQuantity(quatity);
		} 
		session.setAttribute("cart", cart);	
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public void deleteCart(@RequestParam long productId) {
		Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");
		if(cart != null &&  cart.containsKey(productId)) {
			cart.remove(productId);
			
			session.setAttribute("cart", cart);	
		}
		
	}
	
}
