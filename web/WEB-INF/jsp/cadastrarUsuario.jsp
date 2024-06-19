<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Font Awesome -->    
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
        <!-- MDB -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.2.0/mdb.min.css" rel="stylesheet"/>
        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <!-- Cadastrar Css -->
        <link href="styles/cadastrar.css" rel="stylesheet" type="text/css"/>     

        <script src="http://code.jquery.com/jquery-3.7.1.js"></script>
        <script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"></script>

        <title>Elite Tech</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>   

        <section class="vh-100 bg-image">
            <div class="mask d-flex align-items-center h-100 gradient-custom-3">
                <div class="container h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                            <div class="card" style="border-radius: 15px;">
                                <div class="card-body p-5">
                                    <h2 class="text-uppercase text-center mb-5">Cadastrar Usuario</h2>

                                    <%-- Mostrar mensagem de erro --%>
                                    <c:if test="${not empty errorMessage}">
                                        <div class="alert alert-danger" role="alert">
                                            ${errorMessage}
                                        </div>
                                    </c:if>

                                    <form action="cadastrar" method="post" id="formValidation">
                                        <div data-mdb-input-init class="form-outline mb-4">
                                            <input type="text" id="nome" name="nome" class="form-control form-control-lg" />
                                            <label class="form-label" for="form3Example1cg">Nome Completo</label>
                                        </div>

                                        <div data-mdb-input-init class="form-outline mb-4">
                                            <input type="email" id="email" name="email" class="form-control form-control-lg" />
                                            <label class="form-label" for="form3Example3cg">Email</label>
                                        </div>

                                        <div data-mdb-input-init class="form-outline mb-4">
                                            <input type="password" id="senha" name="senha" class="form-control form-control-lg" />
                                            <label class="form-label" for="form3Example4cg">Senha</label>
                                        </div>

                                        <div data-mdb-input-init class="form-outline mb-4">
                                            <input type="password" id="confirmarSenha" name="confirmarSenha" class="form-control form-control-lg" />
                                            <label class="form-label" for="form3Example4cdg">Confirmar Senha</label>
                                        </div>

                                        <div data-mdb-input-init class="form-outline mb-4">
                                            <input type="text" id="cpf" name="cpf" class="form-control form-control-lg" maxlength="14" />
                                            <label class="form-label" for="form3Example4cdg">CPF</label>
                                        </div>

                                        <div data-mdb-input-init class="form-outline mb-4">
                                            <input type="tel" id="telefone" name="telefone" class="form-control form-control-lg" maxlength="14"/>
                                            <label class="form-label" for="form3Example4cdg">Telefone</label>
                                        </div>

                                        <div class="form-check d-flex justify-content-center mb-5">
                                            <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3cg" />
                                            <label class="form-check-label" for="form2Example3g">
                                                Eu aceito os  <a href="#!" class="text-body"><u>Termos de serviço</u></a>
                                            </label>
                                        </div>

                                        <div class="d-flex justify-content-center">
                                            <button type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Cadastrar</button>
                                        </div>

                                        <p class="text-center text-muted mt-5 mb-0">Ja tem conta? <a href="./login" class="fw-bold text-body"><u>Login </u></a></p>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
                                    
                                    

        <jsp:include page="footer.jsp"></jsp:include>   

        <!-- Font Awesome -->
        <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
        <!-- Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <!-- MDB -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.2.0/mdb.umd.min.js"></script>
        <!-- Funções JS -->
        <script src="scripts/cadastrar.js" type="text/javascript"></script>
    </body>
</html>
