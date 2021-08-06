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
import model.Aluno;
import model.Emprestimo;

/**
 *
 * @author Alan Nascimento
 */

public class AlunoDAO  extends ExecuteSQL{
    
    public AlunoDAO(Connection conexao) {
        super(conexao);
    }
    
    public List<Aluno> listarAluno() {
        List<Aluno> lista = new ArrayList<>();
        ResultSet rs = listar("SELECT * FROM tb_aluno ORDER BY nome_aluno ASC");
        try {
            if (rs != null) {
                while (rs.next()) {
                    Aluno a = new Aluno(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getDate(6),
                            rs.getString(7),
                            rs.getInt(8)
                    );
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Aluno selecionarAluno(int id) {
        Aluno a = null;
        ResultSet rs = listar("SELECT * FROM tb_aluno WHERE id_aluno = ?", String.valueOf(id));
        try {
            if (rs != null) {
                while (rs.next()) {
                    a = new Aluno(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getInt(8)
                    );
                }
                return a;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Aluno loginAluno(String matricula, String senha) {
        Aluno a = null;
        
        String dados[] = new String[]{
            matricula,
            senha
        };
        
        ResultSet rs = listar("SELECT * FROM tb_aluno WHERE matricula_aluno = ? AND senha_aluno=? ", dados);
        try {
            if (rs != null) {
                while (rs.next()) {
                    a = new Aluno(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getInt(8)
                    );
                }
                return a;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public int retornaIdAluno(String matricula) {
        int id = -1;
        ResultSet rs = listar("SELECT id_aluno FROM tb_aluno WHERE matricula_aluno = ?", matricula);
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
    
    public boolean existeAluno(String matricula) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_aluno WHERE matricula_aluno = ?", matricula);
        try {
            if (rs != null) {
                while (rs.next()) {
                    existe = true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return existe;
    }
    
    public boolean addAluno(Aluno a){
        
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        
        String dados[] = new String[]{
            a.getMatricula(),
            a.getNome(),
            a.getSenha(),
            a.getCpf(),
            formatoData.format(a.getDataNascimento()),
            a.getTelefone(),
            String.valueOf(a.getIdCurso()),
        };
        return executar("INSERT INTO tb_aluno VALUES (0,?,?,?,?,?,?,?)", dados);
    }
    
    public boolean delAluno(Aluno a){
        String dados = String.valueOf(a.getId());
        return executar("DELETE FROM tb_aluno WHERE id_aluno = ?", dados);
    }
}
