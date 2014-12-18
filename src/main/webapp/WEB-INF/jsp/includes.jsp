<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div align="right" style="margin-right: 10px">
		<spring:message code="user.logged" />
		:
		<sec:authentication property="name" />
		<sec:authentication property="authorities" />
		| <a href="${pageContext.request.contextPath}/logout"> <spring:message code="user.logout" /></a>
	</div>
