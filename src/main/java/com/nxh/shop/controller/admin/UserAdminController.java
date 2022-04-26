package com.nxh.shop.controller.admin;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nxh.shop.domain.User;
import com.nxh.shop.model.UserDto;
import com.nxh.shop.service.UserService;

@Controller
@RequestMapping("admin/users")
public class UserAdminController {

	@Autowired
	UserService userService;

	@Autowired
	private HttpSession session;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;


	@GetMapping("")
	public String list(ModelMap model, @RequestParam("page") Optional<Integer> page) {
		int currentPage;
		if (page.isEmpty()) {
			currentPage = 0;
		} else {
			currentPage = page.get() - 1;
		}

		Pageable pageable = PageRequest.of(currentPage, 10, Direction.DESC, "userId");
		Page<User> pageList = userService.findAll(pageable);
		List<User> list = pageList.getContent();
		int totalPage = pageList.getTotalPages();
		int totalItems = pageList.getTotalPages();
		session.setAttribute("title", "Danh sách người dùng");
		model.addAttribute("users", list);
		model.addAttribute("currentPage", currentPage + 1);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPage", totalPage);
		return "admin/user/list";
	}

	@GetMapping("/edit/{userId}")
	public String edit(ModelMap model, @PathVariable("userId") Long userId) {
		Optional<User> opt = userService.findById(userId);
		UserDto dto = new UserDto();
		if (opt.isPresent()) {
			User entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setPassword("");
			session.setAttribute("title", "Cập nhật người dùng");
			model.addAttribute("user", dto);
			return "admin/user/edit";
		}
		return "redirect:/admin/users";
	}

	@PostMapping("update/{userId}")
	public String update(ModelMap model, @PathVariable("userId") Long userId, UserDto dto, BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if(dto.getName().trim().length() == 0) {
			result.rejectValue("name", "user", "Vui lòng nhập tên");
		}
		
		if(dto.getAddress().trim().length() == 0) {
			result.rejectValue("address", "user", "Vui lòng nhập địa chỉ");
		}
		
		if(dto.getPhone().trim().length() == 0) {
			result.rejectValue("phone", "user", "Vui lòng nhập số điện thoại");
		}
		
		User entity = userService.findById(userId).get();				
		entity.setName(dto.getName());			
		entity.setPhone(dto.getPhone());
		entity.setAddress(dto.getAddress());
		entity.setSex(dto.isSex());
		entity.setRole(dto.getRole());
		if(!dto.getPassword().isEmpty()) {
			entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		}
		userService.save(entity);
		redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
		return "redirect:/admin/users/edit/{userId}";

	}

	@GetMapping("/delete/{userId}")
	public String delete(@PathVariable("userId") Long userId, RedirectAttributes redirectAttributes) {
		userService.deleteById(userId);
		redirectAttributes.addFlashAttribute("message", "Xóa thành công");
		return "redirect:/admin/users";
	}

}