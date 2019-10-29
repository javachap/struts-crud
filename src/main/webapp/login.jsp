<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <title><bean:message key="label.login.title" locale="display"/></title>
    <!-- CSS -->
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <link rel="stylesheet" href="css/theme.css" type="text/css" />

</head>

<body id="public">

<div id="container">

    <%@ include file="/header_inc.jsp" %>

    <html:form action="/login" method="post" styleClass="javachap topLabel">
        <html:hidden property="action" value="login"/>
        <div class="info">
            <h2><bean:message key="label.login.heading" locale="display" />!</h2>
            <p><bean:message key="label.login.headingCaption" locale="display" />.</p>
        </div>

        <ul>
            <logic:messagesPresent >
                <li id="errorLi">
                    <h3 id="errorMsgLbl"><html:errors locale="display"/></h3>
                </li>
            </logic:messagesPresent>

            <li class="">
                <label for="email" class="desc">
                    <bean:message key="label.email" locale="display" />
                </label>
                <div>
                    <html:text property="email" maxlength="255"
                        tabindex="4" styleClass="field text medium"/>
                </div>
            </li>

            <li class="" >
                <label for="password" class="desc">
                    <bean:message key="label.password" locale="display" />
                </label>
                <div>
                    <html:password property="password" maxlength="255"
                        tabindex="5" styleClass="field text medium"/>
                </div>
            </li>

            <li class="buttons">
                <html:submit tabindex="6" styleClass="btTxt">
                    <bean:message key="button.label.login" locale="display"/>
                </html:submit>
            </li>

        </ul>
    </html:form>
</div>

</body>
</html>
