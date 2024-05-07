/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContextEvent;

/**
 *
 * @author Senai
 */
public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/elitetech_ds";
    private static final String user = "root";
    private static final String password = "";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static Connection con;

    public static Connection conectar() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static void fecharConexao() {
        try {
            if (con != null) {
                con.close();
            }
            DriverManager.deregisterDriver(DriverManager.getDriver(url));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
