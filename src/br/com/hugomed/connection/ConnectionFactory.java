package br.com.hugomed.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mcgill Dias
 */
public class ConnectionFactory {

    private static Connection conn = null;
    private final static String SERVIDOR = "localhost";
    private final static String BANCO_DADOS = "hugomed_db";
    private final static String PORTA = "5432";
    private final static String USUARIO = "postgres";
    private final static String SENHA = "root";

    private static Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://" + SERVIDOR + ":" + PORTA + "/" + BANCO_DADOS, USUARIO, SENHA);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 

    }

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = conectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
                closeConnection(conn);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                closeConnection(conn, ps);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
