<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Shreya
  Date: 7/21/2017
  Time: 12:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Topic Show</title>
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
                <button type="button" class="btn btn-link ls pull-left"><a href="/dasboard">Link Sharing</a></button>
                <div style="margin-top: 12px;" class="pull-right">
                    <div class="col-md-1">

                        <div class="dropdown " >
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
        <div class="col-md-5">
            <div class="panel panel-default" style="margin-top: 15px;">
                <div class="panel-heading">Topic:"${topicName}"</div>
                <div class="panel-body">
                    <c:forEach var="entry" items="${topicList}">
                        <div style="margin-top: 10px;">
                            <div class="col-md-3">
                                <img src="${newUser}" alt="image-icon" class="img-thumbnail">
                            </div>
                            <span class="col-md-4" style="margin-left:-15px;">${entry.name}</span>
                            <span class="col-md-7" style="opacity:0.5;padding: 0px;">(${entry.visibility})</span>
                            <span class="col-md-7" style="opacity:0.5;padding: 0px;">@${entry.createdBy.username}</span>
                           <%-- <span><a href="#">Subscribe</a></span>--%>
                        </div>
                    </c:forEach>



                </div>
            </div>

            <div class="panel panel-default" style="margin-top: 15px;">
                <div class="panel-heading">Users:"${topicName}"</div>
                <div class="panel-body">
                    <c:forEach var="entry" items="${userList}">
                        <div style="margin-top: 10px;">
                            <div class="col-md-3">
                                <img src="${newUser}" alt="image-icon" class="img-thumbnail">
                            </div>
                            <span class="col-md-4" style="margin-left:-15px;">${entry.firstName.concat(" ")}${entry.lastName}</span>
                            <span class="col-md-7" style="opacity:0.5;padding: 0px;">@${entry.username}</span>
                            <span class="col-md-7" style="margin-right: 2px;padding-left: 30px;"></span><span class="col-md-1" style="margin-left: 2px;"></span>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <div class="col-md-7">
            <div class="panel panel-default" style="margin-top: 15px;">
                <div class="panel-heading">Posts:"${topicName}"</div>
                <div class="panel-body">
                    <c:forEach var="entry" items="${resourceList}">
                    <div style="margin-top: 10px;">
                        <div class="col-md-2">
                            <img src="${newUser}" alt="image-icon" class="img-thumbnail">
                        </div>

                        <div>
                            <div style="line-height: 1em;height: 3em;">${entry.description}</div>
                        </div>
                        <div>
                            <div class="col-md-2">
                                <i class="fa fa-facebook-square" style="margin-left:-15px;"></i>
                                <i class="fa fa-tumblr"></i>
                                <i class="fa fa-google-plus"></i>
                            </div>
                            <span><a href="#">Download</a></span>
                            <span><a href="/viewPosts/${entry.resourceId}">View Post</a></span>
                            <hr>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
