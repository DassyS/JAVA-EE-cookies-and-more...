package colorChangeCookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class FirstPage
 */
@WebServlet("/FirstPage")
public class FirstPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstPage() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 String backgroundColor =  CookieUtilities.getCookieValue(request, "BackgroundColor","White");
		 String foregroundColor = CookieUtilities.getCookieValue(request, "ForegroundColor","Black");
		 Cookie cookieID = new LongLivedCookie("UserID", userID);
		 response.addCookie(cookieID);
		 Cookie cookieBack = new LongLivedCookie("BackgroundColor", backgroundColor);
		 response.addCookie(cookieBack);
		 Cookie cookieFore = new LongLivedCookie("ForegroundColor",foregroundColor);
		 response.addCookie(cookieFore);
		 PrintWriter out = response.getWriter();

		response.setContentType("text/html");
			out.print("<!DOCTYPE>" +
					"<html>" +
					"<head>"+
					"<meta charset=\"ISO-8859-1\">" +
					"<style>"+
					"body {"+
					"color:"+ foregroundColor+
				      "background-color:"+ backgroundColor+
					"}"+
					"</style>"+
					"<title>Cookies</title>"+
					"</head>" +
					"<body>" +
					"This is a Chometz free webpage"+
					"<a href=\"SecondPage\"> Choose your Background and Foreground colors</a>"+
					"</body>" +
					"</html>)");
	}
}
