<%--
  Created by IntelliJ IDEA.
  User: Shreya
  Date: 7/18/2017
  Time: 1:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot Password</title>
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
                    <form class="form-horizontal" action="/checkemail" method="post">
                        <div class="form-group" >
                            <label class="control-label col-md-4" for="email">Email*</label>
                            <div class="col-md-8">
                                <input type="email" name="email" id="email" class="form-control" placeholder="Enter Email"  required>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-default btn-block">Send Email</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
