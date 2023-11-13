<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/telaErro.css">
</head>
<body>
<%@ include file="header.jsp" %>
   <div class="error-container">
        <div class="error-icon">&#9888;</div>
        <div class="error-message">Ops! Algo deu errado no cadastro de gastos.</div>
        <button onclick="window.location.href='index.jsp'" class="back-to-home">Voltar à página inicial</button>
    </div>
<%@ include file="footer.jsp" %>
</body>
</html>