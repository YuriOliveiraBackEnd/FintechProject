<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
<title>List Page</title>
 <meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <link rel="stylesheet" href="resources/css/lista2.css">
</head>
<body>
<%@ include file="header.jsp" %>
 <div class="tabela">
<h1>Gastos</h1>
    <table class="table">
        <thead class="table-dark">
          <tr>
            <th scope="col">Título</th>
            <th scope="col">Descrição</th>
            <th scope="col">Categoria</th>
            <th scope="col">Data</th>
            <th scope="col">Parcelas</th>
            <th scope="col">Valor</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
        	<c:forEach items="${gastos}" var="g">
          <tr>
             <td>${g.tx_titulo}</td>
             <td>${g.descricao}</td>
             <td>${g.tipo}</td>
             <td>${g.dataformatada}</td>
             <td>${g.nr_parcelas}</td>
             <td>${g.valor}</td>  
             <td>
              <div class="btns">
             <button class="btn-editar">
                <c:url value="gastoservlet" var="link">
                <c:param name="acao" value="abrir-form-edicao"/>
                <c:param name="id_gasto" value="${g.id_gasto}"/>
                </c:url>
                <a  href="${link}">Editar</a>
                </button>
                <button id ="btn-excluir" class="btn-editar" type="button" data-toggle="modal" data-target="#excluirModal" onclick="codigoExcluir.value = ${g.id_gasto}">
                 Excluir
                </button>
                </div>
             </td>

          </tr>
          </c:forEach>
        </tbody>
      </table>
        <button class="btn-login"><a href="cadastroGasto.jsp">Cadastrar gasto</a>
    </button>
      </div>
      
      <%@ include file="footer.jsp" %>
<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        		Deseja realmente excluir o Gasto?
      </div>
      <div class="modal-footer">
      	<form action="gastoservlet" method="post">
      		<input type="hidden" name="acao" value="excluir">
      		<input type="hidden" name="id_gasto" id="codigoExcluir">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-danger">Excluir</button>
        </form>
      </div>
    </div>
  </div>
</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
    crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>