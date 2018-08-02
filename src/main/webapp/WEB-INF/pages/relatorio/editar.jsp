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
<link href="<spring:url value="/resources/css/style.css"/>"	rel="stylesheet" />
<link href="<spring:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Despersonalização Assistent - Editar</title>
</head>
<body>
	<c:import url="../includes/menu.jsp" />
	<div class="container" style="margin-top: 100px;">
		<form action="${spring:mvcUrl('RC#editar').build()}" method="POST">
			<div>
				<label>Descrição</label>
				<textarea name="descricao" type="text" class="form-control" required></textarea>
			</div>
			<input type="hidden" > 
			<br />
			<button class="btn btn-primary" type="submit">Relatar</button>
		</form>
	</div>
</body>
</html>