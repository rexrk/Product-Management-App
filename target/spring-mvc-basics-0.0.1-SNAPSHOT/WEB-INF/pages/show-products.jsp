<%@include file="header.jspf" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</p>
<hr>
<h2>${pageTitle}</h2>
<table class="table table-bordered table-striped">
    <thead>
    <tr class="table-primary">
        <th>Serial No.</th>
        <th>Product Name</th>
        <th>Unit Price $</th>
        <th>Quantity Per Unit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="p" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td><a href="./product-details?id=${p.productId}" class="btn btn-link">${p.productName}</a></td>
            <td>${p.unitPrice}</td>
            <td>${p.quantityPerUnit}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="footer.jspf" %>