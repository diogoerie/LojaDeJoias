<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>Lista de cadastros de clientes</title>
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
    <h2 class="section-title">Lista de clientes </h2>
    <div class="container12">
        <c:if test="${empty pedidos}">
            <h3>No momento não há nem um cliente cadastrado por você.</h3>
        </c:if>
            <h3>Número de clientes cadastrados por você: ${pedidos.size()}.</h3>
        <table>
            <thead>
            <tr>
                <th>id</th>
                <th>Carrinho</th>
                <th>Codigo dos Produto</th>
                <th>Data do pedido</th>
                <td><a href="/pedido">Novo</a></td>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty pedidos}">
            <c:forEach var="p" items="${pedidos}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.carrinho}</td>
                    <td>${p.codigoProduto}</td>
                    <td>${p.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))}</td>
                    <td><a href="/pedido/${p.id}/apagar">excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </c:if>
    </div>
</div>
</body>

</html>