<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav navbar-light">
				<li class="nav-item"><a class="nav-link" href="ClienteSV?action=novo">Cadastrar
						Cliente</a></li>
				<li class="nav-item"><a class="nav-link" href="ClienteSV?action=listar">Listar
						Cliente</a></li>
			</ul>
		</div>
		<div style="color: #ccc" class="d-flex align-items-center">
			
			<div >
				<strong>${objUsuarioSS.nome}</strong> 
			</div>
			
			
			<input class="btn btn-danger ms-2"
				type="button" name="btn" value="Sair"
				onclick="window.location.href='UsuarioSV?action=logout'" />
			
			
			
		</div>
	</div>
</nav>
