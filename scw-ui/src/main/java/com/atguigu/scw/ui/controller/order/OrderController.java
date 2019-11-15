package com.atguigu.scw.ui.controller.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.scw.common.vo.response.ResponseVo;
import com.atguigu.scw.ui.service.ProjectInfoControllerFeign;
import com.atguigu.scw.ui.service.UserControllerFeign;
import com.atguigu.scw.ui.vo.response.UserResponseVo;

import bean.TMemberAddress;
import bean.TReturn;
import io.reactivex.netty.protocol.http.server.RequestHandler;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	ProjectInfoControllerFeign projectInfoControllerFeign;
	
	@Autowired
	UserControllerFeign userControllerFeign;
	///order/pay-step-2?count=
	@GetMapping("/pay-setp-2")
	public String paystep2(Integer count,HttpSession session,Model model,@RequestHeader("referer") String ref) {
		UserResponseVo user = (UserResponseVo) session.getAttribute("user");
		if(user==null) {
			String message = "结算操作请先登录";
			model.addAttribute("errorMsg", message);
			session.setAttribute("ref", ref);
			
			return "user/login";
			
		}
		String accesstoken = user.getAccesstoken();
		ResponseVo<List<TMemberAddress>> vo = userControllerFeign.getAddress(accesstoken);
		List<TMemberAddress> list = vo.getData();
		model.addAttribute("addresses", list);
		model.addAttribute("count",count);
		
		return "/order/pay-step-2";
	}
	
	
	@GetMapping("/support")
	public String support(Integer btnId, HttpSession session) {
		//查询回报信息
		ResponseVo<TReturn> vo = projectInfoControllerFeign.getReturn(btnId);
		
		
		//用项目发起人信息
		
		
		//项目信息设置到域中
		session.setAttribute("return", vo.getData());
		
		return "/order/pay-step-1";
	}
}
