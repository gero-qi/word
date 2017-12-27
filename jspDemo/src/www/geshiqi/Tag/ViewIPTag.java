package www.geshiqi.Tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class ViewIPTag implements Tag{
	private PageContext pageContext;

	public int doEndTag() throws JspException {
		System.out.println("调用doEndTag（）方法");
		return 0;
	}

	public int doStartTag() throws JspException {
		 System.out.println("调用doStartTag（）方法");
		 HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		 JspWriter out = pageContext.getOut();
		 String ip = request.getRemoteAddr();
		 try{
			 out.write(ip);
		 }catch (Exception e){
			 throw new RuntimeException(e);
			 
		 }
		return 0;
	}

	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void release() {
		System.out.println("release方法调用");
		
	}

	public void setPageContext(PageContext pageContext) {
		System.out.println("setPageContext(PageContext pageContext)");
		this.pageContext = pageContext;
		
	}

	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
