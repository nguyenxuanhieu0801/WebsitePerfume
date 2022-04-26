package com.nxh.shop.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nxh.shop.domain.Product;
import com.nxh.shop.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;

//	@ModelAttribute("products")
//	public List<Product> list() {
//		List<Product> listProduct = null;
//		//listProduct = productService.getTop10NewProduct();
//		return listProduct;
//	}
	
	
	
	@GetMapping("/")
	public String index(Model model) {	
		model.addAttribute("title", "Trang chủ");
		return "/client/home";

	}
}
