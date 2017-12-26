package www.geshiqi.com.caculator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCalculator extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		double firstNum = Double.parseDouble(request.getParameter("firstNum"));
		double secondNum = Double.parseDouble(request.getParameter("secondNum"));
		char[] opeartor = request.getParameter("operator").toCharArray();
		char opeart  = opeartor[0];
 
		CalculatorBean Bean = new CalculatorBean();
		Bean.setFirstNum(firstNum);
		Bean.setSecondNum(secondNum);
		Bean.setOperator(opeart);
		Bean.calculate();
		System.out.println(Bean);
		request.setAttribute("Bean", Bean);
		request.getRequestDispatcher("/calculator.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
