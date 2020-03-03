<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
    rel="stylesheet">
</head>
<body>	
	<%@ include file="common/navigation.jsp"%>
<p>Modification</p>

<div class="container">

<form:form modelAttribute="liste" action="/web-application/modifier-liste" method="POST">

<fieldset class="form-group">
<!-- <form:label path="description">Description</form:label> -->
<form:input path="description" type="text" class="form-control" required="required"/>
<form:hidden path="id"/>
<form:errors path="description" cssClass="text-warning" />
</fieldset>

<!--Possibilté de modifier la date lors de la modification  -->
<fieldset class="form-group">
<form:input path="targetDate" type="text" class="form-control" required="required"/>
<form:errors path="targetDate" cssClass="text-warning" />
</fieldset>

<input type="submit" class="btn btn-success" value="Modifier"/>

</form:form>

</div>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>