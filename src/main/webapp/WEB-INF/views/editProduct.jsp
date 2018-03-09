<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <h1>Edit Product</h1>

            <p class="lead">Please update the product information here.</p>
        </div>

        <!-- This is a Spring form -->
        <form:form action="${pageContext.request.contextPath}/admin/product/editProduct"
                   method="post" commandName="product" enctype="multipart/form-data">

        <form:hidden path="productId" value="${product.productId}" />

        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="productName" id="name" class="form-Control" value="${product.productName}"/>
        </div>

        <!-- We don't need to pre-load it. It will be pre-loaded. -->
        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="Instrument"/>Instrument</label>

            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="Record"/>Record</label>

            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="Accessory"/>Accessory</label>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="productDescription" id="description" class="form-Control" value="${product.productDescription}"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="productPrice" id="price" class="form-Control" value="${product.productPrice}"/>
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="New"/>New</label>

            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="Used"/>Used</label>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                             value="Active"/>Active</label>

            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                             value="Inactive"/>Inactive</label>
        </div>

        <div class="form-group">
            <label for="unitInStock">Units In Stock</label>
            <form:input path="unitInStock" id="unitInStock" class="form-Control" value="${product.unitInStock}"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-Control" value="${product.productManufacturer}"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="productImage">Upload Picture</label>
            <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
        </div>

        <br/><br/>

        <input type="submit" value="Submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory"/>" class="btn btn-default">Cancel</a>
        </form:form>



<%@include file="/WEB-INF/views/template/footer.jsp"%>