/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Admin;
import model.Aluno;
import model.Emprestimo;

/**
 *
 * @author Alan Nascimento
 */
public class AdminDAO extends ExecuteSQL{

    public AdminDAO(Connection conexao) {
        super(conexao);
    }

       public Admin loginAdmin(String usu, String senha) {
        Admin ad = null;
        
        String dados[] = new String[]{
            usu,
            senha
        };
        
        ResultSet rs = listar("SELECT * FROM tb_admin WHERE usuario_admin = ? AND senha_admin = ? ", dados);
        try {
            if (rs != null) {
                while (rs.next()) {
                    ad = new Admin(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                    );
                }
                return ad;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
