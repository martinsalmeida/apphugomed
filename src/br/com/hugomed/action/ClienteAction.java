package br.com.hugomed.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hugomed.entity.Cliente;
import br.com.hugomed.persistence.ClienteDAO;
import br.com.hugomed.util.Funcoes;

public class ClienteAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String action = request.getParameter("action");
		
		
		switch (action) {

		case "novo":
			request.setAttribute("objCliente", new Cliente());
			request.getRequestDispatcher("frmclientes.jsp").forward(request, response);
			break;
		
		case "listar":
			request.setAttribute("lstCliente", new ClienteDAO().getClientes());
			request.getRequestDispatcher("lstClientes.jsp").forward(request, response);
			break;

		case "salvar":
			if(save(request)) {
				request.setAttribute("msg", "Operação realizada com sucesso!");
			}else {
				request.setAttribute("msg","Erro ao realizar a operação!");
			}
			request.setAttribute("objCliente", new Cliente());
			request.getRequestDispatcher("frmclientes.jsp").forward(request, response);
			break;
		
		case "editar":{
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("objCliente", new ClienteDAO().getCliente(id));
			request.getRequestDispatcher("frmclientes.jsp").forward(request, response);
			break;
		}
		
		case "excluir":{
			int id = Integer.parseInt(request.getParameter("id"));
			new ClienteDAO().excluir(id);
			request.setAttribute("lstClientes", new ClienteDAO().getClientes());
			request.getRequestDispatcher("lstClientes.jsp").forward(request, response);
			break;
		}
		default:
			break;
		}

	}

	private boolean save(HttpServletRequest request) {

		Cliente cliente = getParameters(request);

		
		if (cliente.getId() == 0) {
			
			return new ClienteDAO().incluir(cliente);
		} else {
			return new ClienteDAO().alterar(cliente);
		}
	}

	private Cliente getParameters(HttpServletRequest request) {
		Cliente cliente = new Cliente();
		
		
		cliente.setId(Integer.parseInt(request.getParameter("id")));


		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setCelular(request.getParameter("celular"));
		cliente.setEstadoCivil(request.getParameter("estadoCivil"));
		cliente.setPlanoSaude(request.getParameter("planoSaude"));
		cliente.setSexo(request.getParameter("sexo"));
		cliente.setDependente(Boolean.parseBoolean(request.getParameter("dependente")));
		cliente.setDtNasc(Funcoes.strToDate(request.getParameter("dtNasc")));

		return cliente;
	}

}
