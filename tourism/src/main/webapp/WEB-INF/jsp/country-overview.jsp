<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Countries</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value="/css/stylesheet.css" />" type="text/css">
    </head>
    <body>
        <h1>Countries</h1>
        <div class="col-sm-8">
            <table id="countryOverview" >
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Number of inhabitants</th>
                </tr>
                </thead>
                <c:forEach var="country" items="${countries}">
                    <tr>
                        <td>${country.name}</td>
                        <td>${country.numberInhabitants}</td>
                        <td><a
                                href="<c:url value='' />">Edit</a></td>
                        <td>
                            <form method="POST"
                                  action="<c:url value='' />">
                                <input type="submit" value="Delete"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br/>
            <a href="<c:url value=""/>">New</a>
        </div>
    </body>
</html>
