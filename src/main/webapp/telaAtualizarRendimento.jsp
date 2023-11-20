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

  <form action="rendimentoservlet" method = "post">
   
    <h2 class="Title">Atualizar rendimento</h2>
      <input type="hidden" value ="editar" id="titulo" name="acao">
      <input type="hidden" value ="${rendimento.id_rendimento }" id="titulo" name="id_rendimento">
      <input type="hidden" value ="${rendimento.id_usuario }" id="titulo" name="id_usuario">
     
    <label for="titulo">Título:</label>
    <input type="text" id="titulo" name="titulo"  value ="${rendimento.tx_titulo }" >

    <label for="descricao">Descrição:</label>
    <input type="text" id="descricao" name="descricao"  value ="${rendimento.descricao }" >

    <label for="categoria">Categoria:</label>
    <input type="text" id="categoria" name="categoria"  value ="${rendimento.tipo }" >

    <label for="valor">Valor:</label>
    <input type="text" id="valor" name="valor"  value ="${rendimento.valor }" >
    
    <label for="rendimento_anual">Rendimento anual:</label>
    <input type="text" id="rendimento_anual" name="rendimento_anual"  value ="${rendimento.rendimento_anual }">

    <label for="data">Data:</label>
    <input type="date" id="data" name="data"  value ="${rendimento.dt_rendimento }" >
    
     <div class = "btns">
    <button id ="btn-salvar" type="submit" class="btns-salvarCancelar">Salvar</button>
    <button id ="btn-excluir"  class="btns-salvarCancelar"><a href="rendimentoservlet?acao=listar">Cancelar</a></button>
    </div>
  </form>
</div>

  <%@ include file="footer.jsp" %>
</body>
</html>
