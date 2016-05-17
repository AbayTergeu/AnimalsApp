<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>welcome page</title>

<c:url var="home" value="/" scope="request" />

<spring:url value="/static/css/app.css" var="appCss" />
<spring:url value="/static/css/bootstrap.css"
	var="bootstrapCss" />
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

<spring:url value="/static/js/jquery.1.10.2.min.js"
	var="jqueryJs" />
<spring:url value="/static/js/main.js"
	var="mainJs" />
<script src="${jqueryJs}"></script>
<script src="${mainJs}"></script>

</head>

<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
            <a class="navbar-brand" href="${home}check_login">Click for check exist or not login</a><p>
            <a class="navbar-brand" href="${home}reg">Click for registration new login</a>
		</div>
	</div>
</nav>
<div class="container" style="min-height: 500px">

	<div class="starter-template">
		<h1>Sign In Form</h1>
		<br>

		<div id="feedback"></div>


		<form:form method="POST" action="signIn" modelAttribute="personSearchCriteria" class="form-horizontal">

                <div class="form-group form-group-lg">
                    <label class="col-sm-2 control-label">Username</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="username" id="username" class="form-control input-sm"/>
                    </div>
                </div>


                <div class="form-group form-group-lg">
                    <label class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <form:input type="password" path="password" id="password" class="form-control input-sm" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="bth-search"
                            class="btn btn-primary btn-lg">Sign In</button>
                    </div>
                </div>


        	</form:form>
        	<c:choose>
                <c:when test="${hasErr}">
                    <div class="alert alert-danger lead">
                            ${errorTxt}
                    </div>
                </c:when>
                <c:otherwise>

                </c:otherwise>
            </c:choose>


	</div>

</div>
</body>
</html>
