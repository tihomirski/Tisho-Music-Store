
<%@include file="/WEB-INF/views/template/header.jsp" %>

<!-- Carousel
================================================== -->

<!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<!-- These are predefined classes in Bootstrap. -->
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is the admin page.</p>
        </div>

        <%/* ${pageContext.request.userPrincipal.name} is taking the username from the Spring Security Context */%>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>Welcome ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/j_spring_security_logout"/> ">Logout</a>
            </h2>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/productInventory"/>" >Product Inventory</a>
        </h3>
        <p>Here you can view, check and modify the product inventory.</p>

        <br/><br/>

        <h3>
            <a href="<c:url value="/admin/customer"/>" >Customer Management</a>
        </h3>
        <p>Here you can view the customer information.</p>


<%@include file="/WEB-INF/views/template/footer.jsp"%>