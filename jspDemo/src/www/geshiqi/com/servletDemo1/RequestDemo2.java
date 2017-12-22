package www.geshiqi.com.servletDemo1;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
//�����߳����߷�ֹ���ύ		
		try{
			Thread.sleep(3000);
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("�ύһ��");
		
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		String sex = request.getParameter("sex");
		String dept = request.getParameter("dept");
		String[] insts = request.getParameterValues("inst");
		String note = request.getParameter("note");
		String hiddenField = request.getParameter("hiddenField");
		String instStr="";
		//��ȡ�������ݵĻ��ɣ����Ա���insts����weinullʱ�����Ŀ�ָ���쳣����
		for(int i=0; insts!=null && i< insts.length; i++){
			if(i == insts.length-1){
				instStr+=insts[i];
			}else{
				instStr+=insts[i]+",";
				
			}
		}
		String htmlStr = "<table><tr><td>��д�ı�ţ�</td><td>{0}</td></tr>" +
				                             "<tr><td>��д���û�����</td><td>{1}</td></tr>" +
				                             "<tr><td>��д�����룺</td><td>{2}</td></tr>" +
				                             "<tr><td>ѡ�е��Ա�</td><td>{3}</td></tr>" +
				                             "<tr><td>ѡ�еĲ��ţ�</td><td>{4}</td></tr>" +
				                             "<tr><td>ѡ�е���Ȥ��</td><td>{5}</td></tr>" +
				                             "<tr><td>��д��˵����</td><td>{6}</td></tr>" +
				                             "<tr><td>����������ݣ�</td><td>{7}</td></tr>" +
				                         "</table>";
		htmlStr = MessageFormat.format(htmlStr, userid,username,userpass,sex,dept,instStr,note,hiddenField);
		//response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		out.write(htmlStr.getBytes("UTF-8"));
		
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()){
			String parameName = paramNames.nextElement();
			String parameVale = request.getParameter(parameName);
			System.out.println(MessageFormat.format("{0}={1}", parameName,parameVale));
		}
		
		//request�����װ�Ĳ�������map����ʽ�洢��
//		Map<String ,String[]> parameMap = request.getParameterMap();
//		for(Map.Entry<String, String[]> entry:parameMap.entrySet()){
//			String paramName = entry.getKey();
//			String paramValue = "";
//			String[] paramValueArr = entry.getValue();
//			for (int i=0;paramValueArr!=null && i<paramValueArr.length;i++){
//				if(i==paramValueArr.length-1){
//					paramValue+=paramValueArr[i];
//				}else{
//					paramValue+=paramValueArr[i]+",";
//				}
//			}
//			System.out.println(MessageFormat.format("{0}={1}", paramName,paramValue));
//		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
