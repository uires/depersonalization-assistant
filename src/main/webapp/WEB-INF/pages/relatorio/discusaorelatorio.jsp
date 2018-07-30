<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<div>
	
	</div>
	<div class="d-flex flex-column bd-highlight mb-3">
		<hr />
		<c:forEach var="comentario" items="${relato.comentarios}">
			<div class="p-2 bd-highlight div-controll">
				<div  class="img-"><img src="" width="155" height="155" /></div>
				<div><h3>${comentario.titulo}</h3></div>
				<div>Autor: ${comentario.nomeAutor}</div><br />
				<div>${comentario.descricao}</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>