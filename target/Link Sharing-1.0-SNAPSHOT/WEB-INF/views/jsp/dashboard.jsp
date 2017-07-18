<%--
  Created by IntelliJ IDEA.
  User: Shreya
  Date: 7/11/2017
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
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
                <button type="button" class="btn btn-link ls pull-left"><a href="#">Link Sharing</a></button>

                <div class="move pull-right">
                <div class="col-md-1">
                    <a class="btn" role="button" data-toggle="modal"
                       data-target="#createtopicModal"> <span class="fa fa-comment"></span>
                    </a>
                </div>

                <div class="col-md-1">
                    <a class="btn" role="button" data-toggle="modal"
                       data-target="#sendinviteModal"> <span
                            class="glyphicon glyphicon-envelope"></span>
                    </a>
                </div>

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
                                class="glyphicon glyphicon-user"></span>${username}<span
                                class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Profile</a></li>
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
        <div class="col-md-4">
            <div class="panel panel-default" style="margin-top: 15px;">
                <div class="panel-body">
                    <div>
                        <div class="col-md-2">
                            <img src="${newUser}" alt="image-icon" class="img-thumbnail">
                        </div>
                        <span class="col-md-3" style="margin-left:-15px;">Uday Pratap Singh</span>
                        <span class="col-md-5" style="opacity:0.5;">@uday 5 min</span>
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
        </div>
        <div class="col-md-8">

        </div>
    </div>
</div>


<div class="container">
    <!--Modals-->
    <div class="modal fade" id="createtopicModal" tabindex="-1"
         role="dialog" aria-labelledby="createtopicModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="createtopicModalLabel">Create Topic</h4>
                </div>
                <form class="form-horizontal" action="createTopic" method="post">	<!--ACTION=createTopic-->
                    <div class="modal-body">
                        <div class="form-group" >
                            <label class="control-label col-md-4" for="topicname" >Name*</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="topicname" placeholder="Enter Name" name="name" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" >Visiblity*</label>
                            <div class="form-group">
                                <div class="dropdown">
                                    <select name="visibility" id="visibility">
                                        <option value="PUBLIC">Public</option>
                                        <option value="PRIVATE">Private</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer">

                        <button type="submit" class="btn btn-primary">Save</button>
                        <button type="button" class="btn" data-dismiss="modal">Cancel</button>

                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="sendinviteModal" tabindex="-1"
         role="dialog" aria-labelledby="sendinviteModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="sendinviteModalLabel">Send Invitation</h4>
                </div>
                <form class="form">
                    <div class="modal-body table-responsive">
                        <table class="table table-condensed">
                            <tr>
                                <td>
                                    <div class="form-group">
                                        <label for="email">E-com.MailSenderService *</label>
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <input type="email" id="email" name="email" required>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="form-group">
                                        <label for="topic">Topic *</label>
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <div class="dropdown">
                                            <button class="btn dropdown-toggle" type="button"
                                                    data-toggle="dropdown" id="topic">
                                                <span class="glyphicon glyphicon-user"></span>Topic <span
                                                    class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a href="#">sometopic</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="form-group">
                                        <button type="button" class="btn btn-info pull-left">Invite</button>
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <button type="button" class="btn btn-default pull-right"
                                                data-dismiss="modal">Cancel</button>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="modal fade" id="sharedocModal" tabindex="-1" role="dialog"
         aria-labelledby="sharedocModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="sharedocModalLabel">Share Document</h4>
                </div>
                <form class="form" action="createDocumentResource" enctype="multipart/form-data" method="post">
                    <div class="modal-body table-responsive">
                        <table class="table table-condensed">
                            <tr>
                                <td>
                                    <div class="form-group">
                                        <label for="doc">Document *</label>
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <input type="file" id="file" name="file" required>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="form-group">
                                        <label for="description">Description *</label>
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <textarea id="description" name="description"></textarea>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="form-group">
                                        <label for="docTopic">Topic *</label>
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <div class="dropdown">
                                            <button class="btn dropdown-toggle" type="button"
                                                    data-toggle="dropdown" id="topic">
                                                <span class="glyphicon glyphicon-user"></span>Topic <span
                                                    class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a href="#">sometopic</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-info pull-left">Share</button>
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <button type="button" class="btn btn-danger pull-right"
                                                data-dismiss="modal">Cancel</button>
                                    </div>
                                </td>
                            </tr>
                        </table>
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

                                        <select>
                                            <option selected="selected">Select Topic</option>
                                        <c:forEach items="${topiclist}" var="items">
                                            <option value="${items.topicId}">${items.name}</option>
                                        </c:forEach>


                                        </select>
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

