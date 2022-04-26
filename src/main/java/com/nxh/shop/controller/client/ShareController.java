package com.nxh.shop.controller.client;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nxh.shop.domain.CartItem;
import com.nxh.shop.domain.Category;
import com.nxh.shop.service.CategoryService;
import com.nxh.shop.service.ProductService;
import com.nxh.shop.utils.Utils;

@Controller
@ControllerAdvice
public class ShareController {
	@Autowired
	ProductService productService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	CategoryService categoryService;
	
	@ModelAttribute("listCategories")
	public List<Category> listCategory() {
		return categoryService.findAll();
	}
	
	
	@ModelAttribute
	public void commonAttrs(Model model) {
		Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");
		
		int counter = Utils.countCart(cart);

		model.addAttribute("cartCounter", counter);
	}
}
