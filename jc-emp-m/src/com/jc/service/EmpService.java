package com.jc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

import com.jc.entity.Emp;
import com.jc.entity.NoteResult;

public interface EmpService {
	//登录
	public NoteResult checkLogin(String name,String pwd,HttpServletRequest request);
	public void toFindAll(HttpServletRequest request,HttpServletResponse response)throws Exception;
	//添加
	public void toSave(HttpServletResponse response,HttpServletRequest request) throws Exception;
	//删除
	public void toDelete(HttpServletRequest request,HttpServletResponse response) throws Exception;
	//修改
	public void toLoad(HttpServletRequest request, HttpServletResponse response) throws Exception ;
	public void toUpdate(HttpServletRequest request,HttpServletResponse response) throws Exception;
	//分页
	public void toFindPage(HttpServletRequest request,HttpServletResponse response) throws Exception;
	//搜索
	public void toSearch(HttpServletRequest request,HttpServletResponse response) throws Exception;
}

