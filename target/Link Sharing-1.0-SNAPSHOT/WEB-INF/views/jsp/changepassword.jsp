<%--
  Created by IntelliJ IDEA.
  User: Shreya
  Date: 7/18/2017
  Time: 1:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Forgot Password</title>
    <spring:url value="/resources/core/js/index.js" var="homeJs" />
    <spring:url value="/resources/core/js/passwordupdation.js" var="password" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-12 col-xs-12" style="margin-top: 200px;">
            <div class="panel panel-default" style="margin-left: 300px;margin-right: 300px;">
                <div class="panel-heading text-center">
                    Change Password
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" action="/changepaswd" method="post" id="passwordUpdation">
                        <div class="form-group" >
                            <label class="control-label col-md-4" for="email">Confirm Email*</label>
                            <div class="col-md-8">
                                <input type="email" name="email" id="email" class="form-control" placeholder="Enter Email"  required>
                            </div>
                        </div>
                        <div class="form-group" >
                            <label class="control-label col-md-4" for="reg_password">Password*</label>
                            <div class="col-md-8">
                                <input type="password" name="password" id="reg_password" class="form-control" placeholder="Enter password" >
                            </div>
                        </div>
                        <div class="form-group" >
                            <label class="control-label col-md-4" for="confirm_password">Confirm Password*</label>
                            <div class="col-md-8">
                                <input type="password" name="confirm_password" id="confirm_password" class="form-control" placeholder="Confirm password" onkeyup="checkPass(); return false;" >
                            </div>
                        </div>
                        <button type="submit" class="btn btn-default btn-block">Change Password</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${password}"></script>
<script type="text/javascript" src="${homeJs}"></script>
</body>
</html>
