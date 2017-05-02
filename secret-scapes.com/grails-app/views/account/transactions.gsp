<html>
<head>
    <title><g:message code="views.account.transactions.title" /></title>
    <meta name="layout" content="main" />
</head>
<body>
<div class="container">
    <g:form controller="account">

    <p>
        <h2>
            <g:message code="views.account.transactions.h2" />
        </h2>
    </p>

    <p>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
    </p>
    <p>
        <b>Person:</b>
        <g:select name="from" from="${accounts}" optionKey="id" optionValue="name" value="${params.from}" onchange="submit()"/>
    </p>
    <p>
        <g:actionSubmit value="${message(code:'views.account.transactions.form.actionSubmit')}" action="pay" />
    </p>

    ----------------------------

    <p><g:message code="views.account.transactions.form.balance.title"/> ${balance}</p>

    <table>
        <tr>
            <th><g:message code="views.account.transactions.form.balance.table.th-1" /></th>
            <th><g:message code="views.account.transactions.form.balance.table.th-2" /></th>
            <th><g:message code="views.account.transactions.form.balance.table.th-3" /></th>
            <th><g:message code="views.account.transactions.form.balance.table.th-4" /></th>
        </tr>

        <g:each in="${incomingAndOutgoingTransactions}" var="transaction">
            <tr>
                <td>${transaction.id}</td>
                <td>${transaction.from.name}</td>
                <td>${transaction.to.name}</td>
                <td>${transaction.amount}</td>
            </tr>
        </g:each>
    </table>
    </g:form>
</div>
</body>
</html>

