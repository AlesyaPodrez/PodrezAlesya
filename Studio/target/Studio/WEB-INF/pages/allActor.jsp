<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:template>
    <form:form action="allActor">
        <table>
            <tr>
                <th>Surname</th>
                <th>Name</th>
                <th>Lastname</th>
                <th>Date</th>
                <th>Experience</th>
            </tr>
            <c:forEach items = "${actor}" var = "actor">
                <tr>
                    <td>${actor.getSurname()}</td>
                    <td>${actor.getName()}<td>
                    <td>${actor.getLastname()}</td>
                    <td>${actor.getDateOfBirth()}<td>
                    <td>${actor.getExperience()}</td>
                </tr>
            </c:forEach>
        </table>
    </form:form>
</t:template>

