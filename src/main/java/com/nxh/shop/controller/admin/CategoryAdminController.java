package com.nxh.shop.controller.admin;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nxh.shop.domain.Category;
import com.nxh.shop.model.CategoryDto;
import com.nxh.shop.service.CategoryService;

@Controller
@RequestMapping("admin/categories")
public class CategoryAdminController {
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
		
		Pageable pageable = PageRequest.of(currentPage, 10);
		Page<Category> pageList = categoryService.findAll(pageable);
		List<Category> list = pageList.getContent();
		int totalPage = pageList.getTotalPages();
		int totalItems = pageList.getTotalPages();
		
		model.addAttribute("title", "Danh sách danh mục" );
		model.addAttribute("categories", list);
		model.addAttribute("currentPage",currentPage + 1);
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("totalPage",totalPage);
		return "admin/category/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("title", "Thêm danh mục");
		model.addAttribute("category", new CategoryDto());
		return "admin/category/add";
	}
	
	@PostMapping("/save")
	public String save(@Validated @ModelAttribute("category") CategoryDto dto,
			BindingResult result,RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "admin/category/add";
		}else {			
			Category entity = new Category();
			BeanUtils.copyProperties(dto, entity);		
			categoryService.save(entity);
			redirectAttributes.addFlashAttribute("message","Thêm thành công");
			return "redirect:/admin/categories/add";
		}
	}
	
	
	@GetMapping("/edit/{categoryId}")
	public String edit(ModelMap model, @PathVariable("categoryId") Long categoryId) {
		Optional<Category> opt = categoryService.findById(categoryId);
		CategoryDto dto = new CategoryDto();
		if(opt.isPresent()) {
			Category entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			model.addAttribute("title", "Cập nhật danh mục");
			model.addAttribute("category", dto);
			return "admin/category/edit";
		}	
		return "redirect:/admin/categories";
	}
	
	@PostMapping("update/{categoryId}")
	public String update(@Validated @PathVariable("categoryId") Long categoryId, CategoryDto dto, 
			BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "admin/category/edit";
		}else {
			Category entity = new Category();
			BeanUtils.copyProperties(dto, entity);		
			categoryService.save(entity);
			redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
			return "redirect:/admin/categories/edit/{categoryId}";
		}
		
	}
	
	@GetMapping("/delete/{categoryId}")
	public String delete(@PathVariable("categoryId") Long categoryId, RedirectAttributes redirectAttributes) {
		categoryService.deleteById(categoryId);
		redirectAttributes.addFlashAttribute("message", "Xóa thành công");
		return "redirect:/admin/categories";
	}
	
	
}
