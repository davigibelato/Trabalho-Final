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
        <link href="styles/produtos.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Puxar Produto</title>
    </head>
    <body>
        <main class="main">
            <div class="container">
                <div class="right-box">
                    <div class="main-image-box">
                        <img src="data:image/jpeg;base64,${produto.imagemBase64}" class="card-img-top" alt="${produto.nome}">
                    </div>
                </div>
                <div class="details-box">
                    <h1>${produto.nome}</h1>
                    <h3>Preço:</h3>
                    <h3>$ ${produto.valor}</h3>
                    <button>Adicionar ao carrinho</button>
                </div>
            </div>
        </main>
    </body>
</html>
