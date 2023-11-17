<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Erro Page</title>
<link rel="stylesheet" href="resources/css/telaErro.css">
</head>
<body>
<%@ include file="header.jsp" %>
   <div class="error-container">
        <div class="error-icon">&#9888;</div>
        <div class="error-message">Ops! Algo deu errado no seu cadastro. Tente novamente</div>
        <button onclick="window.location.href='cadastroUsuario.jsp'" class="back-to-home">Voltar à tela de cadastro</button>
    </div>
<%@ include file="footer.jsp" %>
</body>
</html>