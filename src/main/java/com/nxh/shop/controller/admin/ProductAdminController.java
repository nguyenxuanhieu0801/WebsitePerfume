package com.nxh.shop.controller.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nxh.shop.domain.Category;
import com.nxh.shop.domain.Product;
import com.nxh.shop.model.ProductDto;
import com.nxh.shop.service.CategoryService;
import com.nxh.shop.service.ProductService;
import com.nxh.shop.utils.FileUploadUtil;

@Controller
@RequestMapping("admin/products")
public class ProductAdminController {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@ModelAttribute("categories")
	public List<Category> list() {
		return categoryService.findAll();
	}

	@GetMapping("")
	public String list(ModelMap model, @RequestParam("page") Optional<Integer> page) {

		int currentPage;
		if (page.isEmpty()) {
			currentPage = 0;
		} else {
			currentPage = page.get() - 1;
		}
		Pageable pageable = PageRequest.of(currentPage, 10, Direction.DESC, "productId");
		Page<Product> pageList = productService.findAll(pageable);
		List<Product> list = pageList.getContent();
		System.out.println(list.isEmpty());
		int totalPage = pageList.getTotalPages();
		int totalItems = pageList.getTotalPages();

		model.addAttribute("title", "Danh sách sản phẩm");
		model.addAttribute("products", list);
		model.addAttribute("currentPage", currentPage + 1);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPage", totalPage);
		return "admin/product/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("title", "Thêm sản phẩm");
		model.addAttribute("product", new ProductDto());
		return "admin/product/add";
	}

	@PostMapping("/save")
	public String save(@Validated @ModelAttribute("product") ProductDto dto, BindingResult result,
			@RequestParam("imageFile") MultipartFile imageFile,
			RedirectAttributes redirectAttributes) throws IOException {

		if (result.hasErrors()) {
			System.out.println(result.hasErrors());
			return "admin/product/add";
		} else {
			Product entity = new Product();
			String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
			String uploadDir = "uploads/";
			FileUploadUtil.saveFile(uploadDir, fileName, imageFile);
			BeanUtils.copyProperties(dto, entity);

			Category category = new Category();
			category.setCategoryId(dto.getCategoryId());
			entity.setCategory(category);
			entity.setImage(fileName);
			productService.save(entity);
			redirectAttributes.addFlashAttribute("message", "Thêm thành công sản phẩm");
			return "redirect:/admin/products/add";
		}
	}

	@GetMapping("/edit/{productId}")
	public String edit(ModelMap model, @PathVariable("productId") Long productId) {
		Optional<Product> opt = productService.findById(productId);
		ProductDto dto = new ProductDto();
		if (opt.isPresent()) {
			Product entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setCategoryId(entity.getCategory().getCategoryId());
			model.addAttribute("title", "Cập nhật danh mục");
			model.addAttribute("product", dto);
			return "admin/product/edit";
		}
		
		return "redirect:/admin/product";
	}

	@PostMapping("update/{productId}")
	public String update( @PathVariable("productId") Long productId, 
			@Validated	@ModelAttribute("product")	ProductDto dto, BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
		if (result.hasErrors()) {
			return "admin/product/edit";
		} else {
			
	
		Optional<Product> opt = productService.findById(productId);
		Product oldEntity = opt.get();
		Category category = new Category();

		if (dto.getImageFile().isEmpty()) {
			dto.setImage(oldEntity.getImage());
		} else {
			dto.setImage(dto.getImageFile().getOriginalFilename());
			String fileName = StringUtils.cleanPath(dto.getImageFile().getOriginalFilename());
			String uploadDir = "uploads/";
			FileUploadUtil.saveFile(uploadDir, fileName, dto.getImageFile());
		}

		Product entity = new Product();
		BeanUtils.copyProperties(dto, entity);
		category.setCategoryId(dto.getCategoryId());
		entity.setCategory(category);
		productService.save(entity);
		redirectAttributes.addFlashAttribute("message", "Sửa thành công");
		return "redirect:/admin/products";	}
	}

	@GetMapping("/delete/{productId}")
	public String delete(@PathVariable("productId") Long productId, RedirectAttributes redirectAttributes) {

		Optional<Product> opt = productService.findById(productId);

		Path path = Paths.get("uploads/" + opt.get().getImage());

		try {
			Files.delete(path);
		} catch (Exception e) {
			System.out.println("Lỗi" + e.getMessage());
		}

		productService.deleteById(productId);
		redirectAttributes.addFlashAttribute("message", "Xóa thành công");
		return "redirect:/admin/products";
	}



}