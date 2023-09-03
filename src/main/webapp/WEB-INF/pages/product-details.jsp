<%@ include file="header.jspf" %>
<a>|</a>
<a href="./edit-product?id=${pr.productId}" class="btn btn-outline-primary">Edit Product</a>
</p>
<hr>
<h2>[${pr.productId}] Product Details of ${pr.productName} </h2>
<div class = "row">
    <div class="col">
        <table class="table">
            <tbody>
                <tr>
                    <td>Name</td>
                    <td>${pr.productName}</td>
                </tr>
                <tr>
                    <td>Unit Price</td>
                    <td>USD ${pr.unitPrice} $</td>
                </tr>
                <tr>
                    <td>Quantity Per Unit</td>
                    <td>${pr.quantityPerUnit}</td>
                </tr>
                <tr>
                    <td>Units in Stock</td>
                    <td>${pr.unitsInStock}</td>
                </tr>
                <tr>
                    <td>Units on order</td>
                    <td>${pr.unitsOnOrder}</td>
                </tr>
                <tr>
                    <td>Reorder Level</td>
                    <td>${pr.reorderLevel}</td>
                </tr>
                <tr>
                    <td>Discontinued</td>
                    <td>${pr.discontinued == 1 ? "Yes" : "No"}</td>
                </tr>
            </tbody>
        </table>
    </div>

    <div class="col"></div>
</div>
<%@ include file="footer.jspf" %>
