<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<t:template>
    <h1>Actors</h1>


    <c:if test = "${!empty actor}">
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
        <table>
            <h1>Post</h1>
            <tr>
                <th>Name</th>
            </tr>
            <c:forEach items = "${post}" var = "post">
                <tr>
                    <td>${post.getNamePost()}<td>
                </tr>
            </c:forEach>
        </table>
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

        <table>
            <h1>Role</h1>
            <tr>
                <th>NameRole</th>
                <th>IDActor</th>
                <th>IDProject</th>
            </tr>
            <c:forEach items = "${role}" var = "role">
                <tr>
                    <td>${role.getNameRole()}<td>
                    <td>${role.getIdActor()}<td>
                    <td>${role.getIdProject()}<td>
                </tr>
            </c:forEach>
        </table>
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
        <table>
            <h1>Type</h1>
            <tr>
                <th>NameType</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items = "${type}" var = "type">
                <tr>
                    <td>${type.getNameType()}<td>
                    <td><a href="deleteType/${type.getIdType()}">Delete</a>/<a href="editType/${type.getIdType()}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</t:template>

