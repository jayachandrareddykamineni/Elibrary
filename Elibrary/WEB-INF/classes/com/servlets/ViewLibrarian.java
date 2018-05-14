package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.ESAPI;
import com.beans.LibrarianBean;
import com.dao.LibrarianDao;


//URL annotation
@WebServlet("/ViewLibrarian")
public class ViewLibrarian extends HttpServlet {
	
	//Servlet that displays all the Librarians present in database. It calls Dao function to retreive all the librarians from database and uses loop to display in table.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Librarian</title>");
		out.println("<link rel='stylesheet' href='styles/main.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("viewlibrarian.jsp").include(request, response);
		List<LibrarianBean> list=LibrarianDao.view();
		out.println("<table class='beta'>");

		out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Delete</th></tr>");
		for(LibrarianBean bean:list){
			// 1 NOTE: code generated by ESIDE to prevent XSS attack
                  out.println("<tr><td>" + bean.getId() + "</td><td>"
					+ ESAPI.encoder().encodeForHTMLAttribute(bean.getName()) + "</td><td>"
					+ ESAPI.encoder().encodeForHTMLAttribute(bean.getEmail()) + "</td><td>"
					+ ESAPI.encoder().encodeForHTMLAttribute(bean.getPassword()) + "</td><td>"
					+ bean.getMobile() + "</td><td><a href='EditLibrarianForm?id="
					+ bean.getId() + "'>Edit</a></td><td><a href='DeleteLibrarian?id="
					+ bean.getId() + "'>Delete</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		out.close();
	}

}
