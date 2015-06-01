<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:template>
    <form:form method="post" action="../editType" commandName="type">
        <table>
            <tr>
                ID
                <form:input path="idType" readonly="true"/>
            </tr>
            <tr>
                <td><form:label path="NameType">
                    NameType
                </form:label></td>
                <td><form:input path="nameType"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Edit type"/></td>
            </tr>
        </table>
    </form:form>
</t:template>
