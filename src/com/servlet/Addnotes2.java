package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entities.note;


@WebServlet("/Addnotes2")
public class Addnotes2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Addnotes2() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		note nt=new note(title, content, new Date());
		
		SessionFactory sess=new Configuration().configure().buildSessionFactory();
		Session s=sess.openSession();
		s.beginTransaction();
		
		s.save(nt);
		
		s.getTransaction().commit();
		s.close();
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<h1 style='text-align:center;'>Note is Added successfully</h1>");
		out.print("<h1 style='text-align:center;'><a href='viewall.jsp'>View all notes</a></h1>");
	}

}
