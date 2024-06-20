<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
        <!-- MDB -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.2.0/mdb.min.css" rel="stylesheet" />
        <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <link href="styles/cadastrar.css" rel="stylesheet" type="text/css" />
        <link href="styles/header.css" rel="stylesheet" type="text/css" />
        <title>Elite Tech</title>
    </head>

    <body>
        <jsp:include page="headerAdmin.jsp"></jsp:include>

            <div class="content-cadProduto">
                <section class="vh-100 bg-image">
                    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
                        <div class="container h-100">
                            <div class="row d-flex justify-content-center align-items-center h-100">
                                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                                    <div class="card" style="border-radius: 15px;">
                                        <div class="card-body p-5">
                                            <h2 class="text-uppercase text-center mb-5">Cadastrar Produto</h2>

                                            <form action="cadastrarProduto" method="post" enctype="multipart/form-data">

                                                <div data-mdb-input-init class="form-outline mb-4">
                                                    <input type="text" id="nome" name="nome"
                                                           class="form-control form-control-lg" />
                                                    <label class="form-label" for="form3Example1cg">Nome</label>
                                                </div>

                                                <div data-mdb-input-init class="form-outline mb-4">
                                                    <input type="number" min="1" id="valor" name="valor"
                                                           class="form-control form-control-lg" />
                                                    <label class="form-label" for="form3Example3cg">Valor</label>
                                                </div>

                                                <div data-mdb-input-init class="form-outline mb-4">
                                                    <input type="number" min="1" id="quantidade" name="quantidade"
                                                           class="form-control form-control-lg" />
                                                    <label class="form-label" for="form3Example3cg">Quantidade de Produtos</label>
                                                </div>

                                                <div data-mdb-input-init class="form-outline mb-4">
                                                    <input type="number" id="promocao" name="promocao"
                                                           class="form-control form-control-lg" />
                                                    <label class="form-label" for="form3Example3cg">Promocao</label>
                                                </div>

                                                <div data-mdb-input-init class="form-outline mb-4">
                                                    <input type="descricao" id="valor" name="descricao"
                                                           class="form-control form-control-lg" />
                                                    <label class="form-label" for="form3Example3cg">Descrição</label>
                                                </div>

                                                <div data-mdb-input-init class="form-outline mb-4">
                                                    <label class="form-label" for="form3Example4cg">Categoria</label>
                                                    <select name="categoria" id="categoria">
                                                    <c:forEach items="${categorias}" var="categoria">
                                                        <option value="${categoria.idCategoria}">${categoria.nome}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>

                                            <div data-mdb-input-init class="form-outline mb-4">
                                                <label class="form-label"
                                                       for="form3Example4cdg">SubCategoria</label>
                                                <select name="subCategoria" id="subCategoria">
                                                    <c:forEach items="${subCategorias}" var="subCategoria">
                                                        <option value="${subCategoria.idSubCategoria}">
                                                            ${subCategoria.nome}</option>
                                                        </c:forEach>
                                                </select>
                                            </div>

                                            <div class="d-flex justify-content-center ">
                                                <div>
                                                    <label class="form-label">Imagem</label>
                                                    <input type="file" id="imagem" name="imagem" required
                                                           accept="image/*"
                                                           class="form-control form-control-lg input-img-cad"
                                                           onchange="displaySelectedImage(event, 'selectedImage')" />
                                                </div>
                                            </div>

                                            <div class="d-flex justify-content-center">
                                                <button type="submit"
                                                        class="btn btn-success btn-block btn-lg gradient-custom-4 text-body btn-cadastrar">Cadastrar</button>
                                            </div>

                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <div class="cont-produto-cad">
                <img id="selectedImage" src="https://mdbootstrap.com/img/Photos/Others/placeholder.jpg"
                     alt="example placeholder" class="img-produto-cad" />

            </div>
            <script>
                function displaySelectedImage(event, imageId) {
                    const selectedImage = document.getElementById(imageId);
                    const file = event.target.files[0];
                    const reader = new FileReader();

                    reader.onload = function () {
                        selectedImage.src = reader.result;
                    }

                    if (file) {
                        reader.readAsDataURL(file);
                    }
                }
            </script>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>
        <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.2.0/mdb.umd.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    </body>

</html>