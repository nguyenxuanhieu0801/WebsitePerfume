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
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;
	
		
	@GetMapping("/{categoryId}")
	public String list(ModelMap model,@PathVariable("categoryId") Long categoryId ,@RequestParam("page") Optional<Integer> page) {
		int currentPage;
		if(page.isEmpty()) {
			currentPage = 0;
		} else {
			currentPage = page.get() - 1;
		}
		
		Category category = categoryService.findById(categoryId).get();
		
		Page<Product> pageList = productService.getProductInCategory(currentPage, 10, "productId", "DESC", category);

		
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
	
}
