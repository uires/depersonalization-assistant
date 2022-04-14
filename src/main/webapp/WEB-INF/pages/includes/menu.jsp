<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link href="<spring:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link href="<spring:url value="/resources/css/style.css" />"
	rel="stylesheet" />
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-dark">
<div class="container">
	<a class="navbar-brand" href="<c:url value="/dashboard" />"> <img
		src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBl
					bmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0c
					mF0b3IgMTYuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMC
					BCdWlsZCAwKSAgLS0+CjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkc
					gMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2
					ZzExLmR0ZCI+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4b
					Wxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS
					4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgd2lkdGg9IjMycHgiIGhlaWdodD0
					iMzJweCIgdmlld0JveD0iMCAwIDU1MS4zOTEgNTUxLjM5MSIgc3R5bGU9ImVuYWJsZS1i
					YWNrZ3JvdW5kOm5ldyAwIDAgNTUxLjM5MSA1NTEuMzkxOyIgeG1sOnNwYWNlPSJwcmVzZ
					XJ2ZSI+CjxnPgoJPHBhdGggZD0iTTQxMy42OTUsMGMwLDAtNDUuMzY2LDQ0LjAxNC05NC
					40Myw2MS43NTlDLTQ0LjA2OCwxOTMuMTc4LDEwOS4xNjUsNDQ5LjI3NywxMTQuMTY0LDQ
					1MC4xMjEgICBjMCwwLDIwLjM3NC0zNS40OCw0Ny44OTYtNTUuNzE3YzE3NC42NDQtMTI4
					LjM4OSwyMTAuMTQtMjc2LjE3MSwyMTAuMTQtMjc2LjE3MXMtMzkuMTksMTc3LjgyOS0xOTQ
					uNTYyLDI4OC40NzkgICBjLTM0LjMxNiwyNC40MjYtNTcuNTUyLDg0LjU2OC02Ny4zODgsM
					TQ0LjY3OWMwLDAsMjQuMzI1LTkuODI4LDM0Ljc4NS0xMi40OWM0LjA3OS0yNi42MTgsMTI
					uNjA3LTUyLjEwNiwyNy4wMjUtNzQuODc1ICAgYzIxNy4xNTEsMjUuODU0LDI4OC4yNzItMT
					Q5LjEyMywyOTcuNTYzLTIxMC4xMzZDNDkxLjU1MiwxMDkuNzksNDEzLjY5NSwwLDQxMy42O
					TUsMHoiIGZpbGw9IiNGRkZGRkYiLz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9n
					Pgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9
					nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC
					9nPgo8L3N2Zz4K" />
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/dashboard" />">Dashboard</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/relatorio/relatorios-publicos" />">Relatórios</a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/relatorio/meus-relatorios" />">Meus
					Relatórios</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/sobre" />">O que é despersonalização?</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/sair" />">Sair</a></li>

		</ul>
		<form class="form-inline my-2 my-lg-0" method="POST" action="buscar">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Buscar..." aria-label="Search" name="criterio">
			<button class="btn btn-outline my-2 my-sm-0" type="submit">Buscar</button>
		</form>
	</div>
</div>
</nav>
