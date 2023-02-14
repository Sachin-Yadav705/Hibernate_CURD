<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import ="org.hibernate.*"%>
<%@page import="com.entities.*" %>

    
    
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
  <h1>Update Your Note</h1>
  
  
  <%
  int noteid=Integer.parseInt(request.getParameter("note_id"));
	SessionFactory sess=new Configuration().configure().buildSessionFactory();
	Session s=sess.openSession();
	
	note nt=(note)s.get(note.class, noteid);
	
  
  %>
  <!-- FORM -->
  
  <form action="updatenote" method="post">
  <input value="<%=nt.getId()%>" name="noteid" type="hidden">
  
  <div class="form-group">
    <label for="title">Note title</label>
    <input name="title" type="text" required class="form-control" id="title"  placeholder="Enter here" value="<%=nt.getTitle()%>">
    
  </div>
  <div class="form-group">
    <label for="content">Note Content</label>
   <textarea name="content"
    required id="content" 
    placeholder="Enter your content here" 
    class="form-control" 
    style="height:250px;" ><%=nt.getContent()%></textarea>
 
 
 </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-success">Save</button>
  </div>
</form>
  </div>
  

</body>
</html>