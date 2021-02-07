<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
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
	
	<div class="container">
			<div class="row mx-auto justify-content-center align-items-center h-100" id="formLogin">
				<div class="card p-0">
				<div class="card-header">
					<h2>Sistema HugoMed</h2>
				</div>
				<div class="card-body">
					<form action="UsuarioSV" method="post">
						<input type="hidden" name="action" value="logar">
						<div class="mb-3">
							<label class="form-label">Login</label>
							<input type="text" class="form-control" name="login" placeholder="Digite o email" required>

						</div>
						<div class="mb-3">
							<label class="form-label">Password</label>
							<input type="password" class="form-control" name="senha" placeholder="Digite a sua senha" required>
						</div>

						<button type="submit" class="btn btn-primary" name="btn" value="Acessar">Login</button>
						<button type="reset" class="btn btn-secondary" name="btn" value="Cancelar">Cancelar</button>
					</form>
				</div>
				<div class="card-footer">
					<h6 class="mb-0" style="color: red">${msg}</h6>
				</div>
			</div> 
		</div>
	</div>
</body>
</html>