<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>New Person Registration Form</title>
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
	<div class="well lead">New Person Registration Form</div>
 	<form:form method="POST" action="create_person" modelAttribute="personSearchCriteria" class="form-horizontal">
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="username">Username</label>
				<div class="col-md-7">
					<form:input type="text"  path="username" id="username" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="username" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="password">Password</label>
				<div class="col-md-7">
					<form:input type="password"  path="password"  id="password" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="password" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="passwConf">Confirm Password</label>
                <div class="col-md-7">
                    <form:input type="password"  path="passwConf"  id="passwConf" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="passwConf" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/' />">Cancel</a>
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>