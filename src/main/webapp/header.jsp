<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="resources/css/header.css">
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
                    <li class="nav-item"><a href="#" class="nav-link">Home</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">Serviços Contratados</a></li>
                    <li class="nav-item"><a href=href="#" class="nav-link">Buscar Serviços</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">Sobre</a></li>

                    <div class="login-button " id="login-mobile">
                        <button><a href="Login.html">Login</a>
                        </button>
                    </div>

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
                <div class="login-button" id="login">
                    <button><a href="Login.html">Login</a>
                    </button>
                </div>
            </div>


        </nav>
    </header>
     <link rel="stylesheet" href="resources/js/darkmode.js">
</body>
</html>