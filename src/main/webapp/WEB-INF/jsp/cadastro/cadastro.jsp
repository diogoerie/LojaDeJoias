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
    <title>Cadastro</title>
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
<div id="login">

    <form action="/cadastro/novo" method="post" class="card-cadastro">
        <div class="card-header">
            <h2>Pagina de Cadastro</h2>
        </div>
        <div class="card-content">
            <div class="card-content-area">
                <label>Nome</label>
                <input type="text" name="nome" value="diogo">
            </div>
            <div class="card-content-area">
                <div class="card-content-area">
                    <label>Senha</label>
                    <input type="password" name="senha" value="123456">
                </div>
                <label>E-mail</label>
                <input type="email" name="email" value="diogo@gmail.com">
            </div>
            <div class="card-content-area">
                <label>Idade</label>
                <input type="text" name="idade" value="30">
            </div>
            <div class="card-footer">
                <button class="button-81" type="submit">Cadastrar</button>
            </div>
        </div>
    </form>
    <form action="/cep" class="card-cadastro" method="post">

        <c:import url="/WEB-INF/jsp/endereco/cadastro.jsp"/>
        <button class="button-81" type="submit">Buscar CEP</button>
        <br>
        <br>
    </form>
</div>
</body>
</html>
</div>

</body>

</html>
