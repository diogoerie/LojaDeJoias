<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Sua lista de produtos</title>
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
    <h2 class="section-title">Lista de produtos</h2>
    <div class="container12">
        <c:if test="${empty produtos}">
            <h3>No momento não há nem um produto cadastrado por você.</h3>
        </c:if>
            <h3>Número de produtos cadastrados por você: ${produtos.size()}.</h3>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Nome do produto</th>
                <th>Codigo do Produto</th>
                <th>Quantidade</th>
                <th>Preco</th>
                <td><a href="/produtoCadastro">Novo</a></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${produtos}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.nomeProduto}</td>
                    <td>${p.codigoProduto}</td>
                    <td>${p.quantidade}</td>
                    <td>${p.preco}</td>
                    <td><a href="/produto/${p.id}/apagar">excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
</body>

</html>
