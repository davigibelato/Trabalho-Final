<%-- 
    Document   : checkout
    Created on : 28/05/2024, 15:04:07
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="styles/checkout.css" rel="stylesheet" type="text/css"/>
        <title>Checkout Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <main>
                <div class="container-global">
                    <div class="container-left">
                        <h2>Entrega</h2>
                        <div class="entrega">                    
                            <div class="container-check">
                                <div class="icon">
                                    <i class="fa-regular fa-circle-check"></i>
                                </div>                                                                                  
                            </div>
                            <div class="text-entrega">
                                <p>Entrega feita por Jad Log</p> 
                                <p>O produto será entregue entre 1 e 15 dias</p>
                            </div>
                            <div class="preco-entrega">
                                <p>R$: Preço</p>
                            </div> 
                        </div>
                        <div class="box-inputs">
                            <h3>Dados para Entrega</h3>
                            <form action="inserirEndereco" method="post">
                                <div class="inputs-1">
                                    <input type="hidden" name="idUsuario" id="idUsuario" value="${idUsuario}">
                                <input type="text" id="estado" name="estado" placeholder="Estado">
                                <input type="text" id="cidade" name="cidade" placeholder="Cidade">
                                <input type="number" id="cep" name="cep" placeholder="CEP">
                                <input type="text" id="nomeRua" name="nomeRua" placeholder="Nome da rua">
                            </div>
                            <div class="inputs-2">
                                <input type="number" id="numeroCasa" name="numeroCasa" placeholder="Numero">
                                <input type="text" id="complemento" name="complemento" placeholder="Complemento">
                            </div>
                            <div class="button">
                                <button type="submit">Continuar Para Pagamento</button>
                            </div>
                                <p id="texto-seila">Ja possui endereço? Se sim <a href="./cartaoController">Clique aqui</a></p>
                        </form>

                    </div>



                </div>

            </div>
        </main>
        <jsp:include page="footer.jsp"></jsp:include>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
    </body>
</html>
