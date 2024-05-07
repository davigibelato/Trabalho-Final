<%-- 
    Document   : produtos
    Created on : 04/05/2024, 10:34:41
    Author     : Davi
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/produtos.css" rel="stylesheet" type="text/css"/>
        <title>Puxar Produto</title>
    </head>
    <body>
        <main class="main">
            <c:forEach items="${produtos}" var="produto">
                <div class='produtos'>
                    <div class="card" style="width: 18rem;">
                        <img src="data:image/jpeg;base64,${produto.imagemBase64}" class="card-img-top" alt="${produto.nome}">
                        <div class="card-body">
                            <h5 class="card-title">${produto.nome}</h5>
                            <p class="card-text">$ ${produto.valor}</p>
                            <a href="./produtoUnico?id=${produto.idProduto}" class="btn btn-primary">Comprar</a>
                        </div>
                    </div>        
                </div>
            </c:forEach>
    </body>
</html>
