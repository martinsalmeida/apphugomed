package br.com.hugomed.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hugomed.connection.ConnectionFactory;
import br.com.hugomed.entity.Usuario;

public class UsuarioDAO {

	private String sql;

	public boolean incluir(Usuario usuario) {
		boolean isOk = false;

		Connection conn = null;
		PreparedStatement ps = null;

		conn = ConnectionFactory.getConnection();
		if (conn == null) {
			return isOk;
		}

		sql = "INSERT INTO usuario(nome, login, senha, nivel, status) VALUES (?,?,?,?,?)";

		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getNivel());
			ps.setBoolean(5, usuario.isStatus());

			ps.executeUpdate();
			isOk = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

		return isOk;
	}

	public boolean alterar(Usuario usuario) {
		boolean isOk = false;

		Connection conn = null;
		PreparedStatement ps = null;

		conn = ConnectionFactory.getConnection();

		if (conn == null) {
			return isOk;
		}

		sql = "UPDATE usuario SET nome=?, login=?, senha=?, nivel=?, status=?";

		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getNivel());
			ps.setBoolean(5, usuario.isStatus());

			ps.executeUpdate();
			isOk = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

		return isOk;
	}

	public Usuario getUsuario(String login, String senha) {

		Usuario usuario = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		conn = ConnectionFactory.getConnection();
		if (conn == null) {
			return usuario;
		}

		sql = "SELECT * FROM usuario WHERE login=? AND senha=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);

			rs = ps.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivel(rs.getString("nivel"));
				usuario.setStatus(rs.getBoolean("status"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}

		return usuario;

	}

	public List<Usuario> getUsuarios() {

		List<Usuario> usuarios = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		conn = ConnectionFactory.getConnection();

		if (conn == null) {
			return usuarios;
		}

		sql = "SELECT * FROM usuario ORDER BY nome ";

		try {

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			usuarios = new ArrayList<Usuario>();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivel(rs.getString("nivel"));
				usuario.setStatus(rs.getBoolean("status"));

				usuarios.add(usuario);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}

		return usuarios;

	}

}
