package web.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class res
 */
@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int width =100;
	     int height =50;
	     BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	     
	     Graphics graphics = image.getGraphics();
	     graphics.setColor(Color.pink);
	     graphics.fillRect(0, 0, width, height);
	     graphics.setColor(Color.red);
	     graphics.drawRect(0, 0, width-1, height-1);
	     
	     String string= "abcdefghigklmnopqrstuvwxyz0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ";
	     StringBuilder sb = new StringBuilder();
	     Random random = new Random();
	     for (int i = 1; i <= 4; i++) {
			int index = random.nextInt(string.length());
			
			char ch = string.charAt(index);
			sb.append(ch);
			graphics.drawString(ch+"", width/5*i, height/2);
		}
	     String checkcode = sb.toString();
	     request.getSession().setAttribute("checkCode", checkcode);
	     
	     for (int i = 0; i <10; i++) {
	     int x1 = random.nextInt(width);
	     int x2 = random.nextInt(width);
	     int y1 = random.nextInt(width);
	     int y2 = random.nextInt(width);
	     graphics.drawLine(x1, y1, x2, y2);
		}
	     
	     
	     ImageIO.write(image,"jpg",response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
