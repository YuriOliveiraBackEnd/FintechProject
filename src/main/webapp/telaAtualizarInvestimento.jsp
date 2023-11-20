<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
<title>Atualizar Page</title>
 <link rel="stylesheet" href="resources/css/cadastroGasto2.css">
</head>
<body>
  <%@ include file="header.jsp" %>
  <body>
  <div>

  <form action="investimentoservlet" method = "post">
   
    <h2 class="Title">Atualizar investimento</h2>
      <input type="hidden" value ="editar" id="titulo" name="acao">
      <input type="hidden" value ="${investimento.id_investimento }" id="titulo" name="id_investimento">
      <input type="hidden" value ="${investimento.id_usuario }" id="titulo" name="id_usuario">
     
    <label for="titulo">Título:</label>
    <input type="text" id="titulo" name="titulo"  value ="${investimento.tx_titulo }" >

    <label for="descricao">Descrição:</label>
    <input type="text" id="descricao" name="descricao"  value ="${investimento.descricao }" >

    <label for="categoria">Categoria:</label>
    <input type="text" id="categoria" name="categoria"  value ="${investimento.tipo }" >

    <label for="valor">Valor:</label>
    <input type="text" id="valor" name="valor"  value ="${investimento.valor }" >

    <label for="data">Data:</label>
    <input type="date" id="data" name="data"  value ="${investimento.dt_investimento }" >
    

    
     <div class = "btns">
    <button id ="btn-salvar" type="submit" class="btns-salvarCancelar">Salvar</button>
    <button id ="btn-excluir" class="btns-salvarCancelar"><a href="investimentoservlet?acao=listar">Cancelar</a></button>
    </div>
  </form>
</div>

  <%@ include file="footer.jsp" %>
</body>
</html>
