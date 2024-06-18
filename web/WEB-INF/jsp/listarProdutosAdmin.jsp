<%-- 
    Document   : listarProdutos
    Created on : 04/05/2024, 08:26:24
    Author     : Davi
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="styles/produtos.css" rel="stylesheet" type="text/css" />
        <link href="styles/listarProdutos.css" rel="stylesheet" type="text/css" />
        <title>Admin Produtos</title>
    </head>
    <body>

        <jsp:include page="headerAdmin.jsp"></jsp:include>

            <main>
                <div class="container">
                <c:forEach items="${produtos}" var="produto">
                    <div class="card">
                        <div class="content">
                            <div class="imgBx">
                                <img src="data:image/jpeg;base64,${produto.imagemBase64}" class="card-img-top" alt="${produto.nome}">
                            </div>
                            <div class="contentBx">
                                <h3>${produto.nome}<br><span>R$ ${produto.valor}</span></h3>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </main>      

        <jsp:include page="footer.jsp"></jsp:include>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
