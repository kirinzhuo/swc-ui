package com.atguigu.scw.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.scw.common.vo.response.ResponseVo;
import com.atguigu.scw.ui.service.ProjectInfoControllerFeign;

import bean.ProjectResponseVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DispatcherController {

	@Autowired
	ProjectInfoControllerFeign projectInfoControllerFeign;
	
	@RequestMapping(value= {"/" , "/index" , "/index.html"})
	public String toIndexPage(Model model) {
		ResponseVo<List<ProjectResponseVo>> vo = projectInfoControllerFeign.getAllProjects();
		log.info("查询到的项目列表：{}", vo);
		model.addAttribute("projects", vo.getData());
		return "index";
	}
	
	
}
