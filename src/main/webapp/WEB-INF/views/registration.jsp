<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Animal Registration Form</title>
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
	<div class="well lead">Animal Registration Form</div>
 	<c:choose>
        <c:when test="${edit}">
            <c:set var="actionTxt" scope="session" value="animalUpd-${personId}-${animals.animalId}"/>
        </c:when>
        <c:otherwise>
            <c:set var="actionTxt" scope="session" value="animalCr-${personId}"/>
        </c:otherwise>
    </c:choose>
    <form:form method="POST" action="${actionTxt}" modelAttribute="animalCreateCriteria" class="form-horizontal">
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="animalName">Animal name</label>
				<div class="col-md-7">
					<form:input type="text" value = "${animals.animalName}" path="animalName" id="animalName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="animalName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="dateBirth">Date birth</label>
				<div class="col-md-7">
					<form:input type="date" value = "${animals.dateBirth}" path="dateBirth"  id="dateBirth" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="dateBirth" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="sex">Sex</label>
                <div class="col-md-7">
                    <form:input type="text" value = "${animals.sex}" path="sex" id="sex" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="sex" class="help-inline"/>
                    </div>
                </div>
			</div>
		</div>

		<div class="row">
			<div class="form-actions floatRight">
				<c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list-${personId}' />">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list-${personId}' />">Cancel</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>