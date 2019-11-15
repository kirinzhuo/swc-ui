package com.atguigu.scw.ui.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.scw.common.vo.response.ResponseVo;
import com.atguigu.scw.ui.service.UserControllerFeign;
import com.atguigu.scw.ui.vo.response.UserResponseVo;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	UserControllerFeign userControllerFeign;
	@PostMapping("/doLogin")
	public String doLogin(String loginacct,String userpswd,Model model,HttpSession session) {
		ResponseVo<UserResponseVo> responseVo = userControllerFeign.doLogin(loginacct, userpswd);
		if("200".equals(responseVo.getCode())) {
			UserResponseVo data = responseVo.getData();
			session.setAttribute("user", data);
			String ref = (String)session.getAttribute("ref");
			if(StringUtils.isEmpty(ref)) {
			return "redirect:/index.html";	
			}
			return "redirect:"+ref;	
		}
		String message = responseVo.getMessage();
		model.addAttribute("errorMsg", message);
		return "user/login";
	}
}
