package com.jc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jc.entity.Emp;
import com.jc.entity.NoteResult;
import com.jc.service.EmpService;

@Controller//扫描控制组件
public class LoginController {
	@Resource//注入
	private EmpService empService;
	@RequestMapping("login.do")
	@ResponseBody//将返回值 NoteRusult转成json 输出
	public NoteResult login(String name,String pwd,HttpServletRequest request){
		NoteResult result=empService.checkLogin(name, pwd,request);
		return result;
	}
}

