<%-- 
    Document   : headerAdmin
    Created on : 06/05/2024, 13:47:08
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg bg-body-tertiary" id="nav-complete">
                <div class="container-fluid">
                    <a class="navbar-brand" href="./cadastrarProduto">Elite Tech</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fa-solid fa-bars"></i>
                    </button>
                    <div class="offcanvas offcanvas-end" tabindex="-1" id="navbarSupportedContent" aria-labelledby="navbarSupportedContentLabel">
                        <div class="offcanvas-header">
                            <h5 class="offcanvas-title" id="navbarSupportedContentLabel">Menu</h5>
                            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close">
                                <i class="fa-solid fa-x"></i>
                            </button>
                        </div>
                        <div class="offcanvas-body">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0" id="ul-items">
                                <li class="nav-item">
                                    <a class="nav-link" href="./listarProdutos">Listar Produtos</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="./cadastrarProduto">Cadastrar Produtos</a>
                                <li class="nav-item">
                                    <a class="nav-link" href="./login">Log-Out</a>
                                </li>
                            </ul>
                            <form class="d-flex" role="search" action="buscar" method="get">
                                <input class="form-control me-2" id="searcInput" name="termo" type="search" placeholder="Search" aria-label="Search">
                                <button id="btn-search" class="btn btn-outline-success" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                            </form>
                        </div>  
                    </div>
                </div>
            </nav>
        </header>
        <script src="https://kit.fontawesome.com/35f5de594d.js" crossorigin="anonymous"></script>
    </body>
</html>
