<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous" />
            <link href="styles/produtoUnico.css" rel="stylesheet" type="text/css" />
            <title>JSP Page</title>
        </head>

        <body>
            <jsp:include page="header.jsp" />
            <main>
                <div class="container-produto">

                    <div class="image-box">
                        <img class="img-produto" src="data:image/jpeg;base64,${produto.imagemBase64}"
                            alt="${produto.nome}">
                    </div>

                    <div class="detalhes-box">
                        <div class="lenssol">
                            <p>ELITE COMPANY</p>
                            <h1>${produto.nome}</h1> <span>${produto.idProduto}</span>
                            <h4>Especificações</h4>
                            <h5 class="descricao-prod">${produto.descricao}</h5>
                            <c:choose>
                                <c:when test="${produto.promocao > 0}">
                                    <!-- <h2>R$ ${produto.valor - produto.promocao}</h2> -->
                                    <p class="text-muted"><del>R$ ${produto.valor}</del></p>
                                    <h2>R$ ${produto.valor - produto.promocao}</h2>
                                </c:when>
                                <c:otherwise>
                                    <h2>R$ ${produto.valor}</h2>
                                </c:otherwise>
                            </c:choose>
                            <form action="inserir" method="post">
                                <table cellspacing="0" class="inputs">
                                    <tr>
                                        <td><b>Qtd</b></td>
                                        <td align="right"><input type="number" min="1"  id="quantidade" name="quantidade"></td>
                                    </tr>
                                </table>
                                <input type="hidden" name="idProduto" id="idProduto" value="${produto.idProduto}">
                                <br>
                                <c:if test="${erroMsg != null}">
                                    <p>${erroMsg}</p>
                                </c:if>
                                <button type="submit">Adicionar ao Carrinho</button>
                            </form>
                        </div>
                    </div>

                </div>
            </main>
            <jsp:include page="footer.jsp"></jsp:include>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                crossorigin="anonymous"></script>
        </body>

        </html>