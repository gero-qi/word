package www.geshiqi.com.servletDemo1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("refresh", "5");
		BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D)image.getGraphics();
		g.setColor(Color.white);
		g.setFont(new Font(null , Font.BOLD,20));
		g.fillRect(0, 0, 80, 20);
		g.setColor(Color.BLUE);
		g.setFont(new Font(null, Font.BOLD,20));
		g.drawString(makeNum(), 0, 20);
		response.setContentType("image/jpeg");
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		ImageIO.write(image, "jpg", response.getOutputStream());
		
	}
	private String makeNum(){
		Random random = new Random();
		String num = random.nextInt(9999999)+"";
		while(num.length()<7){
			num=num+"0";
		}
		System.out.println(num);
		return num;
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
