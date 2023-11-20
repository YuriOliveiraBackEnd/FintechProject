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

  <form action="cartaoservlet" method = "post">
     <input type="hidden" value ="editar" id="titulo" name="acao">
      <input type="hidden" value ="${cartao.id_cartao }" id="titulo" name="id_cartao">
      <input type="hidden" value ="${cartao.id_usuario }" id="titulo" name="id_usuario">
      
       <h2 class="Title">Atualizar cartão</h2>
         
    <label for="nm_pessoa">Nome:</label>
    <input type="text" id="nm_pessoa" name="nm_pessoa" value ="${cartao.nm_pessoa }" >

    <label for="nr_cartao">Número Cartão:</label>
    <input type="text" id="nr_cartao" name="nr_cartao" value ="${cartao.nr_cartao }">

    
    <label for="dt_validade">Data validade:</label>
    <input type="text" id="dt_validade" name="dt_validade" value ="${cartao.dt_validade }" >
    
        <label for="cv_cartao">Cv Cartão:</label>
    <input type="text" id="cv_cartao" name="cv_cartao" value ="${cartao.cv_cartao }" >

       <label for="nm_banco">Nome Banco:</label>
    <select id="nm_banco" name="nm_banco"  value ="${cartao.nm_banco }">
    <option value="Banco do Brasil">Banco do Brasil</option>
      <option value="Banco Bradesco">Banco Bradesco</option>
      <option value="Itau Unibanco">Itaú Unibanco </option>
      <option value="Banco Santander">Banco Santander </option>
      <option value="Banco Safra">Banco Safra </option>
      <option value="Banco Inter">Banco Inter </option>
    </select>

    
    <label for="nm_bandeira">Nome Bandeira:</label>
    <select id="nm_bandeira" name="nm_bandeira" value ="${cartao.nm_bandeira }" >
      <option value="MasterCard">MasterCard</option>
      <option value="elo">elo</option>
      <option value="Visa">Visa</option>
      <option value="PagBank">PagBank</option>
      <option value="Hipercard">Hipercard</option>
    </select>

     <div class = "btns">
    <button id ="btn-salvar" type="submit" class="btns-salvarCancelar">Salvar</button>
    <button id ="btn-excluir" class="btns-salvarCancelar"><a href="cartaoservlet?acao=listar">Cancelar</a></button>
    </div>
  </form>
</div>

  <%@ include file="footer.jsp" %>
</body>
</html>
