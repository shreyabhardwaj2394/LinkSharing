<%--
  Created by IntelliJ IDEA.
  User: Shreya
  Date: 7/11/2017
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
                <div class="panel-heading">Subscriptions</div>
                <div class="panel-body">
                    <c:forEach var="entry" items="${subscriptionList}" begin="0" end="9">
                        <div style="line-height: 1em;height: 6em;">
                            <div class="col-md-3">
                                <img src="${newUser}" alt="image-icon" class="img-thumbnail">
                            </div>
                            <span class="col-md-4" style="margin-left:-15px;"><a href="topicShow/${entry.topic.name}">${entry.topic.name}</a></span>
                            <span class="col-md-7" style="opacity:0.5;padding: 0px;">@${entry.user.username}</span>

                        </div>
                        <hr>
                    </c:forEach>
                </div>
            </div>
            <div class="panel panel-default" style="margin-top: 15px;">
                <div class="panel-heading">Trending Topics</div>
                <div class="panel-body">
                   <c:forEach var="entry" items="${publicTopics}">

                       <div style="margin-top: 10px;">
                        <div class="col-md-3">
                            <img src="${newUser}" alt="image-icon" class="img-thumbnail">
                        </div>
                        <span class="col-md-3" style="margin-left:-15px;">${entry.createdBy.firstName}${" "}${entry.createdBy.lastName}</span>
                        <span class="col-md-1" style="opacity:0.5;">@${entry.createdBy.username}</span>
                        <span style="font-weight: bold;" class="col-md-7"><a href="topicShow/${entry.name}">${entry.name}</a></span>
                           <div style="line-height: 1em;height: 4em;" class="col-md-7">(${entry.visibility})</div>

                           <c:if test="${entry.createdBy.username ne username}">

                               <div class="col-md-7" style="height: 4em;line-height: 1em;">
                               <form action="/subscribeTopic/${entry.topicId}">
                                   <select id="seriousness" name="seriousness">
                                       <option value="CASUAL">CASUAL</option>
                                       <option value="SERIOUS">SERIOUS</option>
                                       <option value="VERY_SERIOUS">VERY SERIOUS</option>
                                   </select>
                                   <input type="submit" value="Subscribe">
                               </form>
                           </div>

                           </c:if>
                       </div>

                    </c:forEach>


                </div>
            </div>
        </div>



        <div class="col-md-7">
            <div class="panel panel-default" style="margin-top: 15px;">
                <div class="panel-heading">Inbox</div>
                <div class="panel-body"></div>
            </div>
        </div>

    </div>

</div>



<div class="container">
    <!--Modals-->

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

                                <div class="col-md-8">
                                <div class="dropdown">

                                    <select name="visibility" id="visibility" class="form-control">
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

