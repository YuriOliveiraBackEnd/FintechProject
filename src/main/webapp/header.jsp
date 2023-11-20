<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
  
<html>
<head>
 <meta charset="UTF-8">
<title>Header Page</title>

  <link rel="icon" href="resources/img/favicon.ico" type="image/x-icon">
 <link rel="stylesheet" href="resources/css/header2.css">
 <script src="https://kit.fontawesome.com/78e3b8eb13.js" crossorigin="anonymous"></script>
</head>
<body>
    <!-- menu/menu responsivo -->
    <header id="header">
        <nav id="nav" class="nav-bar">
            <button id="button_mob">
                <span id="hamburgue"> </span>
            </button>
            <div class="logo">
                <img src="resources/img/Yellow Bank_claro.png" alt="">
            </div>

            <div class="nav-list" id="nav">

                <ul id="menu">
                    <li class="nav-item"><a href="index.jsp" class="nav-link">Home</a></li>
                    <li class="nav-item"><a href="gastoservlet?acao=listar" class="nav-link">Gastos </a></li>
                    <li class="nav-item"><a href="cartaoservlet?acao=listar" class="nav-link">Cartões</a></li>
                     <li class="nav-item"><a href="rendimentoservlet?acao=listar" class="nav-link">Rendimentos</a></li>
                    <li class="nav-item"><a href="investimentoservlet?acao=listar" class="nav-link">Investimentos</a></li>


                     <c:if test= "${empty user }">
                    <div class="login-button " id="login-mobile">
                        <button><a href="login.jsp">Login</a>
                        </button>
                    </div>
                    </c:if>
                         <c:if test= "${not empty user }">
                    <div class="login-button " id="login-mobile">
                        <button  ><a href="login">Logout</a>
                        </button>
                    </div>
                    </c:if>

                </ul>
            </div>
            <div class="btns">
                <div>
                    <i class="fa-solid fa-circle-user"></i>
                </div>
                <div class="mood-dark">
                    <input type="checkbox" class="checkbox" id="chk" />
                    <label class="label-mood-dark" for="chk">
                        <i class="fas fa-moon"></i>
                        <i class="fas fa-sun"></i>
                        <div class="ball"></div>
                    </label>
                </div>
                   <c:if test= "${empty user }">
                    <div class="login-button " id="login">
                        <button><a href="login.jsp">Login</a>
                        </button>
                    </div>
                    </c:if>
                         <c:if test= "${not empty user }">
                    <div class="login-button " id="login">
                        <button><a href="login">Logout</a>
                        </button>
                    </div>
                    </c:if>
            </div>


        </nav>
    </header>
       <script src="https://kit.fontawesome.com/f68320f3ea.js" crossorigin="anonymous"></script>
       <script src="resources/js/darkmode.js"></script>
       <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>

</html>
