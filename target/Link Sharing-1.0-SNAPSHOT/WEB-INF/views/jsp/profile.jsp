<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Shreya
  Date: 7/20/2017
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Profile</title>
    <spring:url value="/resources/core/css/ls_dashboard.css" var="dashboardCss" />
    <spring:url value="/resources/images/newuser.jpg" var="newUser" />
    <spring:url value="/resources/core/js/passwordupdation.js" var="password" />
    <spring:url value="/resources/core/js/index.js" var="homeJs" />
    <spring:url value="/resources/core/js/registrationform.js" var="registrationform" />
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
                <div class="panel-body">
                    <div>
                        <div class="col-md-3">
                            <img src="${newUser}" alt="image-icon" class="img-thumbnail">
                        </div>
                        <span class="col-md-4" style="margin-left:-15px;">${first.concat(" ")}${last}</span>
                        <span class="col-md-7" style="opacity:0.5;padding: 0px;">@${username}</span>

                        <span class="col-md-7" style="opacity:0.5;margin-right: 2px;padding: 0px;"><a class="btn" role="button" data-toggle="modal" data-target="#subListModal">Subscriptions</a></span>
                        <span class="col-md-1" style="opacity:0.5;margin-left: 2px;padding:0px;"><a class="btn" role="button" data-toggle="modal" data-target="#topicListModal">Topics</a></span>
                        <span class="col-md-7" style="margin-right: 2px;padding-left: 30px;">${SubscriptionCount}</span><span class="col-md-1" style="margin-left: 2px;">${TopicCount}</span>
                     </div>
                </div>
             </div>

            <div class="panel panel-default" style="margin-top: 15px;">
                <div class="panel-heading">Topics</div>
                <div class="panel-body"></div>
            </div>
        </div>

        <div class="col-md-7">
            <div class="panel panel-default" style="margin-top:15px;">
                <div class="panel-heading">Profile</div>
                <div class="panel-body">
                    <form class="form-horizontal" method="post" action="updateDetails" enctype="multipart/form-data" id="registrationform">
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
                            <label class="control-label col-md-4">Photo*</label>
                            <div class="col-md-8">
                                <input type="file" name="file" >
                            </div>

                        </div>

                        <button type="submit" name="register" id="register" class="btn btn-default pull-right" style="margin-left: 280px;margin-top: 15px;">Update</button>

                    </form>

                </div>

        </div>

            <div class="panel panel-default" style="margin-top:15px;">
                <div class="panel-heading">Change Password</div>
                <div class="panel-body">
                    <form class="form-horizontal" method="post" action="updatePassword" enctype="multipart/form-data" id="passwordUpdation">

                        <div class="form-group" >
                            <label class="control-label col-md-4" for="reg_password">Password*</label>
                            <div class="col-md-8">
                                <input type="password" name="password" id="reg_password" class="form-control" placeholder="Enter password"  >
                            </div>
                        </div>
                        <div class="form-group" >
                            <label class="control-label col-md-4" for="confirm_password">Confirm Password*</label>
                            <div class="col-md-8">
                                <input type="password" name="confirm_password" id="confirm_password" class="form-control" placeholder="Confirm password" onkeyup="checkPass(); return false;"  >
                            </div>
                        </div>


                        <button type="submit" name="register" id="updatePassword" class="btn btn-default pull-right" style="margin-left: 280px;margin-top: 15px;">Update</button>

                    </form>

                </div>

            </div>
        </div>
</div>
<div class="container">
    <div class="modal fade" id="subListModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Subscription List</h4>
                </div>
                <div class="modal-body">
                    <c:forEach var="entry" items="${subscriptionList}">
                        <div>${entry.topic.name}</div>
                        <hr>
                    </c:forEach>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

    <div class="modal fade" id="topicListModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Topics Created List</h4>
                </div>
                <div class="modal-body">
                    <c:forEach var="entry" items="${createdTopicList}">
                        <div>${entry.name}</div>
                        <hr>
                    </c:forEach>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>



</div></div>
    <script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${password}"></script>
<script type="text/javascript" src="${homeJs}"></script>
<script type="text/javascript" src="${registrationform}"></script>
</body>
</html>
