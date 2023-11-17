<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadasto Page</title>
<link rel="stylesheet" href="resources/css/cadastroGasto.css">
</head>
<body>
  <%@ include file="header.jsp" %>
  <body>
  <div>

  <form action="cadastrocartao" method = "post">

    <h2 class="Title">Cadastro de Cart�o</h2>

    <label for="nm_pessoa">Nome:</label>
    <input type="text" id="nm_pessoa" name="nm_pessoa" required>

    <label for="nr_cartao">N�mero Cart�o:</label>
    <input type="text" id="nr_cartao" name="nr_cartao">

    
    <label for="dt_validade">Data validade:</label>
    <input type="text" id="dt_validade" name="dt_validade" required>
    
        <label for="cv_cartao">Cv Cart�o:</label>
    <input type="text" id="cv_cartao" name="cv_cartao" required>

       <label for="nm_banco">Nome Banco:</label>
    <select id="nm_banco" name="nm_banco" required>
      <option value="Banco_do_Brasil">Banco do Brasil</option>
      <option value="Banco_Bradesco">Banco Bradesco</option>
      <option value="Itau_Unibanco">Ita� Unibanco </option>
      <option value="Banco_Santander">Banco Santander </option>
      <option value="Banco_Safra">Banco Safra </option>
      <option value="Banco_Inter">Banco Inter </option>
    </select>

    
    <label for="nm_bandeira">Nome Bandeira:</label>
    <select id="nm_bandeira" name="nm_bandeira" required>
      <option value="MasterCard">MasterCard</option>
      <option value="elo">elo</option>
      <option value="Visa">Visa</option>
      <option value="PagBank">PagBank</option>
      <option value="Hipercard">Hipercard</option>
    </select>

    
    <button type="submit">Cadastrar</button>
  </form>
</div>

  <%@ include file="footer.jsp" %>
</body>
</html>