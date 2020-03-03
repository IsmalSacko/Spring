<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div class="container">
<h1 >${prenom}</h1>
<h1>La liste des taches : </h1>

	<table class="table table-striped">
	<caption>Les taches sont</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Date</th>
				<th>Statue</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${liste}" var="liste">
				<tr>
					<td>${liste.description}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${liste.targetDate}"></fmt:formatDate></td>
					<td>${liste.estEffectuée}</td>
					<td><a href="/web-application/modifier-tache?id=${liste.id}" class="btn btn-success">Modifier</a></td>
					<td><a href="/web-application/supprimer-tache?id=${liste.id}" class="btn btn-danger">Supprimer</a></td>
				</tr>			
			</c:forEach>
		</tbody>
		
	</table>
	
	<div>
		<a class="btn btn-primary" href="/web-application/ajout-liste">Ajouter</a>
		
	</div>

</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>