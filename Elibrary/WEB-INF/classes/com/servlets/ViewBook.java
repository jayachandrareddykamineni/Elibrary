package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.owasp.esapi.ESAPI;
import com.beans.BookBean;
import com.beans.LibrarianBean;
import com.dao.BookDao;
import com.dao.LibrarianDao;

//URL annotation
@WebServlet("/ViewBook")
public class ViewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ViewBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	//Servlet that displays all the books available in database. It calls Dao function to retreive all the books from database and uses loop to display in table.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Session tracking
		HttpSession session = request.getSession();
		if (session != null) {
			if (session.getAttribute("email") != null) {
				String name = (String) session.getAttribute("email");
				
			} else {
				response.sendRedirect("index.jsp");
			}
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Librarian</title>");
		out.println("<link rel='stylesheet' href='styles/main.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("viewbook.jsp").include(request, response);
		List<BookBean> list=BookDao.view();
		
		out.println("<table class='beta'>");

		out.println("<tr><th>Aileno</th><th>Name</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th><th>Delete</th></tr>");
		for(BookBean bean:list){
			// 1 NOTE: code generated by ESIDE to prevent XSS attack
                  out.println("<tr><td>" + ESAPI.encoder().encodeForHTMLAttribute(bean.getAileno()) + "</td><td>"
					+ ESAPI.encoder().encodeForHTMLAttribute(bean.getName()) + "</td><td>"
					+ ESAPI.encoder().encodeForHTMLAttribute(bean.getAuthor()) + "</td><td>"
					+ ESAPI.encoder().encodeForHTMLAttribute(bean.getPublisher()) + "</td><td>"
					+ bean.getQuantity() + "</td><td>"
					+ bean.getIssued() + "</td><td><a href='DeleteBook?aileno="
					+ ESAPI.encoder().encodeForHTMLAttribute(bean.getAileno()) + "'>Delete</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		out.close();
	}
	}

	
	