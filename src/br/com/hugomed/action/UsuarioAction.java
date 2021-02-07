package br.com.hugomed.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hugomed.entity.Usuario;
import br.com.hugomed.persistence.UsuarioDAO;
import br.com.hugomed.util.CriptografiaMD5;

public class UsuarioAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equals("logar")) {
			
			
			/*
			 * Usuario us1 = new Usuario(); us1.setNome("Joao");
			 * us1.setLogin("jao@gmail.com");
			 * us1.setSenha(CriptografiaMD5.encrypt("12345")); us1.setNivel("a");
			 * us1.setStatus(true);
			 * 
			 * new UsuarioDAO().incluir(us1);
			 */
			
			
			String login = request.getParameter("login");
			String senha = CriptografiaMD5.encrypt(request.getParameter("senha"));

			Usuario usuario = new UsuarioDAO().getUsuario(login, senha);

			if (usuario != null) {
				if (!usuario.isStatus()) {
					request.setAttribute("msg", "Favor procurar o departamento técnico!");
					request.getRequestDispatcher("index.jsp").forward(request, response);
					return;

				} else {
					request.getSession().setAttribute("objUsuarioSS", usuario);
					request.getRequestDispatcher("menu.jsp").forward(request, response);
					return;
				}
			} else {
				request.setAttribute("msg", "Erro ao logar! Email e senha não encontrados");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}
		}
		
		if(action.equals("logout")) {
			request.getSession().removeAttribute("objUsuarioSS");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
