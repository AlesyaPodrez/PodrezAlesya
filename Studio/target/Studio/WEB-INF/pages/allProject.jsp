<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:template>
    <form:form action="allProject">
        <table>
            <h1>Project</h1>
            <tr>
                <th>Year</th>
                <th>NameProject</th>
                <th>Country</th>
                <th>IDType</th>
            </tr>
            <c:forEach items = "${project}" var = "project">
                <tr>
                    <td>${project.getYear()}</td>
                    <td>${project.getNameProject()}<td>
                    <td>${project.getCoutry()}</td>
                    <td>${project.getIdType().getNameType()}</td>
                </tr>
            </c:forEach>
        </table>
    </form:form>
</t:template>

