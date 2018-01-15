package com.jc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jc.entity.Emp;
import com.jc.entity.NoteResult;
import com.jc.service.EmpService;

@Controller//扫描控制组件
public class EmpController {
	@Resource//注入
	private EmpService empService;
	
	@RequestMapping("listEmp.do")
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception{
		empService.toFindAll(request,response);
		return "listEmp";
	}
	
	@RequestMapping("/list1.do")
	public String findPage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		empService.toFindPage(request, response);
		return "listEmp";
	}
	
	@RequestMapping("/add.do")
	public String save(HttpServletRequest request,HttpServletResponse response) throws Exception{
		empService.toSave(response,request);
		return "listEmp";
	}
	
	@RequestMapping("/delete.do")
	public String delete(HttpServletRequest request,HttpServletResponse response) throws Exception{
		empService.toDelete(request, response);
		return "listEmp";
	}
	
	@RequestMapping("/load.do")
	public String load(HttpServletRequest request,HttpServletResponse response) throws Exception{
		empService.toLoad(request, response);
		return "updateEmp";
	}
	
	@RequestMapping("/modify.do")
	public String update(HttpServletRequest request,HttpServletResponse response) throws Exception{
		empService.toUpdate(request, response);
		return "listEmp";
	}
	
	@RequestMapping("search.do")
	public String search(HttpServletRequest request,HttpServletResponse response) throws Exception{
		empService.toSearch(request, response);
		return "listSearch";
	}
}
