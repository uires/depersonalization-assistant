<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Despersonalização Assistente - ${} </title>
</head>
<body>
	<div class="d-flex flex-column bd-highlight mb-3">
		<c:forEach var="item" items="${relato}">
			<div class="p-2 bd-highlight">
				<div>${item.descricao}</div>
				<div>${item.patologia.nomePatologia}</div>
				<div><fmt:formatDate value="${item.patologia.dataInicio.time}" pattern="dd/MM/yyyy"/></div>			
			</div>
		</c:forEach>
	</div>
</body>
</html>