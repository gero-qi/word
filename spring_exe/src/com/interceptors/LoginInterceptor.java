package com.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {
	
 
	
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Object obj = ActionContext.getContext().getSession().get("loginStaff");
		if(obj == null){
			System.out.println("session为空");
			Object action = invocation.getAction();
			if(action instanceof ActionSupport){
				ActionSupport actionsupport = (ActionSupport) action;
				actionsupport.addFieldError("", "请登录");
				
			}
			return "login";
		}
		System.out.println("sessionbuwe");
		return invocation.invoke();
	}

}
