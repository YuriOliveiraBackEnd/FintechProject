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
<h1>Cartões</h1>
    <table class="table">
        <thead class="table-dark">
          <tr>
            <th scope="col">Número Cartão</th>
            <th scope="col">Nome</th>
            <th scope="col">CV</th>
            <th scope="col">Banco</th>
            <th scope="col">Bandeira</th>
            <th scope="col">Data Validade</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
        	<c:forEach items="${cartoes}" var="c">
          <tr>
             <td>${c.nr_cartao}</td>
             <td>${c.nm_pessoa}</td>
             <td>${c.cv_cartao}</td>
             <td>${c.nm_banco}</td>
             <td>${c.nm_bandeira}</td>
             <td>${c.dt_validade}</td>
             <td>
              <div class="btns">
             <button class="btn-editar">
                <c:url value="cartaoservlet" var="link">
                <c:param name="acao" value="abrir-form-edicao"/>
                <c:param name="id_cartao" value="${c.id_cartao}"/>
                </c:url>
                <a  href="${link}">Editar</a>
                </button>
                  <button id ="btn-excluir" class="btn-editar" type="button" data-toggle="modal" data-target="#excluirModal" onclick="codigoExcluir.value = ${c.id_cartao}">
                 Excluir
                </button>
                </div>
          </tr>
          </c:forEach>
        </tbody>
      </table>
        <button class="btn-login"><a href="cadastroCartao.jsp">Cadastrar cartão</a>
    </button>
      </div>
      
      <%@ include file="footer.jsp" %>
      
      <div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Deseja realmente excluir o produto?
      </div>
      <div class="modal-footer">
        <form action="cartaoservlet" method="post">
          <input type="hidden" name="acao" value="excluir">
          <input type="hidden" name="id_cartao" value="CodigoExcluir">
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
</body>
</html>