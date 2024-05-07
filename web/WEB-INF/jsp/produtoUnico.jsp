<%-- 
    Document   : produtoUnico
    Created on : 06/05/2024, 14:07:11
    Author     : Senai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="styles/produtoUnico.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

        <main>
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
        </main>
    </body>
</html>
