<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/campeonato" var="endereco"/>   
    
<!DOCTYPE html>
<html>

	<head>
		<title>.:: CAMPEONATO ::.</title>
	</head>

	<body>
	
		<b>Partidas:</b><br>
	
		<ul>
		<c:forEach items="${partidas}" var="partida">			
			<li>${partida.a.descricao} x ${partida.b.descricao}</li>			
		</c:forEach>
		</ul>
		
		<c:if test="${identificacao.tipo == 0}"><a href="${endereco}?cmd=SortearPartidas&sortear=1">sortear</a><br></c:if>		
		
		<a href="${endereco}?cmd=Opcoes">menu</a>
		<a href="${endereco}?cmd=Logout">sair</a>

	</body>

</html>
