<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>
        <bean:message key="label.leadDetails.title" locale="display" />
    </title>
    <!-- CSS -->
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <link rel="stylesheet" href="css/theme.css" type="text/css" />
</head>
<body id="public">

<script language="JavaScript" type="text/javascript">
<!--
    function actionValue(value) {
        document.leadForm.action.value = value;
    }
//-->
</script>

<div id="container">

    <%@ include file="/header_inc.jsp" %>

    <html:form action="/lead" method="post" styleClass="javachap topLabel" styleId="form3">

        <html:hidden property="leadId" />
        <html:hidden property="action" />
        <div class="info">
            <div class="buttons">
                <html:link tabindex="4" title="Sell a New Lead" action="/lead" styleClass="positive">
                    <html:img src="images/new_lead.png" styleClass="icon" />
                    <bean:message key="link.label.newLead" locale="display" />!
                </html:link>
                <html:link tabindex="5" title="View My Leads" action="/leadListing" styleClass="positive">
                    <html:img src="images/new_lead.png" styleClass="icon" />
                    <bean:message key="link.label.myLead" locale="display" />!
                </html:link>
            </div>
            <h2>
                <bean:message key="label.leadDetails.heading" locale="display" />
            </h2>
            <p>
                <bean:message key="label.leadDetails.headingCaption" locale="display" />
            </p>
        </div>

        <ul>
            <li class="label">
                <span><bean:message key="label.category" locale="display"/></span>: <bean:write name="lead" property="category.name" />
            </li>

            <li class="label">
                <span><bean:message key="label.title" locale="display"/></span>: <bean:write name="lead" property="title" />
            </li>

            <li class="label">
                <span><bean:message key="label.description" locale="display"/></span>: <bean:write name="lead" property="description" />
            </li>

            <li class="label">
                <span><bean:message key="label.firstName" locale="display"/></span>: <bean:write name="lead" property="firstName" />
            </li>

            <li class="label">
                <span><bean:message key="label.lastName" locale="display"/></span>: <bean:write name="lead" property="lastName" />
            </li>

            <li class="label">
                <span><bean:message key="label.email" locale="display"/></span>: <bean:write name="lead" property="email" />
            </li>

            <li class="label">
                <span><bean:message key="label.status" locale="display"/></span>: <bean:write name="lead" property="status" />
            </li>

            <li class="label">
                <span><bean:message key="label.phone" locale="display"/></span>: <bean:write name="lead" property="phone" />
            </li>

            <li class="label">
                <span><bean:message key="label.price" locale="display"/></span>: $
                <logic:lessEqual name="lead" property="price" value="10.00">
                    <font color="red">
                        <bean:write name="lead" property="price" format="##.##" />
                    </font>
                </logic:lessEqual>
                <logic:greaterThan name="lead" property="price" value="10.00">
                    <font color="green">
                        <bean:write name="lead" property="price" format="##.##" />
                    </font>
                </logic:greaterThan>
            </li>

        </ul>
        <li class="buttons">
            <html:submit styleId="editForm" styleClass="btTxt imgStyle" tabindex="6"
                        title="Edit Lead" onclick="actionValue('edit')">
                <bean:message key="button.label.edit" locale="display" />
            </html:submit>
            <logic:equal name="lead" property="status" value="New" >
                <html:submit styleId="publishForm" styleClass="btTxt imgStyle" tabindex="7"
                            title="Publish Lead" disabled="false" onclick="actionValue('publish')">
                    <bean:message key="button.label.publish" locale="display" />
                </html:submit>
            </logic:equal>
            <logic:notEqual name="lead" property="status" value="New" >
                <html:submit styleId="publishForm" styleClass="btTxt imgStyle" tabindex="7"
                            title="Publish Lead" disabled="true">
                    <bean:message key="button.label.publish" locale="display" />
                </html:submit>
            </logic:notEqual>
            <html:submit styleId="deleteForm" styleClass="btTxt imgStyle" tabindex="8"
                        title="Delete Lead" onclick="actionValue('delete')">
                <bean:message key="button.label.delete" locale="display" />
            </html:submit>
        </li>

        </html:form>
    </div>

 </body>
 </html>

