<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/campeonato" var="endereco"/>
    
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>.:: CAMPEONATO ::.</title>
	</head>

	<body>
	
		<b>Autenticar Usuário:</b><br><br>
		
		<form action="${endereco}" method="post">
		
			Login: <input type="text" name="login" size="15" maxlength="30" /><br><br>
			Senha: <input type="password" name="senha" size="15" maxlength="15" /><br><br>
			
			<input type="hidden" name="cmd" value="ValidarUsuario" />
			
			<input type="submit" />
		
		</form>
		
		<br><br>"${mensagem}"
		
	</body>

</html>
