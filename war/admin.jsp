<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Game Closure Sim</title>
  <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
  <link href="css/bootstrap.css" rel="stylesheet" media="screen">
  <script src="js/jquery.nivo.slider.pack.js" type="text/javascript"></script>
  <script src="js/bootstrap.js"></script>
  <script src="js/admin.js"></script>

</head>

<body bgcolor="#F2F2F2">
   <div class="span9" style="margin-top:40px;">
    <input class="btn" type="button" id="start" value="Start the game">
     <div class="span9" >

      <!-- list users -->
      <table align="center" cellspacing="10">
        <c:set var="count" value="${0}"/>
        <c:forEach var="User" items="${curUsers}"> 
          <tr>
              <td><h3 style="color: #610B0B;padding:0 15px 0 15px;">${User.username}</h3></td>
              <td><h3 style="color: #610B0B;padding:0 15px 0 15px;">${User.email}</h3></td>
              <td><h3 style="color: #610B0B;padding:0 15px 0 15px;"> ${User.offer}</h3></td>
              <td><h3 style="color: #610B0B;padding:0 15px 0 15px;"> ${User.receive}</h3></td>
              <td><h3 id="result${count}" style="color: #610B0B;"> ${User.total}</h3></td>
          </tr>
          <c:set var="count" value="${count+1}"/>   
        </c:forEach> 
      </table>

    </div>
  </div>

  <footer>
    <div class="containter" align="center">
      <div class="span9 offset2" style="margin-top:20px">
        <hr>
        <p class="pull-left">Game Closure Sim.2013.</p>&nbsp; &nbsp; &nbsp;
        <p class="pull-right">Zheng Kou, Carnegie Mellon University.</p>
      </div>
    </div>  
  </footer>
</body>
</html>