<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                <button type="button" class="btn btn-link ls pull-left"><a href="#">Link Sharing</a></button>
                <div style="margin-top: 12px;" class="pull-right">
                    <div class="col-md-1">

                        <div class="dropdown " >
                            <a class="btn dropdown-toggle" type="button" data-toggle="dropdown"><span
                                    class="glyphicon glyphicon-user"></span>${first}<span
                                    class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/profile">Profile</a></li>
                                <li><a href="#">Users</a></li>
                                <li><a href="#">Topics</a></li>
                                <li><a href="#">Posts</a></li>
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
                <div class="panel-heading">Topic:</div>
                <div class="panel-body"></div>
            </div>

            <div class="panel panel-default" style="margin-top: 15px;">
                <div class="panel-heading">Users:</div>
                <div class="panel-body"></div>
            </div>
        </div>

        <div class="col-md-7">
            <div class="panel panel-default" style="margin-top: 15px;">
                <div class="panel-heading">Posts:</div>
                <div class="panel-body"></div>
            </div>
        </div>
    </div>
</div>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
