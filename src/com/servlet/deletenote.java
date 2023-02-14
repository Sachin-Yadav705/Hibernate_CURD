package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entities.note;

/**
 * Servlet implementation class deletenote
 */
@WebServlet("/deletenote")
public class deletenote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletenote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ntid=Integer.parseInt(request.getParameter("note_id"));
		
		
		SessionFactory sess=new Configuration().configure().buildSessionFactory();
		Session s= sess.openSession();
		s.beginTransaction();
		note nt=(note)s.get(note.class, ntid);
		s.delete(nt);
		
		
		
		s.getTransaction().commit();
		s.close();
		
		response.sendRedirect("viewall.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
