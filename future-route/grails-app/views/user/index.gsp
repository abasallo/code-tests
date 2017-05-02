<!DOCTYPE html>

<html>

<head>
    <meta name="layout" content="main">
    <title><g:message code="user.index.title" default="Users List"/></title>
</head>

<body>

<h1><g:message code="user.index.title" default="Users List"/></h1>

<table class="table table-striped table-bordered table-condensed">

    <thead>
    <tr>
        <td><g:message code="user.index.id.label" default="Id"/></td>
        <td><g:message code="user.index.name.label" default="Name"/></td>
        <td><g:message code="user.index.locale.label" default="Locale"/></td>
    </tr>
    </thead>

    <tbody>
    <g:each in="${users}" var="user">
        <tr>
            <td><g:link action="show" id="${user.id}">${fieldValue(bean: user, field: "id")}</g:link></td>
            <td>${fieldValue(bean: user, field: "name")}</td>
            <td>${fieldValue(bean: user, field: "locale")}</td>
        </tr>
    </g:each>
    </tbody>

</table>

</body>

</html>
