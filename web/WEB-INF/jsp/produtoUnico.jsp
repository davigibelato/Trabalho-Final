<%-- Document : produtoUnico Created on : 06/05/2024, 14:07:11 Author : Senai --%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
        <link href="styles/produtoUnico.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <main>
            <div class="container-produto">
                <div class="right-box">
                    <div class="image-box">
                           <img src="data:image/jpeg;base64,${produto.imagemBase64}" class="card-img-top" alt="${produto.nome}">
                    </div>
                </div>
                <div class="detalhes-box">
                    <h1>${produto.nome}</h1>
                    <p>Avaliação (Em estoque)</p>
                    <h2>R$ ${produto.valor}</h2>
                    <table cellspacing="0" class="inputs">
                        <tr>
                            <td><b>Quantidade</b></td>
                            <td align="right"><input type="number" id="primeiro"></td>
                        </tr>
                        <tr>
                            <td><b>Sub Total</b></td>
                            <td align="right"><input type="number" id="segundo"></td>
                        </tr>
                    </table>
                    <h4>Especificações</h4>
                    ${produto.descricao}
                    <br>
                    <button>Adicionar ao Carrinho</button>
                    <!-- <p>Para mais informações do produto, entre em contato com a loja. Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusamus repellat ipsum aperiam minima
                        facere provident saepe quidem, officia quae iste ad totam autem doloremque perferendis nihil harum dolorem soluta eaque.</p> -->
                </div>
            </div>
        </main>
        <jsp:include page="footer.jsp"></jsp:include> 
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
