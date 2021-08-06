package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {

    public static Connection conectar() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_unisoft", "root", "root");
        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + erro);
        }
        
        return conexao;
    }

    public static void desconectar(Connection conexao) {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
