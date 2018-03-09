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
            <h1>Customer Management Page</h1>

            <p class="lead">This is the customer management page.</p>
        </div>

        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead>
                <tr class="bg-success">
                    <th>Name</th>
                    <th>E-mail</th>
                    <th>Phone</th>
                    <th>Username</th>
                    <th>Enabled</th>

                </tr>
                </thead>
                <c:forEach items="${customerList}" var="customer">
                    <tr>
                        <td>${customer.customerName}</td>
                        <td>${customer.customerEmail}</td>
                        <td>${customer.customerPhone}</td>
                        <td>${customer.username}</td>
                        <td>${customer.enabled}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>