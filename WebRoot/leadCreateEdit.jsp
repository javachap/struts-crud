<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>
        <bean:message key="label.leadCreateEdit.title" locale="display" />
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

<%@ page import="com.javachap.domain.Category" %>
<%@ page import="java.util.List" %>

<div id="container">

    <%@ include file="/header_inc.jsp" %>

    <html:form action="/lead.do" method="post" styleClass="javachap topLabel" styleId="form3">

        <html:hidden property="action"  />
        <html:hidden property="leadId" />

        <div class="info">
            <logic:empty name="leadForm" property="leadId">
                <h2>
                    <bean:message key="label.leadCreate.heading" locale="display" />
                </h2>
            </logic:empty>
            <logic:notEmpty name="leadForm" property="leadId">
                <h2>
                    <bean:message key="label.leadEdit.heading" locale="display" />
                </h2>
            </logic:notEmpty>
            <p>
               <bean:message key="label.leadCreateEdit.headingCaption" locale="display" />
            </p>

        </div>

        <logic:messagesPresent>
            <li id="errorLi">
            <h3 id="errorMsgLbl">
                <bean:message key="error.label.mainName" locale="display"/>
            </h3>
            <p id="errorMsg">
                <bean:message key="error.label.subName1" locale="display"/>
                <strong> <bean:message key="error.label.subName2" locale="display"/> </strong>
                <bean:message key="error.label.subName3" locale="display"/>
            </p>
            </li>
        </logic:messagesPresent>

        <ul>

            <li class="<logic:messagesPresent property='category'>error</logic:messagesPresent>" id="fo3li7" >
                <label class="desc" id="title7" for="Field7">
                <bean:message key="label.category" locale="display"/> <span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:select styleClass="field select medium" styleId="Field7" property="category" tabindex="1" >
                        <html:option value="Select any Category">
                            <bean:message key="label.option.default" locale="display" />
                        </html:option>
                        <html:optionsCollection name="categoryList" label="name" value="id" />
                    </html:select>
                </div>
                <logic:messagesPresent property="category">
                    <p class="error"><html:errors property="category" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='title'>error</logic:messagesPresent>" id="fo3li0" >
                <label class="desc" id="title0" for="Field0">
                <bean:message key="label.title" locale="display"/> <span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="Field0" styleClass="field text medium" property="title"
                                tabindex="1" maxlength="255"/>
                </div>
                <logic:messagesPresent property="title">
                    <p class="error"><html:errors property="title" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='description'>error</logic:messagesPresent>" id="fo3li0" >
                <label id="title1" class="desc" for="Field1">
                <bean:message key="label.description" locale="display"/> <span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:textarea styleId="Field1" styleClass="field textarea medium" property="description"
                                    rows="10" cols="50" tabindex="2" ></html:textarea>
                </div>
                <logic:messagesPresent property="description">
                    <p class="error"><html:errors property="description" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='firstName'>error</logic:messagesPresent>" id="fo3li0" >
                <label class="desc" id="title4" for="Field4">
                <bean:message key="label.firstName" locale="display"/> <span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="Field4" styleClass="field text medium" property="firstName"
                                tabindex="3" maxlength="255" />
                </div>
                <logic:messagesPresent property="firstName">
                    <p class="error"><html:errors property="firstName" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='lastName'>error</logic:messagesPresent>" id="fo3li0" >
                <label class="desc" id="title5" for="Field5">
                <bean:message key="label.lastName" locale="display"/> <span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="Field5" styleClass="field text medium" property="lastName"
                                tabindex="4" maxlength="255" />
                </div>
                <logic:messagesPresent property="lastName">
                    <p class="error"><html:errors property="lastName" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='email'>error</logic:messagesPresent>" id="fo3li0" >
                <label class="desc" id="title6" for="Field6">
                <bean:message key="label.email" locale="display"/> <span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="Field6" styleClass="field text medium" property="email"
                                tabindex="5" maxlength="255" />
                </div>
                <logic:messagesPresent property="email">
                    <p class="error"><html:errors property="email" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li id="fo3li8" class="   " >
                <label class="desc" id="title8" for="Field8">
                <bean:message key="label.phone" locale="display"/>
                </label>
                <div>
                    <html:text styleId="Field8" styleClass="field text medium" property="phone"
                                tabindex="6" maxlength="255" />
                </div>
            </li>

            <li class="<logic:messagesPresent property='price'>error</logic:messagesPresent>" id="fo3li0" >
                <label class="desc" id="title9" for="Field9">
                <bean:message key="label.price" locale="display"/> <span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="Field9" styleClass="field text small" property="price"
                                tabindex="7" maxlength="255" />
                </div>
                <logic:messagesPresent property="price">
                    <p class="error"><html:errors property="price" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="buttons">
                <html:submit styleId="saveForm" styleClass="btTxt imgStyle" tabindex="8" title="Submit this Details"
                            onclick="actionValue('save')">
                    <bean:message key="button.label.submit" locale="display"/>
                </html:submit>
                <html:submit styleId="saveForm" styleClass="btTxt imgStyle" tabindex="9" title="Submit this Details"
                            onclick="actionValue('cancel')">
                    <bean:message key="button.label.cancel" locale="display"/>
                </html:submit>
            </li>

        </ul>

    </html:form>
</div><!--container-->
</body>
</html>
