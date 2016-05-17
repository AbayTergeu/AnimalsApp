<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Users </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Firstname</th>
				        <th>Lastname</th>
				        <th>Email</th>
				        <th>SSO ID</th>
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${person}" var="person">
					<tr>
						<td>${person.passw}</td>
						<td>${person.passw}</td>
						<td>${person.passw}</td>
						<td>${person.passw}</td>
						<td><a href="<c:url value='/edit-user-${person.passw}' />" class="btn btn-success custom-width">edit</a></td>
						<td><a href="<c:url value='/delete-user-${person.passw}' />" class="btn btn-danger custom-width">delete</a></td>
					</tr>
				</c:forEach>

				<c:forEach items="${animalsList}" var="animalsList">
                    <tr>
                        <td>${animalsList.animalId}</td>
                        <td>${animalsList.animalName}</td>
                        <td>${animalsList.dateBirth}</td>
                        <td>${animalsList.sex}</td>
                    </tr>
                </c:forEach>

	    		</tbody>
	    	</table>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>animalId</th>
                        <th>animalName</th>
                        <th>dateBirth</th>
                        <th>sex</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>


                <c:forEach items="${animalsList}" var="animalsList">
                    <tr>
                        <td>${animalsList.animalId}</td>
                        <td>${animalsList.animalName}</td>
                        <td>${animalsList.dateBirth}</td>
                        <td>${animalsList.sex}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

	    	<td>Sam2 is: ${anex}</td>
            <td>id 36 animalId: ${animals.animalId}</td>
            <td>id 36 animalName: ${animals.animalName}</td>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/newuser' />">Add New User</a>
	 	</div>
   	</div>
</body>
</html>