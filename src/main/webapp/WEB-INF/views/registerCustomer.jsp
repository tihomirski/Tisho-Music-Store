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
            <h1>Register Customer</h1>

            <p class="lead">Please fill in the information below.</p>
        </div>

        <!-- This is a Spring form -->
        <form:form action="${pageContext.request.contextPath}/register"
                   method="post" commandName="customer">

        <h3>Basic Info</h3>
        <div class="form-group">
            <label for="name">Name </label><form:errors path="customerName" cssStyle="color: red" />
            <!-- class="form-control" tells bootstrap to make the field full width -->
            <!-- path="" should match the field in the Customer Java object.
                 for="" should match id="" -->
            <form:input path="customerName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="email">E-mail </label><span style="color: #ff0000">${emailMsg}</span><form:errors path="customerEmail" cssStyle="color: red" />
            <!-- class="form-control" tells bootstrap to make the field full width.
            id="" ?!?!? -->
            <form:input path="customerEmail" id="email" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <!-- class="form-control" tells bootstrap to make the field full width -->
            <form:input path="customerPhone" id="phone" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="username">Username </label><span style="color: #ff0000">${usernameMsg}</span><form:errors path="username" cssStyle="color: red" />
            <!-- class="form-control" tells bootstrap to make the field full width -->
            <form:input path="username" id="username" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="password">Password </label><form:errors path="password" cssStyle="color: red" />
            <!-- class="form-control" tells bootstrap to make the field full width -->
            <form:password path="password" id="password" class="form-Control"/>
        </div>

        <h3>Billing Address</h3>

        <div class="form-group">
            <label for="billingStreet">Street</label>
            <!-- class="form-control" tells bootstrap to make the field full width.
             The thing with the path="" is that in Customer obj, we have a field for BillingAddress obj.
             The BillingAddress obj has a String field streetName. -->
            <form:input path="billingAddress.streetName" id="billingStreet" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingApartmentNumber">Apartment Number</label>
            <form:input path="billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingCity">City</label>
            <form:input path="billingAddress.city" id="billingCity" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="billingAddress.state" id="billingState" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingCountry">Country</label>
            <form:input path="billingAddress.country" id="billingCountry" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingZip">Zip code</label>
            <form:input path="billingAddress.zipCode" id="billingZip" class="form-Control"/>
        </div>

        <h3>Shipping Address</h3>

        <div class="form-group">
            <label for="shippingStreet">Street</label>
            <form:input path="shippingAddress.streetName" id="shippingStreet" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingApartmentNumber">Apartment Number</label>
            <form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingCity">City</label>
            <form:input path="shippingAddress.city" id="shippingCity" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingState">State</label>
            <form:input path="shippingAddress.state" id="shippingState" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingCountry">Country</label>
            <form:input path="shippingAddress.country" id="shippingCountry" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingZip">Zip code</label>
            <form:input path="shippingAddress.zipCode" id="shippingZip" class="form-Control"/>
        </div>



        <br/><br/>

        <input type="submit" value="Submit" class="btn btn-default">
        <a href="<c:url value="/"/>" class="btn btn-default">Cancel</a>
        </form:form>



<%@include file="/WEB-INF/views/template/footer.jsp"%>