<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="card-content">
    <div class="card-content-area">
        <br>
        <br>
        <label>Cep</label>
        <input type="text" name="cep" value="${endereco.cep}" >
    </div>
    <div class="card-content-area">
        <label>Rua</label>
        <input type="text" name="logradouro" value="${endereco.logradouro}">
    </div>
    <div class="card-content-area">
        <label>Bairro</label>
        <input type="text" name="bairro" value="${endereco.bairro}">
    </div>
    <div class="card-content-area">
        <label>Estado</label>
        <input type="text" name="uf" value="${endereco.uf}">
    </div>
    <div class="card-content-area">
        <label>Cidade</label>
        <input type="text" name="localidade" value="${endereco.localidade}">

    </div>
</div>



