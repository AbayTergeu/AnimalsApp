<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Check username Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<spring:url value="/static/js/jquery.1.10.2.min.js"
    	var="jqueryJs" />
    <spring:url value="/static/js/main.js"
    	var="mainJs" />
    <script src="${jqueryJs}"></script>
    <script src="${mainJs}"></script>
</head>

<body>

 	<div class="generic-container">
	<div class="well lead">Check username Form</div>
 	<form class="form-horizontal" id="search-form">
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="login">Username</label>
				<div class="col-md-7">
					<input type="text" id="login" class="form-control input-sm"/>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Check" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/reg' />">Go to registration page</a>
			</div>
		</div>
	</form>
	<div id="feedback">
    </div>
	</div>
</body>
</html>