<%@ page import="es.basallo.StringUtils; es.basallo.Report" %>
<!DOCTYPE html>

<html>

<head>
    <meta name="layout" content="main">
    <title><g:message code="user.show.title" default="Users List"/></title>
</head>

<body>

<h1><g:message code="user.show.title" default="User Detail"/></h1>

<table class="table table-striped table-bordered table-condensed">

    <thead>
    <tr>
        <td><g:message code="user.index.id.label" default="Id"/></td>
        <td><g:message code="user.index.name.label" default="Name"/></td>
        <td><g:message code="user.index.locale.label" default="Locale"/></td>
        <td><g:message code="user.show.numberActiveGenerations.label" default="Number of active generations"/></td>
    </tr>
    </thead>

    <tbody>

    <tr>
        <td>${fieldValue(bean: user, field: "id")}</td>
        <td>${fieldValue(bean: user, field: "name")}</td>
        <td>${fieldValue(bean: user, field: "locale")}</td>
        <td>${Report.numberOfActiveGenerations}</td>
    </tr>

    </tbody>

</table>

<h1><g:message code="reports.show.title" default="Reports List"/></h1>

<table class="table table-striped table-bordered table-condensed">

    <thead>
    <tr>
        <td><g:message code="user.show.report.id.label" default="Id"/></td>
        <td><g:message code="user.show.report.name.label" default="Name"/></td>
    </tr>
    </thead>

    <tbody>
    <g:each in="${user?.reports.sort { it.id }}" var="report">
        <tr>
            <td>${fieldValue(bean: report, field: "id")}</td>
            <td>
                <g:if test="${user.isFrench()}">
                    ${StringUtils.toROT13(report.name)}
                </g:if>
                <g:else>
                    ${fieldValue(bean: report, field: "name")}
                </g:else>
            </td>
        </tr>
    </g:each>
    </tbody>

</table>

<p>
    <g:link action="addReport" id="${user.id}">
        <button type="button" class="btn btn-primary">
            <g:message code="user.show.button.addReport" default="Add report"/>
        </button>
    </g:link>
    <g:link action="index">
        <button type="button" class="btn btn-default">
            <g:message code="user.show.button.index" default="Back to user index"/>
        </button>
    </g:link>
</p>

</body>

</html>
