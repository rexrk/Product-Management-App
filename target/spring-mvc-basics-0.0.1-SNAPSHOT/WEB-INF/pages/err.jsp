<%@ include file="header.jspf" %>
<hr>
<h2 class="text-danger">
    <p>Oops, There was an error in processing the Request.</p>
</h2>
<p>Contact Administrator <a href="https://www.linkedin.com/in/raman-linking/">Raman Kumar</a></p>
<button class="btn btn-outline-danger" onclick="showErrDetails()">Show Errors</button>
<pre style="visibility: hidden" id="errorDetails">
    <%
        Exception ex = (Exception) request.getAttribute("ex");
        ex.printStackTrace(new java.io.PrintWriter(out));
    %>
</pre>
<script>function showErrDetails() {
    document.getElementById("errorDetails").style.visibility = "visible";
}
</script>
<%@ include file="footer.jspf" %>

