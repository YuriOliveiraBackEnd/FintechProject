<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Page</title>
 <link rel="stylesheet" href="resources/css/cadastroGasto.css">
</head>
<body>
  <%@ include file="header.jsp" %>
  <body>
  <div>
	
  <form action="cadastroinvestimento" method = "post">
   
    <h2 class="Title">Cadastro de investimento</h2>

    <label for="titulo">Título:</label>
    <input type="text" id="titulo" name="titulo" required>

    <label for="descricao">Descrição:</label>
    <input type="text" id="descricao" name="descricao">

    

    <label for="categoria">Categoria:</label>
    <input type="text" id="categoria" name="categoria" required>

    <label for="valor">Valor:</label>
    <input type="text" id="valor" name="valor" required>

    
    <label for="data">Data:</label>
    <input type="date" id="data" name="data" required>
   

    <button type="submit">Cadastrar</button>
  </form>
</div>

  <%@ include file="footer.jsp" %>
</body>
</html>
