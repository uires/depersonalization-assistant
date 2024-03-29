<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<link href="<spring:url value="/resources/css/style.css"/>"
	rel="stylesheet" />
<link href="<spring:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Despersonalização Assistente - Meus Relatorios</title>
</head>
<body>
	<c:import url="../includes/menu.jsp" />
	<div class="container mt-5">
		<table class="table table-hover">
			<thead class="thread">
				<tr>
					<th>Descrição</th>
					<th>Patologia</th>
					<th>Data</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${relatos}" varStatus="index" var="relato">
					<tr>
						<td><a
							href="<c:url value="/relatorio/discusaorelatorio?id=${relato.id}" />">
								${relato.descricao} </a></td>
						<td>${relato.patologia.nomePatologia}</td>
						<td><fmt:formatDate pattern="dd/MM/yyy"
								value="${relato.patologia.dataInicio.time}" /></td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${notice != null}">
			<div class="alert alert-primary" role="alert">${notice}</div>
		</c:if>
	</div>
</body>
</html>