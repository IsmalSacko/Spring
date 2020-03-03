	
	<%@ include file="common/header.jsp"%>
	<%@ include file="common/navigation.jsp"%>
<h1>J2EE c'est génial !!</h1>
<br>

<form action="/web-application/" method="POST">

<p><font color=red>${error_login}</font></p>

Prenom : <input name="prenom" value="Alex" type="text" />
Mot de Passe : <input name="password" value="admin" type="password" />

<input type="submit">

</form>


</body>
</html>