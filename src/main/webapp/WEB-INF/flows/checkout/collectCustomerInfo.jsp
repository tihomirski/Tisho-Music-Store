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
            <h1>Customer</h1>

            <p class="lead">Customer Details</p>
        </div>

        <!-- This is a Spring form -->
        <form:form commandName="order" class="form-horizontal">

        <h3>Basic Info</h3>
        <div class="form-group">
            <label for="name">Name</label>
            <!-- class="form-control" tells bootstrap to make the field full width -->
            <!-- path="" should match the field in the Customer Java object.
                 for="" should match id="" -->
            <form:input path="cart.customer.customerName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="email">E-mail</label>
            <!-- class="form-control" tells bootstrap to make the field full width.
            id="" ?!?!? -->
            <form:input path="cart.customer.customerEmail" id="email" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <!-- class="form-control" tells bootstrap to make the field full width -->
            <form:input path="cart.customer.customerPhone" id="phone" class="form-Control"/>
        </div>


        <h3>Billing Address</h3>

        <div class="form-group">
            <label for="billingStreet">Street</label>
            <!-- class="form-control" tells bootstrap to make the field full width.
             The thing with the path="" is that in Customer obj, we have a field for BillingAddress obj.
             The BillingAddress obj has a String field streetName. -->
            <form:input path="cart.customer.billingAddress.streetName" id="billingStreet" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingApartmentNumber">Apartment Number</label>
            <form:input path="cart.customer.billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingCity">City</label>
            <form:input path="cart.customer.billingAddress.city" id="billingCity" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="cart.customer.billingAddress.state" id="billingState" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingCountry">Country</label>
            <form:input path="cart.customer.billingAddress.country" id="billingCountry" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingZip">Zip code</label>
            <form:input path="cart.customer.billingAddress.zipCode" id="billingZip" class="form-Control"/>
        </div>

        <!-- This indicates that this page is part of the workflow we defined earlier. -->
        <input type="hidden" name="_flowExecutionKey" />

        <br/><br/>

        <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected">
        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </form:form>



<%@include file="/WEB-INF/views/template/footer.jsp"%>