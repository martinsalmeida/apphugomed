package br.com.hugomed.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hugomed.connection.ConnectionFactory;
import br.com.hugomed.entity.Cliente;

public class ClienteDAO {

	private String sql = "";

	public boolean incluir(Cliente cliente) {

		boolean isOk = false;

		Connection conn = null;
		PreparedStatement ps = null;

		conn = ConnectionFactory.getConnection();
		if (conn == null) {
			return isOk;
		}

		sql = "INSERT INTO cliente(nome, email, telefone, celular, sexo, dtNasc, planoSaude, dependente, estadoCivil) VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getCelular());
			ps.setString(5, cliente.getSexo());
			ps.setDate(6, new java.sql.Date(cliente.getDtNasc().getTime()));
			ps.setString(7, cliente.getPlanoSaude());
			ps.setBoolean(8, cliente.isDependente());
			ps.setString(9, cliente.getEstadoCivil());

			ps.executeUpdate();
			isOk = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

		return isOk;
	}

	public boolean alterar(Cliente cliente) {

		boolean isOk = false;

		Connection conn = null;
		PreparedStatement ps = null;

		conn = ConnectionFactory.getConnection();
		if (conn == null) {
			return isOk;
		}

		sql = "UPDATE cliente SET nome=?, email=?, telefone=?, celular=?, sexo=?, dtNasc=?, planoSaude=?, dependente=?, estadoCivil=? WHERE id=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getCelular());
			ps.setString(5, cliente.getSexo());
			ps.setDate(6, new java.sql.Date(cliente.getDtNasc().getTime()));
			ps.setString(7, cliente.getPlanoSaude());
			ps.setBoolean(8, cliente.isDependente());
			ps.setString(9, cliente.getEstadoCivil());
			ps.setInt(10, cliente.getId());

			ps.executeUpdate();
			isOk = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

		return isOk;
	}

	public Cliente getCliente(int id) {

		Cliente cliente = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		conn = ConnectionFactory.getConnection();
		if (conn == null) {
			return cliente;
		}

		sql = "SELECT * from cliente WHERE id=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCelular(rs.getString("celular"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setDtNasc(rs.getDate("dtNasc"));
				cliente.setPlanoSaude(rs.getString("planoSaude"));
				cliente.setDependente(rs.getBoolean("dependente"));
				cliente.setEstadoCivil(rs.getString("estadoCivil"));
			}
			return cliente;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

		return cliente;
	}

	public List<Cliente> getClientes() {

		List<Cliente> clientes = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		conn = ConnectionFactory.getConnection();
		if (conn == null) {
			return clientes;
		}

		sql = "SELECT * FROM cliente ORDER BY nome";

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			clientes = new ArrayList<Cliente>();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCelular(rs.getString("celular"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setDtNasc(rs.getDate("dtNasc"));
				cliente.setDependente(rs.getBoolean("dependente"));
				cliente.setEstadoCivil(rs.getString("estadoCivil"));

				clientes.add(cliente);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

		return clientes;

	}

	public boolean excluir(int id) {

		boolean isOk = false;

		Connection conn = null;
		PreparedStatement ps = null;

		conn = ConnectionFactory.getConnection();

		if (conn == null) {
			return isOk;
		}

		sql = "DELETE FROM cliente where id=?";

		try {

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();

			isOk = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

		return isOk;
	}

}
