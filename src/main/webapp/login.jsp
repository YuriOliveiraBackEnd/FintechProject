<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
<title>Login Page</title>
   <link rel="stylesheet" href="resources/css/login3.css">
    <script src="https://kit.fontawesome.com/78e3b8eb13.js" crossorigin="anonymous"></script>
</head>
<body>
  <%@ include file="header.jsp" %>
   <div class="main-login" id="main-login">
        <div class="left-login">
            <h1>Faça login </br>  E libere todas as funcionalidades </h1>
            <img src="resources/img/Business Plan-pana.svg" class="left-login-img" alt="animação">
        </div>
                <form action="login" method = "post" >
        <div class="right-login">
  
            <div class="card-login">
             <h1>LOGIN</h1>
                <div class="textfield">
                    <label for="usuario">Email</label>
                    <input type="text" name="email" placeholder="Email">
                    <i class="fa-solid fa-envelope " style="color:#FFD11D;;"></i>
                </div>
                <div class="textfield">
                    <label for="senha">Senha</label>
                    <input type="password" name="senha" placeholder="Senha">
                    <i class="fa-solid fa-lock " style="color: #FFD11D;"></i>
                </div>
                
                <div class="textfield">
                  <a href="cadastroUsuario.jsp" id="Cadastrarse">Cadastrar-se</a>
                </div>
                <button  type="submit" class="btn-login">Login</button>
            
            </div>
              </form>
        </div>
    </div>
           
               

    </div>

    <%@ include file="footer.jsp" %>
       <script src="resources/js/darkmode.js"></script>
</body>
</html>