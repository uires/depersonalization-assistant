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
<title>Despersonalização Assistente - Login</title>
</head>
<body>
	<c:import url="../includes/menu.jsp" />
	<div class="container" style="margin-top: 100px;">
		<form action="${spring:mvcUrl('LC#logar').build()}" method="POST">
			<div>
				<label>E-mail</label>
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">@</span>
					</div>
					<input name="email" type="email" class="form-control"
						placeholder="exemplo@com.br" required>
				</div>
			</div>
			<div>
				<label>Senha</label>
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">*</span>
					</div>
					<input name="senha" type="password" class="form-control" required><br />
				</div>
				<a href="<c:url value="/paciente/cadastro" />">Cadastre-se aqui</a>
			</div>
			<br />
			<button class="btn btn-primary" type="submit">Logar</button>
			${warning}
		</form>
	</div>
</body>
</html>