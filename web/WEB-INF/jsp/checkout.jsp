<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Checkout Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="styles/checkout.css" rel="stylesheet" type="text/css"/>
        <script src="http://code.jquery.com/jquery-3.7.1.js"></script>
        <script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"></script>
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <main>


            <div class="container-global">
                <div class="container-left">                    
                    <c:if test="${not empty errorMessage}">
                        <div class="alert alert-danger" role="alert">
                            ${errorMessage}
                        </div>
                    </c:if>
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
                            <p>R$: 20</p>
                        </div> 
                    </div>
                    <div class="box-inputs">
                        <h3>Dados para Entrega</h3>
                        <form action="inserirEndereco" method="post" onsubmit="return validarFormulario()"> 
                            <div class="inputs-1">
                                <input type="hidden" name="idUsuario" id="idUsuario" value="${idUsuario}"> 
                                <input type="text" id="estado" name="estado" placeholder="Estado" required>
                                <input type="text" id="cidade" name="cidade" placeholder="Cidade" required>
                                <input type="text" id="cep" name="cep" placeholder="CEP" required>
                                <input type="text" id="nomeRua" name="nomeRua" placeholder="Nome da rua" required>
                            </div>
                            <div class="inputs-2">
                                <input type="number" id="numeroCasa" name="numeroCasa" placeholder="Número" min="1" required>
                                <input type="text" id="complemento" name="complemento" placeholder="Complemento">
                            </div>
                            <div class="button">
                                <button type="submit">Continuar Para Pagamento</button>
                            </div>
                            <p id="texto-seila">Já possui endereço? Se sim <a href="./formaDePagamento">Clique aqui</a></p>
                        </form>
                    </div>
                </div>
            </div>
        </main>

        <%@ include file="footer.jsp" %>

        <script src="scripts/endereco.js" type="text/javascript"></script>
        <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
    </body>
</html>
