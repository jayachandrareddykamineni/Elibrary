package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;
import com.beans.LibrarianBean;
import com.dao.LibrarianDao;


@WebServlet("/EditLibrarianForm")
public class EditLibrarianForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Servlet that takes librarian id and displays form to edit of that particular librarian. On submit this servlet calls EditLibrarian servlet.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		/* NOTE: ESIDE has created the following try catch blocks.
		 * If the generated input validation code detects a problem
		 * (e.g., malicious characters entered by user) an exception is thrown.
		 * Doing so will skip the rest of the try block code and go directly to
		 * one of the generated catch blocks below.
		 * */
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.println("<head>");
			out.println("<title>View Librarian</title>");
			out.println("<link rel='stylesheet' href='styles/main.css'/>");
			out.println("</head>");
			out.println("<body>");
			request.getRequestDispatcher("headernavadmin.jsp").include(request, response);
			String sid=ESAPI.validator().getValidInput("replace ME with validation context", request.getParameter("id"), "HTTPParameterValue", 200,
					false);
			int id=Integer.parseInt(sid);
			LibrarianBean bean=LibrarianDao.viewById(id);
			out.print("<form action='EditLibrarian' method='post' style='width:300px'>");
			// 1 NOTE: code generated by ESIDE to prevent XSS attack
			  // 1 NOTE: code generated by ESIDE
                  out.print("<input type='hidden' name='id' value='" + bean.getId() + "'/>");
			out.print("<label for='name1'>Name</label>");
			// 1 NOTE: code generated by ESIDE to prevent XSS attack
			  out.print("<input type='text'  value='" + ESAPI.encoder().encodeForHTMLAttribute(bean.getName()) + "' name='name' id='name1' placeholder='Name'/>");
			out.print("<label for='email1'>Email address</label>");
			out.print("<input type='email'  name='email' id='email1' placeholder='Email'/>");
			out.print("<label for='password1'>Password</label>");
			out.print("<input type='password'   name='password' id='password1' placeholder='Password'/>");
			out.print("<label for='mobile1'>Mobile Number</label>");
			// 1 NOTE: code generated by ESIDE to prevent XSS attack
                  out.print("<input type='tel'  value='" + bean.getMobile() + "'  name='mobile' id='mobile1' placeholder='Mobile'/>");
			out.print("<button type='submit' class='btn btn-primary'>Update</button>");
			out.print("</form>");
			request.getRequestDispatcher("footer.html").include(request, response);
			out.close();
		} catch (ValidationException e) {
			
			return;
		} catch (IntrusionException e) {
			/* This catch block will be executed when advanced 
			 * intrusion behavior is detected in ESIDE's try block statement. */ 
			
			return;
		}
	}



}
