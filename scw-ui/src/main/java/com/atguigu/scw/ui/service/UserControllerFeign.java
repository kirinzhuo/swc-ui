package com.atguigu.scw.ui.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.scw.common.vo.response.ResponseVo;
import com.atguigu.scw.ui.vo.response.UserResponseVo;

import bean.TMemberAddress;
import io.swagger.annotations.ApiOperation;

@FeignClient("SCW-USER")
public interface UserControllerFeign {

	@GetMapping("/user/getAddress")
	public ResponseVo<List<TMemberAddress>> getAddress(@RequestParam("accessToken")String accessToken);
	
	
	@ApiOperation(value="登录方法")
	@PostMapping("/user/doLogin")	
	public ResponseVo<UserResponseVo> doLogin(@RequestParam("loginacct")String loginacct,@RequestParam("userpswd")String userpswd);
}
