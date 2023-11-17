<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucesso Page</title>
<link rel="stylesheet" href="resources/css/telaSucesso.css">
</head>
<body>
<%@ include file="header.jsp" %>
  <div class="success-container">
        <div class="success-icon">&#10004;</div>
        <div class="success-message">Rendimento cadastrado com sucesso!</div>
        <button onclick="window.location.href='index.jsp'"  class="back-to-home">Voltar à página inicial</button>
    </div>
<%@ include file="footer.jsp" %>
</body>
</html>