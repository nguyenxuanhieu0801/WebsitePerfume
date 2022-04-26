package com.nxh.shop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotFound {
	@RequestMapping("/404")
	public String index() {
		return "404";
	}
}
