/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
import model.Emprestimo;
import model.Livro;

/**
 *
 * @author David
 */
public class CursoDAO extends ExecuteSQL{
    
    public CursoDAO(Connection conexao) {
        super(conexao);
    }
    
    public List<Curso> listarCurso() {
        List<Curso> lista = new ArrayList<>();
        ResultSet rs = listar("SELECT * FROM tb_curso ORDER BY nome_curso ASC");
        try {
            if (rs != null) {
                while (rs.next()) {
                    Curso c = new Curso(
                            rs.getInt(1),
                            rs.getString(2)
                    );
                    lista.add(c);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public int retornaIdCurso(String nome) {
        int id = -1;
        ResultSet rs = listar("SELECT id_curso FROM tb_curso WHERE nome_curso = ?", nome);
        try {
            if (rs != null) {
                while (rs.next()) {
                    id = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return id;
    }
    
    public Curso selecionarCurso(int id) {
        Curso c = null;
        ResultSet rs = listar("SELECT * FROM tb_curso WHERE id_curso = ?", String.valueOf(id));
        try {
            if (rs != null) {
                while (rs.next()) {
                    c = new Curso(
                        rs.getInt(1),
                        rs.getString(2)
                    );
                }
                return c;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
