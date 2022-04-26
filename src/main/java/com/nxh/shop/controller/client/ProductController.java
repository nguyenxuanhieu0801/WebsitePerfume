package com.nxh.shop.controller.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nxh.shop.domain.Category;
import com.nxh.shop.domain.Product;
import com.nxh.shop.service.CategoryService;
import com.nxh.shop.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;
	
		
	@GetMapping("")
	public String list(ModelMap model, @RequestParam("page") Optional<Integer> page) {
		int currentPage;
		if(page.isEmpty()) {
			currentPage = 0;
		} else {
			currentPage = page.get() - 1;
		}
		
		Pageable pageable = PageRequest.of(currentPage, 12, Direction.DESC, "productId");
		Page<Product> pageList = productService.findAll(pageable);
		List<Product> list = pageList.getContent();
		int totalPage = pageList.getTotalPages();
		int totalItems = pageList.getTotalPages();
		
		model.addAttribute("title", "Danh sách sản phẩm");
		model.addAttribute("products", list);
		model.addAttribute("currentPage",currentPage + 1);
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("totalPage",totalPage);
		
		return "client/productList";
	}
	


	
	@GetMapping("/{productId}")
	public String index(ModelMap model, @PathVariable("productId") Long productId) {
		Optional<Product> opt = productService.findById(productId);
		Product entity = opt.get();
		if(opt.isPresent()) {
			model.addAttribute("title", entity.getName());
			model.addAttribute("product", entity);
			return "client/product";
		}	
		return "redirect:/";
	}
}
