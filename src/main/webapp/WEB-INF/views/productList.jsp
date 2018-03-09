<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<script>
    $(document).ready(function () {
        /* The S{searchCondition} will be takne from the landing page (home maybe??).
           Did you see those 3 Heading sections under the carousel that are empty? ;-)
        */
        //This can be used if we don't add another method with @RequestMapping in ProductController,
        //which adds the @RequestParam in the model as model's attr.
        //var searchCondition = '${param.searchCondition}';
        var searchCondition = '${searchCondition}';
        $('.table').DataTable({
            /*Here we specify the menu for items per page.
              The first array is the array with values and the second is array of labels.
             */
            "lengthMenu" : [[5,10,25,50,-1], [5,10,25,50,'All']],
            "oSearch" : {"sSearch" : searchCondition}
        });
    });
</script>


<!-- These are predefined classes in Bootstrap. -->
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>

            <p class="lead">Checkout all the awesome products available now!</p>
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
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <%@include file="/WEB-INF/views/template/footer.jsp"%>