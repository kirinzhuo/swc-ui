package com.atguigu.scw.ui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

	@RequestMapping("/test")
	public String test() {
		return "asd";
	}
}