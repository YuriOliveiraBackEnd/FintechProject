<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
<title>Sucesso Page</title>
<link rel="stylesheet" href="resources/css/telaSucesso.css">
</head>
<body>
<%@ include file="header.jsp" %>
  <div class="success-container">
        <div class="success-icon">&#10004;</div>
        <div class="success-message">Cadastrado realizado com sucesso!</div>
        <button onclick="window.location.href='index.jsp'"  class="back-to-home">Voltar à Tela de login</button>
    </div>
<%@ include file="footer.jsp" %>
</body>
</html>