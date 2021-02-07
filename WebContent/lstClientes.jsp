<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HUGOMED</title>
<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="card">
		<div class="card-header">
			<h1 class="text-align-left">Clientes Cadastrados</h1>
		</div>
		
		<div class="card-body">
			<table class="table">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Email</th>
						<th>Telefone</th>
						<th>Editar</th>
						<th>Excluir</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${lstCliente}" var="item" >
					<tr>
						<td>${item.nome}</td>
						<td>${item.email}</td>
						<td>${item.telefone}</td>
						<td><a href="ClienteSV?action=editar&id=${ item.id}">Editar</a></td>
						<td><a href="ClienteSV?action=excluir&id=${ item.id}">Excluir</a></td>	
					</tr>
					</c:forEach>
					
					<tr>
						<td colspan="6">
							<button type="button" class="btn btn-success" name="btn" value="Novo" onclick="window.location.href='ClienteSV?action=novo'">Novo</button>
							<button type="button" class="btn btn-warning" name="btn" value="Home" onclick="window.location.href='menu.jsp'">Home</button>
						</td>
					</tr>
					
				</tbody>
			</table>
			
		
		</div>
	
	</div>

</body>
</html>