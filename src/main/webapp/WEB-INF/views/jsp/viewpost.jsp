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
                        <a class="btn" role="button" data-toggle="modal"
                           data-target="#sharelinkModal"> <span
                                class="glyphicon glyphicon-link"></span>
                        </a>
                    </div>

                    <div class="col-md-1">
                        <a class="btn" role="button" data-toggle="modal"
                           data-target="#sharedocModal"> <span class="fa fa-file-o"></span>
                        </a>
                    </div>

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


        <div class="row">

        </div>

        



    </div>
</div>
<div class="container">
    <!--Modals-->


    <!--share document modal-->
    <div class="modal fade" id="sharedocModal" tabindex="-1" role="dialog"
         aria-labelledby="sharedocModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">                 <!--DOC SHARE-->
                <div class="modal-header">
                    <h4 class="modal-title" id="sharedocModalLabel">Share Document</h4>
                </div>
                <form class="form-horizontal" action="createDocumentResource" enctype="multipart/form-data" method="post">
                    <div class="modal-body">
                        <div class="form-group" >
                            <label class="control-label col-md-4" for="document">Document*</label>
                            <div class="col-md-8">
                                <input type="file" id="document" name="file" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="docdescription">Description*</label>

                            <div class="col-md-8">
                                <textarea id="docdescription" class="form-control" name="description" placeholder="Enter Description"></textarea>
                            </div>

                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">Topic*</label>
                            <div class="col-md-8">
                                <div class="dropdown">

                                    <select name="topicvalue" class="form-control">
                                        <option selected="selected" value="0">Select Topic</option>
                                        <c:forEach items="${topiclist}" var="items">
                                            <option value="${items.topicId}">${items.name}</option>
                                        </c:forEach>


                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">

                        <button type="submit" class="btn btn-primary">Share</button>
                        <button type="button" class="btn" data-dismiss="modal">Cancel</button>

                    </div>
                </form>
            </div>
        </div>
    </div>

    <!--SHARE LINK-->
    <div class="modal fade" id="sharelinkModal" tabindex="-1"
         role="dialog" aria-labelledby="sharelinkModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="sharelinkModalLabel">Share Link</h4>
                </div>
                <form class="form-horizontal" action="createLinkResource" method="post">   <!---CREATE LINK RESOURCE-->

                    <div class="modal-body">
                        <div class="form-group" >
                            <label class="control-label col-md-4" for="link" >Link*</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="link" placeholder="Enter Link" name="url" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="linkdescription">Description*</label>

                            <div class="col-md-8">
                                <textarea id="linkdescription" class="form-control" name="description" placeholder="Enter Description"></textarea>
                            </div>

                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">Topic*</label>
                            <div class="dropdown">
                                <div class="col-md-8">
                                    <select name="topicvalue" class="form-control">
                                        <option selected="selected" value="0">Select Topic</option>
                                        <c:forEach items="${topiclist}" var="items">
                                            <option value="${items.topicId}">${items.name}</option>
                                        </c:forEach>

                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">

                        <button type="submit" class="btn btn-primary">Share</button>
                        <button type="button" class="btn" data-dismiss="modal">Cancel</button>

                    </div>
                </form>
            </div>
        </div>
    </div>

</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
