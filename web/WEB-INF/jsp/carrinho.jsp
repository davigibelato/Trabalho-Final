<%-- 
    Document   : carrinho.jsp
    Created on : 13/05/2024, 18:50:55
    Author     : Davi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="styles/carrinho.css" rel="stylesheet" type="text/css"/>
        <title>Cart Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <main>
                <div class="global">
                    <div class="container-1">
                        <div class="itens-up">
                            <h2><i class="fa-solid fa-bag-shopping"></i>PRODUTOS</h2>
                            <p><i class="fa-solid fa-trash"></i>Remover todos os itens</p>
                        </div>

                        <p>Vendido e entregue por <b>Elite Tech</b></p>

                    <c:forEach items="${produtos}" var="produto">
                        <div class="itens-center">
                            <div class="teste">
                                <div class="img">
                                    <img src="data:image/jpeg;base64,${produto.imagemBase64}" class="card-img-top" alt="${produto.nome}">
                                </div>
                                <div class="infos-produto">
                                    <h3>${produto.nome}</h3>
                                    <div class="h3">
                                        <h3>Preço:</h3> <p class="preco">R$ ${produto.valor}</p>
                                    </div>
                                    
                                </div>
                            </div>
                            <div class="container-quantidade">
                                <div class="quantidade">
                                    <p>Quant</p> 
                                    <div class="mais-ou-menos">
                                        <button class="btns">+</button>
                                        <p class="number">1</p>
                                        <button class="btns">-</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                                <hr>
                    </c:forEach>
                </div>

                <div class="container-2">

                    <h3><i class="fa-solid fa-clipboard-check"></i>Resumo</h3>
                    <p>Sub Total:</p>
                    <p>Preço: </p>

                    <div class="entrega">
                        <p><i class="fa-solid fa-truck"></i>Entrega</p>
                        <input type="text" placeholder="CEP">
                        <button class="btns2">OK</button>
                    </div>

                    <button class="btns2">Continuar Compra</button>
                    <button class="btn-blue">Continuar Comprando</button>
                </div>
            </div>
        </main>
        
        <jsp:include page="footer.jsp"></jsp:include>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
    </body>
</html>
