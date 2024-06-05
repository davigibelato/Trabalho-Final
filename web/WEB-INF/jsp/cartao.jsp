<%-- Document : cartao Created on : 04/06/2024, 14:47:38 Author : Senai --%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

                <link href="styles/cartao.css" rel="stylesheet" type="text/css" />
                <title>Cartao Page</title>
            </head>

            <body>
                <jsp:include page="header.jsp"></jsp:include>

                <main>
                    <div class="cobertor">
                        <div class="box-geral">
                            <div class="box-left">
                                <div class="cartao">
                                    <h2>Dados do Cartão</h2>
                                    <div class="inputs">
                                        <div class="high">
                                            <input type="number" placeholder="Numero do Cartão" id="numeroCartao"
                                                name="numeroCartao">
                                            <input type="text" placeholder="Nome do Titular" id="nomeTitular"
                                                name="nomeTitular">
                                        </div>
                                        <div class="low">
                                            <input type="text" name="dataVa" id="dataVa" placeholder="Data de validade">
                                            <input type="text" name="cvv" id="cvv" placeholder="CVV">
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="box-right">
                                <div class="infos-container">
                                    <div class="infos">
                                        <c:forEach items="${carrinhos}" var="carrinho">
                                            <div class="top-infos">
                                                <div class="box-img">
                                                    <img src="data:image/jpeg;base64,${carrinho.imagemBase64}"
                                                        class="card-img-top" alt="${carrinho.nomeProduto}">
                                                </div>
                                                <div class="text">
                                                    <p>${carrinho.nomeProduto}</p>
                                                    <p>Quantidade: ${carrinho.quantidade}</p>
                                                    <p>R$: ${carrinho.subProduto}</p>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>

                                <div class="low-infos">
                                    <p>Frete: R$</p>
                                    <p class="laranja">Total: ${total}</p>
                                </div>
                                <form action="terminarCompra" method="post">
                                    <div class="box-btn">
                                        <button type="submit">Terminar Compra</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </main>
                <jsp:include page="footer.jsp"></jsp:include>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous"></script>
                <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
            </body>

            </html>