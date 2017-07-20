<%--
  Created by IntelliJ IDEA.
  User: Shreya
  Date: 7/10/2017
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <spring:url value="/resources/core/css/ls_homepage.css" var="homeCss" />
    <spring:url value="/resources/images/newuser.jpg" var="newUser" />
    <spring:url value="/resources/core/js/index.js" var="homeJs" />
    <spring:url value="/resources/core/js/usernameAjax.js" var="usernameAjax" />
    <spring:url value="/resources/core/js/emailAjax.js" var="emailAjax" />
  <spring:url value="/resources/core/js/loginform.js" var="loginform" />
  <spring:url value="/resources/core/js/registrationform.js" var="registrationform" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="${homeCss}">
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-md-12">
      <div style="border:2px solid blue;border-radius:5px;height:55px;">
        <button type="button" class="btn btn-link" style="font-size:20px;margin-top:8px;"><a href="#">Link Sharing</a></button>
        <div class="search" style="width:35%">
          <i class="glyphicon glyphicon-search "></i>
          <input type="text" name="search" placeholder="Search" class="form-control searchinput" style="padding-left:20px;"/>
          <i class="glyphicon glyphicon-remove" style="padding-left:5px;"></i>
        </div>
      </div>
    </div>
  </div>


  <div class="row">
    <div class="col-md-7">
      <div class="panel panel-default" style="margin-top:15px;">
        <div class="panel-heading">Recent shares</div>
        <div class="panel-body">
          <c:forEach var="entry" items="${resourceList}">
          <div style="margin-top: 10px;">
            <div class="col-md-2">
              <img src="${newUser}" alt="image-icon" class="img-thumbnail">
            </div>
            <span class="col-md-3" style="margin-left:-15px;">${entry.createdBy.firstName}${" "}${entry.createdBy.lastName}</span>
            <span class="col-md-5" style="opacity:0.5;">@${entry.createdBy.username}${" "}${entry.createdBy.dateCreated}</span>
            <span style="font-weight: bold;"><a <%--href="topicShow"--%>>${entry.topic.name}</a></span>
            <div>
              <div style="line-height: 1em;height: 3em;">${entry.description}</div>
            </div>
            <div>
              <div class="col-md-2">
                <i class="fa fa-facebook-square" style="margin-left:-15px;"></i>
                <i class="fa fa-tumblr"></i>
                <i class="fa fa-google-plus"></i>
              </div>
              <span style="margin-left:295px;"><a>View Post</a></span>
            </div>
        </div>
          </c:forEach>
      </div>
      </div>
      <div class="panel panel-default" style="margin-top:15px;">
        <div class="panel-heading">Top posts
          <div style="display: inline;margin-left: 475px;">
            <select class="selectpicker" >
              <option>Today</option>
              <option>1 Day</option>
              <option>1 Week</option>
              <option>1 Year</option>
            </select>
          </div>

        </div>
        <div class="panel-body">
          <div class="col-md-2">
            <img src="${newUser}" alt="image-icon" class="img-thumbnail">
          </div>
          <span class="col-md-3" style="margin-left:-15px;">Uday Pratap Singh</span>
          <span class="col-md-5" style="opacity:0.5;">@uday 21 jun 2014</span>
          <span><a id="grails">Grails</a></span>
          <div>
            <span>Lorem ipsum dolor sit amnet, consectetur adipiscing elit.Something extra text to be displayed</span>
          </div>
          <div>
            <div class="col-md-2">
              <i class="fa fa-facebook-square" style="margin-left:-15px;"></i>
              <i class="fa fa-tumblr"></i>
              <i class="fa fa-google-plus"></i>
            </div>
            <span style="margin-left:295px;"><a>View Post</a></span>
          </div>
        </div>
      </div>

    </div>





    <div class="col-md-5">

      <div class="panel panel-default" style="margin-top:15px;">
        <div class="panel-heading">Login</div>
        <div class="panel-body">
          <form class="form-horizontal" method="post" action="login" id="loginform">
            <div class="form-group" >
              <label class="control-label col-md-4" for="loginUsername" >Email/Username*</label>
              <div class="col-md-8">
                <input type="text" class="form-control" id="loginUsername" placeholder="Enter email" name="username">
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-md-4" for="loginPassword">Password*</label>
              <div class="col-md-8">
                <input type="password" class="form-control" id="loginPassword" placeholder="Enter Password" name="password">
              </div>
            </div>
            <button type="button" class="btn btn-link" style="margin-top: 25px;"><a href="/forgotPassword">Forgot Password</a></button>
            <button type="submit" class="btn btn-default" style="margin-left: 100px;margin-top: 25px;">Login</button>
          </form>
        </div>
      </div>

      <div class="panel panel-default" style="margin-top:15px;">
        <div class="panel-heading">Register</div>
        <div class="panel-body">
          <form class="form-horizontal" method="post" action="register" enctype="multipart/form-data" id="registrationform">
            <div class="form-group" >
              <label  class="control-label col-md-4" for="fname">First Name*</label>
              <div class="col-md-8">
                <input type="text" class="form-control" id="fname" placeholder="Enter First Name" name="firstName" />
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-md-4" for="lname">Last Name*</label>
              <div class="col-md-8">
                <input type="text" class="form-control" id="lname" placeholder="Enter Last Name" name="lastName" />
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-md-4" for="mail">Email*</label>
              <div class="col-md-8">
                <input type="email" class="form-control" id="mail" placeholder="Enter email" name="email" onkeyup="checkemail();" />
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-md-4" for="username">Username*</label>
              <div class="col-md-8">
                <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" onkeyup="checkusername();"/>
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-md-4" for="reg_password">Password*</label>
              <div class="col-md-8">
                <input type="password" class="form-control" id="reg_password" placeholder="Enter password" name="password" />
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-md-4" for="confirm_password"> Confirm Password*</label>
              <div class="col-md-8">
                <input type="password" class="form-control" id="confirm_password" placeholder="Confirm password" name="confirm_password" onkeyup="checkPass(); return false;"/>
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-md-4">Photo*</label>
              <div class="col-md-8">
                <input type="file" name="file" >
              </div>
            <%--<label class="btn btn-default  btn-sm col-md-11" id="browse" style="  margin-left: -95px;width: 20%;line-height: 22px;">
                Browse<input type="file" style="display:none;" name="photo"/>
              </label>--%>
            </div>

            <button type="submit" name="register" id="register" class="btn btn-default" style="margin-left: 280px;margin-top: 15px;">Register</button>

        </form>

      </div>
    </div>

  </div>
    <div>For Username:<p id="status"></p></div>
    <div>For Email:<p id="emailstatus"></p></div>
  </div>
</div>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="${homeJs}"></script>
<script type="text/javascript" src="${usernameAjax}"></script>
<script type="text/javascript" src="${emailAjax}"></script>
<script type="text/javascript" src="${loginform}"></script>
<script type="text/javascript" src="${registrationform}"></script>
</body>
</html>

