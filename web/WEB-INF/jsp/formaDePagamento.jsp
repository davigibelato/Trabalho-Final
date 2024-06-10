<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="styles/formaDePagamento.css" rel="stylesheet" type="text/css"/>
        <title>Forma de Pagamento</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <main>
                <div class="box-geral">
                    <div class="box-global">                        
                        <div class="box-left">
                            <div class="teste">
                                <div class="itens">
                                    <div class="icon">
                                        <i class="fa-solid fa-envelope"></i>
                                    </div>                        
                                    <p>Email: <span>${usuario.email}</span></p>
                            </div>
                            <div class="itens">
                                <div class="icon">
                                    <i class="fa-solid fa-user"></i>
                                </div>                        
                                <p>Nome: <span>${usuario.nome}</span></p>
                            </div>
                            <div class="itens">                        
                                <div class="icon">
                                    <i class="fa-solid fa-house"></i>
                                </div>                        
                                <p>Endereço: <span>${endereco.rua}</span></p>
                            </div>
                            <div class="itens">
                                <div class="icon">
                                    <i class="fa-solid fa-location-dot"></i>
                                </div>                        
                                <p>Cep: <span>${endereco.cep}</span></p>
                            </div>
                            <div class="itens">
                                <div class="icon">
                                    <i class="fa-solid fa-phone"></i>
                                </div>                        
                                <p>Telefone: <span>${usuario.telefone}</span></p>
                            </div>
                            <div class="itens">
                                <div class="icon">
                                    <i class="fa-solid fa-truck-fast"></i>                            
                                </div>
                                <p>Chega entre 1 e 15 dias</p>
                            </div>  
                            <div class="itens">
                                <div class="icon">
                                    <i class="fa-solid fa-retweet"></i>
                                </div>                                
                                <div class="dropdown">
                                    <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        Trocar Endereço
                                    </button>
                                    <ul class="dropdown-menu">
                                        <c:forEach items="${enderecos}" var="endereco">
                                            <form method="post" action="mudarEndereco">
                                                <input type="hidden" name="idEndereco" id="idEndereco" value="${endereco.idEndereco}">
                                                <li><button type="submit" class="dropdown-item">${endereco.rua}</button>
                                            </form>                                            
                                        </c:forEach>                                       
                                    </ul>
                                </div>
                            </div>        
                        </div>
                        <div class="cartao">
                            <h3>Formas de Pagamento</h3>
                            <div class="infos-cartao">

                                <!-- <div class="box-credit">
                                    <div class="icon">
                                        <i class="fa-solid fa-credit-card"></i>
                                    </div>                            
                                    <p>Cartão de Crédito</p>
                                </div> -->
                                <div class="dropdown">
                                    <button type="button" class="btn btn-primary dropdown-toggle btn-add-payment" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="outside"><div class="box-credit">
                                            <div class="icon">
                                                <i class="fa-solid fa-credit-card"></i>
                                            </div>                            
                                            <p>Cartão de Crédito</p>
                                        </div>
                                    </button>
                                    <form class="dropdown-menu p-4">
                                        <!-- <input type="text" placeholder="Numero do Cartão" id="numeroCartao"
                                                name="numeroCartao">
                                        <input type="text" placeholder="Nome do Titular" id="nomeTitular"
                                                name="nomeTitular"> -->
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="inputGroup-sizing-default">Numero do Cartão</span>
                                            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                                        </div>
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="inputGroup-sizing-default">Nome do Titular</span>
                                            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                                        </div>
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="inputGroup-sizing-default">CVV</span>
                                            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                                        </div>
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="inputGroup-sizing-default">Data de validade</span>
                                            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Confirmar</button>
                                    </form>
                                </div>  

                                <div class="dropdown">
                                    <button type="button" class="btn btn-primary dropdown-toggle btn-add-payment" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="outside"><div class="box-credit">
                                            <div class="icon">
                                                <i class="fa-solid fa-credit-card"></i>
                                            </div>                            
                                            <p>Cartão de Debito</p>
                                        </div>
                                    </button>
                                    <form class="dropdown-menu p-4">
                                        <!-- <input type="text" placeholder="Numero do Cartão" id="numeroCartao"
                                                name="numeroCartao">
                                        <input type="text" placeholder="Nome do Titular" id="nomeTitular"
                                                name="nomeTitular"> -->
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="inputGroup-sizing-default">Numero do Cartão</span>
                                            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                                        </div>
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="inputGroup-sizing-default">Nome do Titular</span>
                                            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                                        </div>
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="inputGroup-sizing-default">CVV</span>
                                            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                                        </div>
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="inputGroup-sizing-default">Data de validade</span>
                                            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Confirmar</button>
                                    </form>
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
                                            <img src="data:image/jpeg;base64,${carrinho.imagemBase64}" class="card-img-top" alt="${carrinho.nomeProduto}">
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
                        <form action="fazerPedido" method="post">
                            <div class="box-btn">
                                <button type="submit">Fazer Pedido</button>
                            </div>
                        </form>                                            
                    </div>                      
                </div>                
            </div>            
        </main>

        <jsp:include page="footer.jsp"></jsp:include>

        <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
