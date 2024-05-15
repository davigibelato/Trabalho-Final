<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <link href="styles/header.css" rel="stylesheet" type="text/css" />
            <link href="styles/home.css" rel="stylesheet" type="text/css"/>
            <title>Elite Tech Home</title>
        </head>

        <jsp:include page="header.jsp"></jsp:include>

        <main class="main">
            <div class="carrossel">
                <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="images/banner_img.png" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="images/banner_img2.png" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="images/banner_img3.png" class="d-block w-100" alt="...">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying"
                        data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying"
                        data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>

            <div class="orange-bar">
                <h3>MEGA PROMO</h3>
            </div>

            <div class="back-cards">
                <div class="cards">
                    <c:forEach items="${produtosPromo}" var="produto">
                        <div class="card" style="width: 18rem;">
                            <img src="data:image/jpeg;base64,${produto.imagemBase64}" class="card-img-top" alt="${produto.nome}">
                            <div class="card-body">
                              <h5 class="card-title">${produto.nome}</h5>
                              <p class="card-text">R$ ${produto.valor - produto.promocao}</p>
                              <a href="./produtoUnico?id=${produto.idProduto}" class="btn btn-primary">Comprar</a>
                            </div>
                          </div>
                    </c:forEach>
                </div>
            </div>

            <div class="bannersSecundario">
                <img id="b1" src="images/bannerSecundario.png" alt=""/>
                <img id="b2" src="images/1813.png" alt=""/>
            </div>

            <h1 class="title-h1">Destaques</h1>

            <div class="back-cards">
                <div class="cards">
                    <c:forEach items="${produtos}" var="produto">
                        <div class="card" style="width: 18rem;">
                            <img src="data:image/jpeg;base64,${produto.imagemBase64}" class="card-img-top" alt="${produto.nome}">
                            <div class="card-body">
                              <h5 class="card-title">${produto.nome}</h5>
                              <p class="card-text">R$ ${produto.valor}</p>
                              <a href="./produtoUnico?id=${produto.idProduto}" id="btn-card" class="btn btn-primary">Comprar</a>
                            </div>
                          </div>
                    </c:forEach>
                </div>
            </div>
        </main>

        <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.2.0/mdb.umd.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
        </body>
        <jsp:include page="footer.jsp"></jsp:include>
        </html>