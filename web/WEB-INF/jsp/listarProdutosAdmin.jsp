<%-- 
    Document   : listarProdutos
    Created on : 04/05/2024, 08:26:24
    Author     : Davi
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Admin Produtos</title>
    </head>
    <body>
        <jsp:include page="headerAdmin.jsp"></jsp:include>

        <main>
            <jsp:include page="produtos.jsp"></jsp:include> 
        </main>

    </body>
</html>
