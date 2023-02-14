
<%@page import="com.sun.security.auth.NTDomainPrincipal"%>
<%@page import="com.entities.note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <%@include file="all_js_css.jsp" %>
</head>
<body>
<div class="container">
  <%@include file="navbar.jsp" %>
  <h1 class='text-uppercase'>All notes</h1>
  
  <div class="row">
  <div class="col-12"></div>
  
  <%
  SessionFactory sf=new Configuration().configure().buildSessionFactory();
 
  Session s= sf.openSession();
  s.beginTransaction();
  
  Query q=s.createQuery("from note");
  List<note> list=q.list();
  
  for(note nt:list)
  {
 
 %>
 <div class="card mt-3" style="width: 100%;" >
  <img class="card-img-top m-4 mx-auto" style="max-width:100px;" src="img/notes.png" alt="Card image cap">
  <div class="card-body px-5">
    <h5 class="card-title"><%=nt.getTitle() %></h5>
    <p class="card-text"><%=nt.getContent() %></p>
    
    <p align="right"><b class="text-primary"><%=nt.getAddedDate() %></b></p>
    
   <div class="container text-center mt-3">
    <a href="deletenote?note_id=<%=nt.getId() %>" class="btn btn-danger">Delete</a>
    <a href="editnote.jsp?note_id=<%=nt.getId() %>" class="btn btn-primary">Edit</a>
   </div>
  </div>
</div>
 
 
  <%
  }
  s.getTransaction().commit();
  s.close();
  
  
  
  
  %>
  </div>
  
  
  </div>
  
</body>
</html>