<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/campeonato" var="endereco"/>
    
<!DOCTYPE html>
<html>

	<head>
		<title>.:: CAMPEONATO ::.</title>
	</head>

	<body>
	
		<b>Cadastro de Equipe:</b><br><br>
		
		<form action="${endereco}" method="post">
		
			Equipe: 
			
			<input type="text" name="descricao" size="15" maxlength="30" value="${descricao}" />
			<c:if test="${id > 0}">(ID ${id})</c:if>
			<br><br>			
			
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="cmd" value="CadastrarEquipe" />
			
			<c:if test="${id == 0}"> <input type="submit" value="Incluir" /> </c:if>
			<c:if test="${id >  0}"> <input type="submit" value="Alterar" /> </c:if>			
			
		</form>
		
		<br>${mensagem}<br>
		
		<a href="${endereco}?cmd=Opcoes">menu</a>
		<a href="${endereco}?cmd=Logout">sair</a>
		
	</body>

</html>
