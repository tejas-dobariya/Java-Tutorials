package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet2
 */
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Servletl</title>");
			out.println("</head>");
			out.println("<body>");

			Cookie[] cookies = request.getCookies();
			boolean f = false;
			String name = "";

			if (cookies == null) {
				out.println("<h1>You are new user go to home page and submit your name");
			} else {
				for (Cookie c : cookies) {
					String tname = c.getName();
					if (tname.equals("user_name")) {
						f = true;
						name = c.getValue();
					}
				}
			}

			if (f) {
				out.println("<h1>Hello, " + name + " welcome to my website ...</h1>");
				out.println("<h1>Thankyou</h1>");
			} else {
				out.println("<h1>You are new user go to home page and submit your name");
			}

//			out.println("<h1><a href='servlet2'> Go to servlet2</a></h1>");

			out.println("</body>");
			out.println("</html>");
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
