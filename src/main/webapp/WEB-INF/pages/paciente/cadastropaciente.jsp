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
<title>DA - Cadastro Paciente</title>
</head>
<body>
	<div class="container">
		<form action="${spring:mvcUrl('PC#cadastro').build()} " method="POST">
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label>Nome</label> 
					<input name="nome" type="text" class="form-control" placeholder="Nome" required>
				</div>
				<div class="col-md-4 mb-3">
					<label>E-mail</label>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" >@</span>
						</div>
						<input name="email" type="email" class="form-control" placeholder="exemplo@com.br" required>
					</div>
				</div>
				<div class="col-md-4 mb-3">
					<label>Sexo</label> 
					<select name="sexo" class="form-control">
						<option value="M">Masculino</option>
						<option value="F">Femino</option>
						<option value="I">Indefinido</option>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-5 mb-3">
					<label>CPF</label>
					<input name="cpf" type="text" class="form-control" placeholder="011.000.000-13" maxlength="14" required>
				</div>
				<div class="col-md-4 mb-3">
					<label>Telefone</label>
					<input name="telefone" type="text" class="form-control" placeholder="(71)0000-0000" maxlength="13" required>
				</div>
			</div>
			
			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label>Cidade</label> 
					<input name="cidade" type="text" class="form-control" placeholder="ex: Salvador" required>
				</div>
				<div class="col-md-3 mb-3">
					<label>Estado</label> 
					<input type="text" name="estado" class="form-control" placeholder="ex: Bahia" required>
				</div>
				<div class="col-md-3 mb-3">
					<label>CEP</label> 
					<input type="text" class="form-control" name="cep" placeholder="99999-999" required>
				</div>
			</div>
			
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label>Rua</label>
					<input type="text" name="rua" placeholder="Av. Tatalo da Silva" class="form-control" required>
				</div>
				<div class="col-md-4 mb-3">
					<label>Complemento</label>
					<input type="text" name="complemento" class="form-control"/>
				</div>
			</div>
			<button class="btn btn-primary" type="submit">Cadastrar Paciente</button>
		</form>
	</div>
</body>
</html>