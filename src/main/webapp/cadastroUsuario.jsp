<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/cadastroGasto.css">
</head>
<body>
<%@ include file="header.jsp" %>
  <body>
  <div>

  <form action="cadastrousuario" method = "post">
   
    <h2 class="Title">Cadastro de usuário</h2>

    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required>

    <label for="cpf">CPF:</label>
    <input type="text" id="cpf" name="cpf">

    
    <label for="telefone">Telefone:</label>
    <input type="number" id="telefone" name="telefone" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email">

    <label for="senha">Senha:</label>
    <input type="password" id="senha" name="senha"" required>

    
    <label for="data">Data de nascimento:</label>
    <input type="date" id="data" name="data" required>
    
  
    <button type="submit">Cadastrar</button>
  </form>
</div>

  <%@ include file="footer.jsp" %>
</body>
</html>
