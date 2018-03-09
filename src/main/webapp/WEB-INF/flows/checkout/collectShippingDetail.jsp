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




        <h3>Shipping Address</h3>

        <div class="form-group">
            <label for="shippingStreet">Street</label>
            <!-- class="form-control" tells bootstrap to make the field full width.
             The thing with the path="" is that in Customer obj, we have a field for shippingAddress obj.
             The shippingAddress obj has a String field streetName. -->
            <form:input path="cart.customer.shippingAddress.streetName" id="shippingStreet" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingApartmentNumber">Apartment Number</label>
            <form:input path="cart.customer.shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingCity">City</label>
            <form:input path="cart.customer.shippingAddress.city" id="shippingCity" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingState">State</label>
            <form:input path="cart.customer.shippingAddress.state" id="shippingState" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingCountry">Country</label>
            <form:input path="cart.customer.shippingAddress.country" id="shippingCountry" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingZip">Zip code</label>
            <form:input path="cart.customer.shippingAddress.zipCode" id="shippingZip" class="form-Control"/>
        </div>

        <!-- This indicates that this page is part of the workflow we defined earlier. -->
        <input type="hidden" name="_flowExecutionKey" />

        <br/><br/>

        <!-- The name here is the same as in checkout-flow.xml, see id="collectShippingDetail" -->
        <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
        <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected">
        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </form:form>



<%@include file="/WEB-INF/views/template/footer.jsp"%>