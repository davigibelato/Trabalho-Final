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
                <div class="container">
                    <div class="card">
                        <div class="content">
                            <div class="imgBx">
                                <img src="data:image/jpeg;base64,${produto.imagemBase64}" class="card-img-top" alt="${produto.nome}">
                            </div>
                            <div class="contentBx">
                                <h3>${produto.nome}<br><span>R$ ${produto.valor}</span></h3>
                            </div>
                        </div>
                        <ul class="sci">
                            <li>
                                <a href="./produtoUnico?id=${produto.idProduto}" class="btn btn-primary">Comprar</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </main>    
        </c:forEach>
</body>
</html>
