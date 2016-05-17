<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Animals List</title>
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
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Animals </span></div>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Date birth</th>
                        <th>Sex</th>
                        <th>Animal name</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>


                <c:forEach items="${animalsList}" var="animalsList">
                    <tr>
                        <td>${animalsList.animalId}</td>
                        <td>${animalsList.dateBirth}</td>
                        <td>${animalsList.sex}</td>
                        <td>${animalsList.animalName}</td>
                        <td><a href="<c:url value='/updanimal-${animalsList.animalId}-${personId}' />" class="btn btn-success custom-width">edit</a></td>
                        <td><a href="<c:url value='/delanimal-${animalsList.animalId}-${personId}' />" class="btn btn-danger custom-width">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

		</div>
	 	<div class="well">
	 		<a href="<c:url value='/newanimal-${personId}' />">Add New Animal</a>
	 	</div>
        <form id="btn-detail">
            <div class="form-group col-md-3">
                <label class="control-lable" for="parId">Enter Id animal for get detail</label>
                <input type="text" id="parId" class="custom-width">
                <button class="btn btn-success custom-width"  type="submit">Get detail</button>
            </div>
        </form>
   	</div>


</body>
</html>