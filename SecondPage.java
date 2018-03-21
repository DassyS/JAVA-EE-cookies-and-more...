package colorChangeCookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondPage
 */
@WebServlet("/SecondPage")
public class SecondPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String random = Integer.toString((int) Math.random()*1000); // I am not sure if it is needed		
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 String actionURL = "FirstPage";
		 String userID =CookieUtilities.getCookieValue(request, "UserID",random);
		 String backgroundColor =  CookieUtilities.getCookieValue(request, "BackgroundColor","White");
		 String foregroundColor = CookieUtilities.getCookieValue(request, "ForegroundColor","Black");
		 String docType =
				 "<!DOCTYPE html" +
				 "Transitional//EN\">\n";
		 String title = "Please Choose your Background and Foreground colors:";
		 out.println
		 (docType +
		 "<HTML>\n" +
		 "<HEAD><TITLE>\"Color Choice\"</TITLE></HEAD>\n" +
		 "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		 "<CENTER>\n" +
		 "<H1>" + title + "</H1>\n" +
		 "<FORM ACTION=\"" + actionURL + "\" method=\"get\">\n" +
		 "<label>Foreground:</label>"+
			"<select name=\"ForegroundColor\" id=\"foreground\">"+
	  "<option selected=\"selected\" value=\"Black\">Black</option>"+
	  "<option value=\"Red\">Red</option>"+
	  "<option value=\"Yellow\">Yellow</option>"+
	  "<option value=\"Green\">Green</option>"+
	"</select>"+
			"<label>Background:</label>"+
			"<select Name=\"BackgroundColor\" id=\"background\">"+
			  "<option selected=\"selected\" value=\"White\">White</option>"+
			  "<option value=\"Red\">Red</option>"+
			  "<option value=\"Yellow\">Yellow</option>"+
			  "<option value=\"Green\">Green</option>"+
			"</select>"+
		 "<INPUT TYPE=\"SUBMIT\" VALUE=\"Submit\">\n" +
		 "</FORM></CENTER></BODY></HTML>");
	 backgroundColor = request.getParameter("BackgroundColor");
	 foregroundColor = request.getParameter("ForegroundColor");
		 Cookie cookieID = new LongLivedCookie("UserID", userID);
		 response.addCookie(cookieID);
		 Cookie cookieBack = new LongLivedCookie("BackgroundColor", backgroundColor);
		 response.addCookie(cookieBack);
		 Cookie cookieFore = new LongLivedCookie("ForegroundColor",foregroundColor);
		 response.addCookie(cookieFore);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

