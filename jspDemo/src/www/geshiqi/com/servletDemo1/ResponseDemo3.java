package www.geshiqi.com.servletDemo1;
import geshiqi.utils.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo3 extends HttpServlet {
	public static final int width = 120;
	public static final int  height = 30;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String createTypeFlag = request.getParameter("createTypeFlag");
		BufferedImage bi = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		setBackGround(g);
		setBroder(g);
		drawRandomLine(g);
		String random = DrawsImages.drawRandomNum((Graphics2D) g,createTypeFlag);
		request.getSession().setAttribute("checkcode", random);
		response.setContentType("image/jpeg");
		
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		ImageIO.write(bi, "jpg", response.getOutputStream());
		
	}

	private void drawRandomLine(Graphics g) {
		g.setColor(Color.GREEN);
		for (int i = 0; i < 5; i++) {
			int x1 = new Random().nextInt(width);
			int y1 = new Random().nextInt(height);
			int x2 = new Random().nextInt(width);
			int y2 = new Random().nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
	}

	private void setBroder(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, width - 2, height - 2);
	}

	private void setBackGround(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
	}

}
