<%--
  Created by IntelliJ IDEA.
  User: Shreya
  Date: 7/21/2017
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>View Post</title>
    <spring:url value="/resources/core/css/ls_dashboard.css" var="dashboardCss" />
    <spring:url value="/resources/images/newuser.jpg" var="newUser" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css"
          type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.css">
    <link rel="stylesheet" href="${dashboardCss}">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div id="top">
                <button type="button" class="btn btn-link ls pull-left"><a href="/dashbaord">Link Sharing</a></button>

                <div class="move pull-right">


                    <div class="col-md-1">
                        <div class="dropdown">
                            <a class="btn dropdown-toggle" type="button" data-toggle="dropdown"><span
                                    class="glyphicon glyphicon-user"></span>${first}<span
                                    class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/editprofile">Edit Profile</a></li>
                                <li><a href="#">Profile</a></li>
                                <li><a href="/logout">Logout</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>


        </div>



        </div>

    <div class="row">
        <div style="margin-top: 10px;">
            <div class="col-md-8">
                <div class="panel panel-default">
                    <div class="panel-body">

                        <div>
                            <div class="col-md-3">
                                <img src="${newUser}" alt="image-icon" class="img-thumbnail">
                            </div>
                            <span class="col-md-4" style="margin-left:-15px;">${resoucre.createdBy.firstName}${" "}${resoucre.createdBy.lastName}</span>
                            <span class="col-md-4" style="margin-left:-15px;">${resoucre.topic.name}</span>
                            <span class="col-md-7" style="opacity:0.5;padding: 0px;">@${resoucre.createdBy.username}</span>
                            <span class="col-md-7" style="opacity:0.5;padding: 0px;">${resoucre.createdBy.dateCreated}</span>
                            <div class="col-md-7" style="line-height: 1em;height: 6em;margin-top: 4px;">${resoucre.description}</div>
                            <div class="col-md-3" style="margin-top: 4px;">
                                <i class="fa fa-facebook-square" style="margin-left:-15px;"></i>
                                <i class="fa fa-tumblr"></i>
                                <i class="fa fa-google-plus"></i>
                            </div>
                        </div>



                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Trending Topics</div>
                    <div class="panel-body"></div>
                </div>
            </div>
        </div>
    </div>



    </div>
</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
