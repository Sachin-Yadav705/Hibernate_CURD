package com.servlet;

import java.io.IOException;
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


@WebServlet("/updatenote")
public class updatenote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public updatenote() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			int noteid=Integer.parseInt(request.getParameter("noteid"));
			
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session s=sessionFactory.openSession();
			s.beginTransaction();
			note ntNote=s.get(note.class, noteid);
			ntNote.setTitle(title);
			ntNote.setContent(content);
			ntNote.setAddedDate(new Date());
			
			
			s.getTransaction().commit();
			s.close();
			
			response.sendRedirect("viewall.jsp");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
