<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="apple-touch-icon" sizes="180x180" href="/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/favicon-16x16.png">
    <link rel="stylesheet" href="style.css">
    <title>Página Inicial</title>
</head>
<body>
<header>
    <div class="containerlogo">
        <a href="/"><img src="logo.png" class="logoimg"></a>
    </div>
    <div class="menu">
        <c:if test="${not empty cadastro}">
            <ul>
                <li><a href="/listaAnel">Aneis</a></li>
                <li><a href="/listaColar">Colares</a></li>
                <li><a href="/listaPulseira">Pulseiras</a></li>
                <li><a href="/listaCliente">Clientes</a></li>
                <li><a href="/listaPedido">Pedidos</a></li>
                <li><a href="/listaProduto">Produtos</a></li>
                <c:if test="${cadastro.administrador}">
                    <li><a href="/listadecadastros">Lista</a></li>
                </c:if>
                <li><a href="/logout">Logout</a></li>
            </ul>
        </c:if>
        <c:if test="${empty fn:trim(cadastro)}">
            <ul>
                <li><a href="/login">Login</a></li>
                <li><a href="/cadastro">Cadastrar</a></li>
            </ul>
        </c:if>
    </div>
</header>
<div class="maincontent-area">
    <div class="containerprodutos">
        <h2 class="section-title">
            <c:if test="${not empty cadastro}">
                ${boasVindas}
            </c:if>
            Navegue por categoria<br>
            Escolha a joia perfeita para você brilhar!</h2>
        <div class="doisrodutos">
            <div class="border">
                <div class="sub-container">
                    <div class="zoom">
                        <img src="img/anel1.jpg" class="produto-img"></a>
                    </div>
                    <c:if test="${not empty cadastro}"><a href="/cadastroAnel"><h2>Cadastrar</h2></c:if>
                    <c:if test="${not empty cadastro}"><a href="/listaAnel"><h2>Lista</h2></c:if>
                </a>
                </div>
            </div>
            <div class="border">
                <div class="sub-container">
                    <div class="zoom">
                        <img src="img/pulseira1.jpg" class="produto-img"></a>
                    </div>
                    <c:if test="${not empty cadastro}"><a href="/cadastroPulseira"><h2>Cadastrar</h2></c:if>
                    <c:if test="${not empty cadastro}"><a href="/listaPulseira"><h2>Lista</h2></c:if>
                </a>

                </div>
            </div>
            <div class="border">
                <div class="sub-container">
                    <div class="zoom">
                        <img src="img/colar1.jpg" class="produto-img"></a>
                    </div>
                    <c:if test="${not empty cadastro}"><a href="/cadastroColar"><h2>Cadastrar</h2></c:if>
                    <c:if test="${not empty cadastro}"><a href="/listaColar"><h2>Lista</h2></c:if>
                </a>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<footer>
    <div class="main-footer">
        <div class="footer">
            <a href="/"><img src="logo.png" class="logofooter"></a>
            <p class="copy-right">&copy; 2023 ECommerce. All Rights Reserved. <a href="/" target="_blank">lojadaprata</a>
            </p>
        </div>
    </div>
</footer>
</body>

</html>
