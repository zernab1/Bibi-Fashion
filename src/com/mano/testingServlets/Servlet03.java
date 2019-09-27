package com.mano.testingServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet03
 */
@WebServlet("/mano1")
public class Servlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet03() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//int i = Integer.parseInt(request.getParameter("number1"));
		//int m = Integer.parseInt(request.getParameter("number2"));
		//int sum = i + m;
		PrintWriter out = response.getWriter();
		String s = "<form action=\"mano2\"> <input type= 'text' name= 'number1' value=''> <form>";
		String t = "+";
		String u = "<form> <input type= 'text' name= 'number2' value=''> <form>";
		//String v = "= " + sum;
		String w = "<form> <p></p><input type=\"submit\" value=\"Submit\"> </form>";
		out.print(s);
		out.print(t);
		out.print(u);
		//out.println(v);
		out.println(w);
	}

}
