<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
<title>Erro Page</title>
<link rel="stylesheet" href="resources/css/telaErro.css">
</head>
<body>
<%@ include file="header.jsp" %>
   <div class="error-container">
        <div class="error-icon">&#9888;</div>
        <div class="error-message">Ops! Usuário e/ou senha  incorretas.</div>
        <button onclick="window.location.href='login.jsp'" class="back-to-home">Voltar à Tela de login</button>
    </div>
<%@ include file="footer.jsp" %>
</body>
</html>