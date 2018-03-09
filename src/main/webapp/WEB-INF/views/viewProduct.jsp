<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
            <h1>Product Detail</h1>

            <p class="lead">Here is the detailed information about the product.</p>
        </div>

        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.productId}.png"/> " alt="an image"
                              style="width: 100%"/>
                </div>
                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <p>
                        <strong>Manufacturer</strong>: ${product.productManufacturer}
                    </p>
                    <p>
                        <strong>Category</strong>: ${product.productCategory}
                    </p>
                    <p>
                        <strong>Condition</strong>: ${product.productCondition}
                    </p>

                    <h4>${product.productPrice} USD</h4>

                    <br/>

                    <!-- Using JSTL function set to define our var.
                         The scope attr tells that on the whole page this var will be available.
                         We take this value from the session/spring-security/or/the package managinf the users.
                         We assign the url depending on the role to the href of the Back btn.
                    -->
                    <c:set var="role" scope="page" value="${param.role}" />
                    <c:set var="url" scope="page" value="/product/productList" />
                    <c:if test="${role = 'admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:if>

                    <!-- This Back button should bring from here (viewProduct.jsp) to
                         productList page if you are user or productInventory if you are admin.
                    -->
                    <p ng-controller="cartCtrl">
                        <a href="<c:url value="${url}/all"/>" class="btn btn-default">
                            <span class="glyphicon glyphicon-arrow-left"></span> Back
                        </a>

                        <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Order Now
                        </a>

                        <a href="<spring:url value="/customer/cart"/>" class="btn btn-default">
                            <span class="glyphicon glyphicon-hand-right"></span> View Cart
                        </a>
                    </p>
                </div>
            </div>
        </div>

        <script src="<c:url value="/resources/js/controller.js"/>"></script>

<%@include file="/WEB-INF/views/template/footer.jsp"%>