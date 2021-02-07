package br.com.hugomed.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hugomed.action.UsuarioAction;
/**
 * Servlet implementation class UsuarioSV
 */
@WebServlet("/UsuarioSV")
public class UsuarioSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF=8");
		
				
		new UsuarioAction().execute(request, response);
		
	}

}
