/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzasystem.conn;

/**
 *
 * @author Michael
 */
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

//Início da classe de conexão//
public class ConnectionFactory {
    
    //Não apagar!
//    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
//    private static final String PASS = "";

    private static final String URL = "jdbc:mysql://localhost:3306/pizza_db";
    private static final String DRIVER_CLASS_MYSQL = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "admin";


    public static String status = "Banco de dados não conectado...";

//Método de Conexão//
    public static Connection getConnection() {

        Connection connection = null;          //atributo do tipo Connection

        try {
            Class.forName(DRIVER_CLASS_MYSQL);

            connection = DriverManager.getConnection(URL, USER, PASS);

            //Testa conexão//  
            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado

            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }

    }

    //Método que retorna o status da sua conexão//
    public static String statusConection() {

        return status;

    }

    //Método que fecha sua conexão//
    //Antigo
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
    //Novo
    public static boolean FecharConexao() {

        try {

            ConnectionFactory.getConnection().close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }

    //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();

        return ConnectionFactory.getConnection();

    }
    */

}

