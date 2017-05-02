<html>
<head>
    <title><g:message code="views.account.pay.head.title" /></title>
    <meta name="layout"content="main"/>
</head>
<body>

<p>
    <g:if test="${flash.message}">
        <div class="errors" role="alert">${flash.message}</div>
    </g:if>

    <g:hasErrors bean="${transaction}">
        <div class="errors" role="alert">
            <g:eachError bean="${transaction}">
                <g:message error="${it}" /><br/>
            </g:eachError>
        </div>
    </g:hasErrors>
</p>

<div class="container">
    <g:form controller="account">
        <p>
            <h2><g:message code="views.account.pay.form.h2" /></h2>
        </p>
        <p>
            <b><g:message code="views.account.pay.b" /></b>
            <g:select name="from" from="${accounts}" optionKey="id" optionValue="name" value="${params.from}"/>
            <b><g:message code="views.account.pay.form.h2-2" /></b>
            <g:select name="to" from="${accounts}" optionKey="id" optionValue="name" value="${params.to}"/>
        </p>
        <p>
            <b><g:message code="views.account.pay.form.h2-3"/></b>
            <g:textField name="amount" value="${params.amount}"></g:textField>
            <b><g:actionSubmit value="${message(code:'views.account.pay.form.actionSubmit')}" action="payExecution" /></b>
        </p>
    </g:form>
</div>
</body>
</html>
