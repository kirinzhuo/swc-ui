package com.atguigu.scw.ui.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.scw.common.vo.response.ResponseVo;

import bean.ProjectDetailsResponseVo;
import bean.ProjectResponseVo;
import bean.TReturn;

@FeignClient(value="SCW-PROJECT")
public interface ProjectInfoControllerFeign {

	@GetMapping("/getProjectDetails")
	public ResponseVo<ProjectDetailsResponseVo> getProjectDetails(@RequestParam("id")Integer id);
	
	
	@GetMapping("/getReturn")
	public ResponseVo<TReturn> getReturn(@RequestParam("id")Integer id);
	
		@GetMapping("/getAllProjects")
		public ResponseVo<List<ProjectResponseVo>> getAllProjects();
	
		
}
