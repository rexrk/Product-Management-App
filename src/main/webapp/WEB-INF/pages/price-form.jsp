<%@ include file="header.jspf" %>
</p>
<hr>
<h2>Enter the Price Range : </h2>
<div class="row">
    <div class="col">
        <form action="products-by-price-range" method="get">
            <div class="row form-group">
                <label class="col-md-4" for="min">Minimum Price :</label>
                <div class="col-md-8 input-group form-group">
                    <span class="input-group-text">$</span>
                    <input type="text" id="min" name="min" class="form-control" placeholder="Set minimum price range" value="0">
                    <span class="input-group-text">.00</span>
                </div>
            </div>

            <div class="row form-group">
                <label class="col-md-4" for="max">Maximum Price :</label>
                <div class="input-group col-md-8">
                    <span class="input-group-text">$</span>
                    <input type="text" id="max" name="max" class="form-control" placeholder="Set maximum price range" value="0">
                    <span class="input-group-text">.00</span>
                </div>
            </div>
            <br>
            <button class="btn btn-lg btn-primary" type="submit">Submit</button>
        </form>
    </div>

    <div class="col"></div>
</div>
<%@include file="footer.jspf" %>