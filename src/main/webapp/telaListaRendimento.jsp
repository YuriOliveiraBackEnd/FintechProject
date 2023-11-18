<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
<title>List Page</title>
 <meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <link rel="stylesheet" href="resources/css/lista.css">
</head>
<body>
<%@ include file="header.jsp" %>
 <div class="tabela">
<h1>Rendimentos</h1>
    <table class="table">
        <thead class="table-dark">
          <tr>
            <th scope="col">Título</th>
            <th scope="col">Descrição</th>
            <th scope="col">Categoria</th>
            <th scope="col">Data</th>
            <th scope="col">Valor</th>
            <th scope="col">Rendimento anual</th>
		
		
		
	
          </tr>
        </thead>
        <tbody>
        	<c:forEach items="${rendimentos}" var="r">
          <tr>
             <td>${r.tx_titulo}</td>
             <td>${r.descricao}</td>
             <td>${r.tipo}</td>
             <td>${r.dataformatada}</td>
             <td>${r.valor}</td>
             <td>${r.rendimento_anual}</td>

          </tr>
          </c:forEach>
        </tbody>
      </table>
        <button class="btn-login"><a href="cadastroRendimento.jsp">Cadastrar rendimento</a>
    </button>
      </div>
      
      <%@ include file="footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
    crossorigin="anonymous"></script>
</body>
</html>