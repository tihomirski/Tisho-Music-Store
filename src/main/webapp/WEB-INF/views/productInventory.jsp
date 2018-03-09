<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<script>
    $(document).ready(function () {


        $('.table').DataTable({

            "lengthMenu" : [[5,10,25,50,-1], [5,10,25,50,'All']]
        });
    });
</script>

<!-- These are predefined classes in Bootstrap. -->
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory Page</h1>

            <p class="lead">This is the product inventory page.</p>
        </div>

        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead>
                <tr class="bg-success">
                    <th>Photo Thumb</th>
                    <th>Product Name</th>
                    <th>Category</th>
                    <th>Condition</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach items="${products}" var="product">



                    <tr>
                        <td> <img src="<c:url value="/resources/images/${product.productId}.png"/> " alt="an image"
                                  style="width: auto; height: 140px"/> </td>
                        <td>${product.productName}</td>
                        <td>${product.productCategory}</td>
                        <td>${product.productCondition}</td>
                        <td>${product.productPrice} USD</td>
                        <td>
                            <a href="<spring:url value="/product/viewProduct/${product.productId}"/> " >
                                <span class="glyphicon glyphicon-info-sign"></span>
                            </a>

                            <a href="<spring:url value="/admin/product/deleteProduct/${product.productId}"/> " >
                                <span class="glyphicon glyphicon-remove"></span>
                            </a>

                            <a href="<spring:url value="/admin/product/editProduct/${product.productId}"/> " >
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <a href="<spring:url value="/admin/product/addProduct" />" class="btn btn-primary">Add product</a>

<%@include file="/WEB-INF/views/template/footer.jsp"%>