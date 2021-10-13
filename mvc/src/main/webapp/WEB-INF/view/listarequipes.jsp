<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ page import="java.util.List,br.dev.mtparreira.campeonato.model.Equipe" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>.:: CAMPEONATO ::.</title>
	</head>

	<body>
	
		<b>Lista de Equipes:</b><br>
	
		<ul>
		<c:forEach items="${equipes}" var="equipe">
			
			<li>
			${equipe.descricao}	
			<a href="/mvc/campeonato?cmd=mostrarequipe&id=${equipe.id}">editar</a>
			<a href="/mvc/campeonato?cmd=removerequipe&id=${equipe.id}">remover</a>	
			</li>
			
		</c:forEach>
		</ul>
		
		<a href="/mvc/campeonato?cmd=adicionarequipe">nova equipe</a>

	</body>

</html>
