<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <c:url value="/index.js" var="indexScriptUrl"/>
        <link rel="stylesheet" type="text/css" href="${styleUrl}">
        <script src="${indexScriptUrl}"></script>
        <title>Plaza Webapp</title>
    </head>

<body>

<div id="plaza-content">
<h2>Plaza</h2>
</div>

<div id="shops-content">
<h2>Shops</h2>
</div>

<div id="shop-content">
<h2>Shop</h2>
</div>

<div id="products-content">
<h2>Products</h2>
</div>

<div id="product-content">
<h2>Product</h2>
</div>

</body>
</html>
