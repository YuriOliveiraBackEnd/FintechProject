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

  <form action="gastoservlet" method = "post">
   
    <h2 class="Title">Atualizar gasto</h2>
      <input type="hidden" value ="editar" id="titulo" name="acao">
      <input type="hidden" value ="${gasto.id_gasto }" id="titulo" name="id_gasto">
      <input type="hidden" value ="${gasto.id_usuario }" id="id_usuario" name="id_usuario">
      <input type="hidden" value ="${gasto.id_cartao }" id="id_cartao" name="id_cartao">

    <label for="titulo">Título:</label>
    <input type="text" id="titulo" name="titulo"  value ="${gasto.tx_titulo }" >

    <label for="descricao">Descrição:</label>
    <input type="text" id="descricao" name="descricao"  value ="${gasto.descricao }" >

    <label for="categoria">Categoria:</label>
    <input type="text" id="categoria" name="categoria"  value ="${gasto.tipo }" >

    <label for="valor">Valor:</label>
    <input type="text" id="valor" name="valor"  value ="${gasto.valor }" >

 <label for="nr_parcelas">Quantidade de parcelas:</label>
    <input type="number" id="nr_parcelas" name="nr_parcelas"  value ="${gasto.nr_parcelas }" >

    
    <label for="data">Data:</label>
    <input type="date" id="data" name="data"  value ="${gasto.dt_gasto }" >
    
    <label for="metodoPagamento">Método de Pagamento:</label>
    <select id="metodoPagamento" name="metodoPagamento"  >
      <option value="cartao">Cartão</option>
    </select>
    
     <div class = "btns">
    <button id ="btn-salvar" type="submit" class="btns-salvarCancelar">Salvar</button>
    <button id ="btn-excluir" class="btns-salvarCancelar"><a href="gastoservlet?acao=listar">Cancelar</a></button>
    </div>
  </form>
</div>

  <%@ include file="footer.jsp" %>
</body>
</html>
