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
        <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="styles/produtos.css" rel="stylesheet" type="text/css"/>
        <title>Admin Produtos</title>
    </head>
    <body>
        <jsp:include page="headerAdmin.jsp"></jsp:include>

            <main>
                <div class="produtos">
                <c:forEach items="${produtos}" var="produto">
                    <div class="card" style="width: 18rem;">
                        <img src="data:image/jpeg;base64,${produto.imagemBase64}" class="card-img-top" alt="${produto.nome}">

                        <div class="card-body">
                            <h5 class="card-title">${produto.nome}</h5>
                            <p class="card-text">Preço = $${produto.valor}</p>
                            <a href="./produtoUnico?id=${produto.idProduto}" class="btn btn-primary">Comprar/Add Carrinho</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </main>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
