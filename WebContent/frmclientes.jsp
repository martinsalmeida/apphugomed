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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.maskedinput.min.js"></script>
<script>
    jQuery(function ($) {
        $('#telefone').mask("(99) 9999-9999");
        $('#celular').mask("(99) 99999-9999");
    });
</script>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container-fluid">

		<div class="card">
			<div class="card-header">
				<h1 class="text-align-left">Cadastrar Clientes</h1>
			</div>

			<div class="card-body">

				<form action="ClienteSV" method="post" class="row">
					<input type="hidden" name="action" value="salvar">
					<input type="hidden" name="id" value="${objCliente.id}">
					
					<div class="col-md-6 mb-3">
						<label class="form-label">Nome</label>
						<input type="text" class="form-control" name="nome"
							value="${objCliente.nome}">
					</div>
					<div class="col-md-6 mb-3">
						<label class="form-label">Email</label>
						<input	type="email" class="form-control" name="email"
							value="${objCliente.email}" />
					</div>

					<div class="col-md-4 mb-3">
						<label class="form-label">Telefone</label>
						<input type="text" class="form-control" id="telefone" name="telefone"
						  value="${objCliente.telefone}"	>
					</div>
					<div class="col-md-4 mb-3">
						<label class="form-label">Celular</label>
						<input type="text" class="form-control" id="celular" name="celular" 
							value="${objCliente.celular}">
					</div>
				<div class="col-md-4 mb-3">
						<label class="form-label">Sexo</label> <select
							id="inputSexo" class="form-select" name="sexo"  >
							<option selected>Selecione o Sexo</option>
							<option value="Masculino" <c:if test="${objCliente.sexo == 'Masculino'}"> selected </c:if> >Masculino</option>
							<option value="Feminino" <c:if test="${objCliente.sexo == 'Feminino'}"> selected </c:if> >Feminino</option>
						</select>
					</div> 
					<div class="col-md-3 mb-3">
						<label class="form-label">Estado Civil</label>
						<select class="form-select" name="estadoCivil">
							<option value="" >Selecione o estado civil</option>
							<option value="Solteiro(a)" <c:if test="${objCliente.estadoCivil == 'Solteiro(a)'}">selected</c:if> >Solteiro(a)</option>
							<option value="Casado(a)" <c:if test="${objCliente.estadoCivil == 'Casado(a)'}">selected</c:if> >Casado(a)</option>
							<option value="Separado(a)" <c:if test="${objCliente.estadoCivil == 'Separado(a)'}">selected</c:if> >Separado(a)</option>
							<option value="Divorciado(a)" <c:if test="${objCliente.estadoCivil == 'Divorciado(a)'}">selected</c:if> >Divorciado(a)</option>
							<option value="Viuvo(a)" <c:if test="${objCliente.estadoCivil == 'Viuvo(a)'}">selected</c:if> >Viuvo(a)</option>
							<option value="União Estáve(a)" <c:if test="${objCliente.estadoCivil == 'União Estáve(a)'}">selected</c:if> >União Estáve(a)</option>
						</select>
					</div>
					<div class="col-md-3 mb-3">
						<label class="form-label">Plano de Saúde</label>
						<select class="form-select" name="planoSaude">
							<option value="">Selecione o Plano de Saúde</option>
							<option value="Unimed" <c:if test="${objCliente.planoSaude == 'Unimed'}"> selected </c:if> >Unimed</option>
							<option value="Golden Cross" <c:if test="${objCliente.planoSaude == 'Golden Cross'}"> selected </c:if> >Golden Cross</option>
							<option value="Bradesco Seguros" <c:if test="${objCliente.planoSaude == 'Bradesco Seguros'}"> selected </c:if> >Bradesco Seguros</option>
							<option value="Amil" <c:if test="${objCliente.planoSaude == 'Amil'}"> selected </c:if> >Amil</option>
							<option value="Promede" <c:if test="${objCliente.planoSaude == 'Promede'}"> selected </c:if> >Promede</option>
						</select>
					</div> 
					<div class="col-md-3 mb-3">
						<label class="form-label">Data de Nascimento</label>
						<input type="date" class="form-control" name="dtNasc" value="${objCliente.dtNasc}">
					</div>

					<div class="col-md-3 mb-3">
						<label class="form-label">Possui Dependente?</label>

						<div class="form-group">
							<label class="form-check-label">Sim</label>
								<input class="form-check-input" type="radio" id="radio1" name="dependente" value="true" <c:if test="${objCliente.dependente}">checked</c:if> >
							<label class="form-check-label">Não</label>
								<input class="form-check-input" type="radio" id="radio2" name="dependente" value="false" <c:if test="${!objCliente.dependente}">checked</c:if> >

						</div>

					</div>
					<hr>

					<div class="col-12">
						<button type="submit" class="btn btn-primary">Salvar</button>
						<button type="reset" class="btn btn-danger">Cancelar</button>
						<button type="button" class="btn btn-secondary" name="btn" value="Home" onclick="window.location.href='menu.jsp'">Home</button>
					</div>

				</form>
				<c:if test="${msg != null}">
					<div class="alert alert-warning alert-dismissible fade show mt-3" role="alert">
	  			<strong>${msg}</strong>
			</div>
		</c:if>

			</div>

		</div>

	</div>

</body>
</html>