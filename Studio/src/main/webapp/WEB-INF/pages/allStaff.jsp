<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:template>
    <form:form action="allStaff">
        <table>
            <h1>Staff</h1>
            <tr>
                <th>Surname</th>
                <th>Name</th>
                <th>Lastname</th>
                <th>Date</th>
                <th>Experience</th>
                <th>IDPost</th>
                <th>IDProject</th>
            </tr>
            <c:forEach items = "${staff}" var = "staff">
                <tr>
                    <td>${staff.getSurname()}</td>
                    <td>${staff.getName()}<td>
                    <td>${staff.getLastname()}</td>
                    <td>${staff.getDateOfBirth()}<td>
                    <td>${staff.getExperience()}</td>
                    <td>${staff.getIdPost()}</td>
                    <td>${staff.getIdProject()}</td>
                </tr>
            </c:forEach>
        </table>
    </form:form>
</t:template>

