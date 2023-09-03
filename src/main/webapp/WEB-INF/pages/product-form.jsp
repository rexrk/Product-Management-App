<%@ include file="header.jspf" %>
</p>
<hr>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="row">
    <div class="col">
        <sf:form modelAttribute="pr" action="save-product">
            <sf:hidden path="productId"/>
            <div class="form-group row">
                <label class="col-md-4" for="productName">Product Name :</label>
                <div class="col-md-8">
                    <sf:input path="productName" cssClass="form-control"/>
                    <sf:errors path="productName" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-4" for="categoryId">Category :</label>
                <div class="col-md-8">
                    <sf:input path="categoryId" cssClass="form-control"/>
                    <sf:errors path="categoryId" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-4" for="supplierId">Supplier :</label>
                <div class="col-md-8">
                    <sf:input path="supplierId" cssClass="form-control"/>
                    <sf:errors path="supplierId" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-4" for="unitPrice">Unit Price :</label>
                <div class="col-md-8">
                    <sf:input path="unitPrice" cssClass="form-control"/>
                    <sf:errors path="unitPrice" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-4" for="quantityPerUnit">Quantity Per unit :</label>
                <div class="col-md-8">
                    <sf:input path="quantityPerUnit" cssClass="form-control"/>
                    <sf:errors path="quantityPerUnit" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-4" for="unitsInStock">Units in stock :</label>
                <div class="col-md-8">
                    <sf:input path="unitsInStock" cssClass="form-control"/>
                    <sf:errors path="unitsInStock" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-4" for="unitsOnOrder">Units on order :</label>
                <div class="col-md-8">
                    <sf:input path="unitsOnOrder" cssClass="form-control"/>
                    <sf:errors path="unitsOnOrder" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-4" for="reorderLevel">Reorder Level :</label>
                <div class="col-md-8">
                    <sf:input path="reorderLevel" cssClass="form-control"/>
                    <sf:errors path="reorderLevel" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-4" >Discontinued :</label>
                <div class="col-md-8">
                    <label>
                        <sf:radiobutton path="discontinued" value="1" />
                        Yes
                    </label>
                    <label>
                        <sf:radiobutton path="discontinued" value="0" />
                        No
                    </label>
                </div>
            </div>
            <br>
            <div class="form-group row">
                <label class="col-md-4"></label>
                <div class="col-md-8">
                    <button class="btn btn-outline-primary">Submit Changes</button>
                </div>
            </div>
        </sf:form>
    </div>
    <div class="col"></div>
</div>

<%@ include file="footer.jspf" %>