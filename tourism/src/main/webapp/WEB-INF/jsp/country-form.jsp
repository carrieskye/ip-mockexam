<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Country</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/css/stylesheet.css" />" type="text/css">
</head>
<body>
<main>
    <h3>New Country</h3>
    <div class="col-sm-8">

        <form id="categoryForm" role="form"
              method="POST" action="<c:url value="/country/save.htm"/>">
            <input name="id" type="hidden" value="${country.id}" />

            <div>
                <label for="name">Name</label>
                <div>
                    <input name="name" id="name" value="${country.name}"/>
                </div>
            </div>

            <div>
                <label for="inhabitants">Number of inhabitants</label>
                <div>
                    <input name="numberInhabitants" id="inhabitants" value="${country.numberInhabitants}"/>
                </div>
            </div>

            <div>
                <div>
                    <input type="submit" id="saveCountry" value="Save" />
                </div>
            </div>
        </form>

    </div>
</main>
</body>
</html>
