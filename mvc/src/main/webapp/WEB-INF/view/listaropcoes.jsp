<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<c:url value="/campeonato" var="endereco"/>  

<!DOCTYPE html>
<html>

	<head>
		<title>.:: CAMPEONATO ::.</title>
	</head>

	<body>
	
		<b>Opções:</b><br>
	
		<ul>
			<li><a href="${endereco}?cmd=ListarEquipes">Equipes</a></li>
			<li><a href="${endereco}?cmd=SortearPartidas&sortear=0">Partidas</a></li>
		</ul>
		
		<a href="${endereco}?cmd=Logout">sair</a>		
		<br><br><b>${identificacao.login}</b>
		<br><fmt:formatDate value="${dia}" pattern="dd-MM-yyyy" />

	</body>

</html>
