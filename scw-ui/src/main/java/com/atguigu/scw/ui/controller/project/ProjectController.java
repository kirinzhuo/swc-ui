package com.atguigu.scw.ui.controller.project;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.scw.common.vo.response.ResponseVo;
import com.atguigu.scw.ui.service.ProjectInfoControllerFeign;

import bean.ProjectDetailsResponseVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectInfoControllerFeign projectInfoControllerFeign;
	@GetMapping("/projectDetails")
	public String projectDetails(Integer id,HttpSession session) {
		log.debug("id={}",id);
		ResponseVo<ProjectDetailsResponseVo> vo = projectInfoControllerFeign.getProjectDetails(id);
		session.setAttribute("project", vo.getData());
		return"project/project";
	}
}
