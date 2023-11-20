<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
<title>Home Page</title>
 <link rel="stylesheet" href="resources/css/index.css">
    <script src="https://kit.fontawesome.com/78e3b8eb13.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="header.jsp" %>
 <br>
    <!-- titulo-->
   <H4 class="name">Olá,${nome}</H4>


    <!-- buttons radios -->
    
   <main class="cards-planos">
   
    <div class="cardplanos">
    <div class="card-saldo">   <span><i class="fa-solid fa-envelope " "></i> ${user}  </span></i></div>
    <div class="conteudo">
        <h3 class="titulo">Saldo em conta</h3>
        <h4 class="preco">R$ 3,50</h4>
    </div>
    <div class="sidebar"></div>
  
    
  </div>

  </main>


  <div class="slider"> <div class="slides">
    <input type="radio" name="btn-radio" id="radio1"  class="radios"/>
    <input type="radio" name="btn-radio" id="radio2"  class="radios"/>
    <input type="radio" name="btn-radio" id="radio3"  class="radios"/>
    <input type="radio" name="btn-radio" id="radio4"  class="radios"/>
    <!--fim-->
    <div class="slide_img" id="first-img"></div>
    <div class="slide_img" id="secund-img"></div>
    <div class="slide_img" id="third-img"></div>
    <div class="slide_img" id="fourth-img"></div>
    <!-- fim -->
    <!-- nav-auto -->
    <div class="nav-auto">
      <div class="btn-1"></div>
      <div class="btn-2"></div>
      <div class="btn-3"></div>
      <div class="btn-4"></div>
    </div>
    <!-- fim -->
  </div>
  <!-- botão de passar slide -->
  <div class="nav-manual" >
    <label for="radio1" class="btn-manual"></label>
    <label for="radio2" class="btn-manual"></label>
    <label for="radio3" class="btn-manual"></label>
    <label for="radio4" class="btn-manual"></label>
  </div>
</div>
<div class="programa">
    <h1>Mundo Financeiro</h1>
  </div>
  <div class="wrapper">
    <div class="card">
      <img src="resources/img/fotografico1.jpg">
      <div class="info">
        <div class="h1-card-mobile"><h1>Bolsa de valores</h1></div>
        <p>Ver mais</p>
        
      </div>
    </div>

    <div class="card">
      <img src="resources/img/fotografico2.jpg">
      <div class="info">
        <div class="h1-card-mobile"><h2>Dicas Investimentos</h2></div>
        <p>Ver mais</p>
      </div>
    </div>

    <div class="card">
      <img src="resources/img/fotografico3.jpg">
      <div class="info">
        <div class="h1-card-mobile"><h1>Dicas Financeiras</h1></div>
        <p>Ver mais</p>
      </div>
    </div>
  </div>
  <%@ include file="footer.jsp" %>

       <script src="resources/js/slider.js"></script>
</body>
</html>  