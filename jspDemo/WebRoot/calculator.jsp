
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 

<%-- <jsp:useBean id="calcBean" class="www.geshiqi.com.caculator.CalculatorBean"/>
<jsp:setProperty name="calcBean" property="*"/>
<% 
  //使用CalculatorBean进行计算
   calcBean.calculate();
  %> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
  公式为：${ Bean 	};
  	<%--  公式为：
     <jsp:getProperty name="calcBean" property="firstNum"/>
     <jsp:getProperty name="calcBean" property="operator"/>
     <jsp:getProperty name="calcBean" property="secondNum"/>
      =
     <jsp:getProperty name="calcBean" property="result"/> --%>
  <hr size="3">
    <form action="${pageContext.request.contextPath }/servlet/ServletCalculator" method="post">
    <table>
    	<tr><td colspan="2">第一个参数</td><td><input type="text" name="firstNum"></td></tr>
    	<tr><td colspan="2">运算符</td><td><select name="operator">
    								<option value='+'>+</option>
    								<option value='-'>-</option>
    								<option value='*'>*</option>
    								<option value='/'>/</option>
    							</select></tr>	 
    	<tr><td colspan="2">第二个参数</td><td><input type="text" name="secondNum"></td></tr>
    	<tr><td><input type="submit" value="计算 "> 
    
    
    
    </table>
    </form>
  </body>
</html>
