package servlet;

import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.YSCdb;

/**
 * Servlet implementation class getForm
 */
@WebServlet("/getForm")
public class getForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String product = request.getParameter("product");
		String email = request.getParameter("emailadd");
		String size = request.getParameter("size");
		String orientation = request.getParameter("orientation");
		String papertype = request.getParameter("papertype");
		String paperweight = request.getParameter("paperweight");
		String lamination = request.getParameter("lamination");
	
		YSCdb db = new YSCdb();
		db.insertData();
		SendEmail call = new SendEmail();
		call.sendingEmail(product, email, size, orientation, papertype, paperweight, lamination);
		
		PrintWriter test = response.getWriter();
		test.println("Thank you for your interest. We have received your enquiry and will get back to you within 3 working days");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
