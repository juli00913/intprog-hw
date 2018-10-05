package com.elsys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Servlet extends HttpServlet {

	private String lastKey = "emptyt";
	private String lastValue = "empty";
	
	protected void doGet( HttpServletRequest req,
            			HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().write(
		"<html>\n" +
			"\t<body>\n" +
        		"\t\tLast key: " + lastKey + "<br>" + "Last value: " + lastValue + "<br>\n" +
    			"\t\t<form method=\"post\">\n" +
        			"\t\t\tKey: " + "<input type=\"text\" name=\"key\"><br>\n" +
        			"\t\t\tValue: " + "<input type=\"text\" name=\"value\"><br>\n" +
        			"\t\t\t<input type=\"submit\">\n" +
        		"\t\t</form>\n" +
    		"\t</body>\n" +
		"</html>\n");
}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		lastKey = req.getParameter("key");
		lastValue = req.getParameter("value");
		
		doGet(req, res);
	}
	
}
