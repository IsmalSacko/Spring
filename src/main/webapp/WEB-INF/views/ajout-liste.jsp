<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div class="container">
<h2>Page ajout liste</h2>
	<div class="py-3"></div>
<form:form modelAttribute="liste" action="/web-application/ajout-liste" method="POST">
<fieldset class="form-group">
<!-- <form:label path="description">Description</form:label> -->
<form:input path="description" type="text" class="form-control" required="required"/>
<form:errors path="description" cssClass="text-warning" /></fieldset>
<input type="submit" class="btn btn-success" value="Ajouter"/>

</form:form>

</div>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>