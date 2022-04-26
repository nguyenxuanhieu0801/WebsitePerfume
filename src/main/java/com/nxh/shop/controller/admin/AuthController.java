package com.nxh.shop.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nxh.shop.domain.User;
import com.nxh.shop.model.UserDto;
import com.nxh.shop.service.UserService;

@Controller
public class AuthController {
	@Autowired
	UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	 JavaMailSender javaMailSender;

	@GetMapping("login")
	public String login(ModelMap model) {		
		
	
		if(session.getAttribute("user") != null) {
			return "redirect:/";
		}
		session.setAttribute("title", "Đăng nhập" );
		model.addAttribute("user", new UserDto());
		return "/admin/login";
	}
	
	@PostMapping("login")
	public String checkLogin(ModelMap model,@ModelAttribute("user")  UserDto dto, BindingResult result) {
		User user = userService.login(dto.getEmail(), dto.getPassword());
		
		if(dto.getEmail().trim().length() == 0) {
			result.rejectValue("email", "user", "Vui lòng nhập email");
		}
		
		if(dto.getPassword().trim().length() == 0) {
			result.rejectValue("password", "user", "Vui lòng nhập lại mật khẩu");
		}
		
		if(result.hasErrors()) {
			return "admin/login";
		}
		
		if(user == null) {
			model.addAttribute("error", "Email hoặc mật khẩu sai");
			return "redirect:/login";
		}
		session.setAttribute("user", user);
		if(user.getRole()==0) {
			return "redirect:/";
		}else {
			return "redirect:/admin/categories";
		}
		
	}
	
	@GetMapping("register")
	public String register(ModelMap model) {
		session.setAttribute("title", "Đăng ký" );
		model.addAttribute("user", new UserDto());
		return "/admin/register";
	}
	
	@PostMapping("register")
	public String checkRegister(ModelMap model,@Validated @ModelAttribute("user") UserDto dto, 
			BindingResult result, RedirectAttributes redirectAttributes) {
		Optional<User> opt = userService.findByEmail(dto.getEmail());
		if(result.hasErrors()) {
			return "admin/register";
		}
	
		if(opt.isPresent()) {
			model.addAttribute("error", "Email đã tồn tại");
			return "admin/register";

		}
					
		User entity = new User();
		BeanUtils.copyProperties(dto, entity);	
		entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		userService.save(entity);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(entity.getEmail());
		String text;
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss dd-M-yyyy");
		msg.setSubject("Đăng kí tài khoản thành công");
		text=  "Tài khoản của bạn đã được đăng kí thành công vào ngày  "+ formatter.format(entity.getCreateDate()) ;
		msg.setText(text);
		javaMailSender.send(msg);
		redirectAttributes.addFlashAttribute("message","Đăng ký thành công");
		return "redirect:/login";
	}
	
	@GetMapping("logout")
	public String logout() {
		session.removeAttribute("user");
		session.removeAttribute("cart");
		return "redirect:/";
	}

}