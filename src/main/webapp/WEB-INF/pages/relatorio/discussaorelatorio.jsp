<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<spring:url value="/resources/css/style.css"/>"	rel="stylesheet" />
<link href="<spring:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
<title>Despersonalização Assistente - ${relato.titulo} </title>
</head>
<body>
	<c:import url="../includes/menu.jsp" />

	<div class="d-flex flex-column bd-highlight mb-3" style="margin-top: 55px;">
		<div class="p-2 bd-highlight div-controll">
			<div style="float: right;">
				<i>${relato.patologia.nomePatologia}</i><br />
				<i><fmt:formatDate value="${relato.patologia.dataInicio.time}" pattern="dd/MM/YYYY"/></i>
			</div>
			<div class="img-discuc"><img src="https://png.icons8.com/android/1600/user.png" width="85" height="85" /></div>
			<div><h4>${relato.titulo}</h4></div>
			<div>${relato.descricao}</div>
		</div>
	</div>		
	
	<hr />
	<div class="d-flex flex-column bd-highlight mb-3">
		<c:forEach var="comentario" items="${relato.comentarios}">
			<div class="p-2 bd-highlight div-controll">
				<div class="img-discuc">
					<img src="https://png.icons8.com/android/1600/user.png" width="55" height="55" /><br />
					${comentario.nomeAutor}
				</div>
				<div><h4>${comentario.titulo}</h4></div>
				<div>${comentario.descricao}</div>
			</div>
		</c:forEach>
	</div>
	<div>
		<form method="POST" action="${spring:mvcUrl('').build()}">
			<input type="hidden" value="${relato.id}">
			<div>
				<label>Título</label>
				<input type="text" name="titulo" class="form-control" />
			</div>
			
			<div>
				<label>Descrição</label>
				<textarea rows="3" cols="5" name="descricao" class="form-controll" ></textarea>
			</div>
			<button class="btn btn-primary" type="submit">Enviar</button>					
		</form>
	</div>
	
	
</body>
</html>