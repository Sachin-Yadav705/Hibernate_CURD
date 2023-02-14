<!doctype html>
<html lang="en">
  <head>
   <title>Note Taker</title>
    <%@include file="all_js_css.jsp" %>
  </head>
  <body>

 <div class="container">
  <%@include file="navbar.jsp" %>
  <br>
  <h1>Please Fill Your Note Details</h1>
  <br>
  
  <!-- FORM -->
  
  <form action="Addnotes2" method="post">
  <div class="form-group">
    <label for="title">Note title</label>
    <input name="title" type="text" required class="form-control" id="title"  placeholder="Enter here">
    
  </div>
  <div class="form-group">
    <label for="content">Note Content</label>
   <textarea name="content" required id="content" placeholder="Enter your content here" class="form-control" style="height:250px;"></textarea>
 
 </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-primary">Add</button>
  </div>
</form>
  </div>
  
  

</body>
</html>