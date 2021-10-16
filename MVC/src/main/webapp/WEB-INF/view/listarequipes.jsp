<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/campeonato" var="endereco"/>   
    
<!DOCTYPE html>
<html>

	<head>
		<title>.:: CAMPEONATO ::.</title>
	</head>

	<body>
	
		<b>Equipes:</b><br>
	
		<ul>
		<c:forEach items="${equipes}" var="equipe">
			
			<li>
			${equipe.descricao}	
			<c:if test="${identificacao.tipo == 0}">
				<a href="${endereco}?cmd=MostrarEquipe&id=${equipe.id}">alterar</a>
				<a href="${endereco}?cmd=RemoverEquipe&id=${equipe.id}">remover</a>
			</c:if>	
			</li>
			
		</c:forEach>
		</ul>
		
		<c:if test="${identificacao.tipo == 0}"><a href="${endereco}?cmd=MostrarEquipe&id=0">adicionar</a><br></c:if>	

		<a href="${endereco}?cmd=Opcoes">menu</a>
		<a href="${endereco}?cmd=Logout">sair</a>

	</body>

</html>
