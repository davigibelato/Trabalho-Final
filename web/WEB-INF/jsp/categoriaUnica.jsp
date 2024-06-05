<%-- 
    Document   : CategoriaUnicaController
    Created on : 05/06/2024, 19:47:31
    Author     : Davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="styles/categoriaUnica.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        
        <main>
            <div class="title">
                <h1>Nome da Categoria</h1>
            </div>
            

            <div class="box-products">

                <div class="back-cards">
                    <div class="cards">
                        <c:forEach items="${produtos}" var="produto">
                            <div class="card" style="width: 18rem;">
                                <img src="data:image/jpeg;base64,${produto.imagemBase64}" class="card-img-top" alt="${produto.nome}">
                                <div class="card-body">
                                  <h5 class="card-title">${produto.nome}</h5>
                                  <p class="card-text">R$ ${produto.valor}</p>
                                  <a href="./produtoUnico?id=${produto.idProduto}" id="btn-card" class="btn btn-primary">
                                    <i class="fa-solid fa-cart-shopping"></i>Comprar</a>
                                </div>
                              </div>
                        </c:forEach>
                    </div>
                </div>

                <div class="espaco">

                </div>

                <div class="back-cards">
                    <div class="cards">
                        <c:forEach items="${produtos}" var="produto">
                            <div class="card" style="width: 18rem;">
                                <img src="data:image/jpeg;base64,${produto.imagemBase64}" class="card-img-top" alt="${produto.nome}">
                                <div class="card-body">
                                  <h5 class="card-title">${produto.nome}</h5>
                                  <p class="card-text">R$ ${produto.valor}</p>
                                  <a href="./produtoUnico?id=${produto.idProduto}" id="btn-card" class="btn btn-primary">
                                    <i class="fa-solid fa-cart-shopping"></i>Comprar</a>
                                </div>
                              </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </main>
        
        
        
        <jsp:include page="footer.jsp"></jsp:include>
        <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>