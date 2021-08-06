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
import model.Livro;

/**
 *
 * @author Alan Nascimento
 */
public class EmprestimoDAO extends ExecuteSQL{
    
    public EmprestimoDAO(Connection conexao) {
        super(conexao);
    }
    
    public List<Emprestimo> listarEmprestimo(int idAluno) {
        List<Emprestimo> lista = new ArrayList<>();
        ResultSet rs = listar("SELECT * FROM tb_emprestimo WHERE id_aluno_emprestimo = ? ORDER BY data_inicio_emprestimo ASC", String.valueOf(idAluno));
        try {
            if (rs != null) {
                while (rs.next()) {
                    Emprestimo e = new Emprestimo(
                            rs.getInt(1),
                            rs.getDate(2),
                            rs.getDate(3),
                            rs.getInt(4),
                            rs.getInt(5)
                    );
                    lista.add(e);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Emprestimo getEmprestimo(int idAluno, int idLivro) {
        String dados[] = new String[]{
            String.valueOf(idAluno),
            String.valueOf(idLivro)
        };
        ResultSet rs = listar("SELECT * FROM tb_emprestimo WHERE id_aluno_emprestimo = ? and id_livro_emprestimo = ? ORDER BY data_inicio_emprestimo ASC", dados);
        try {
            if (rs != null) {
                Emprestimo e = null;
                while (rs.next()) {
                    e = new Emprestimo(
                            rs.getInt(1),
                            rs.getDate(2),
                            rs.getDate(3),
                            rs.getInt(4),
                            rs.getInt(5)
                    );
                    
                }
                return e;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean existeEmprestimoAluno(int idAluno) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_emprestimo WHERE id_aluno_emprestimo = ?", String.valueOf(idAluno));
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
    
    public int retornaIdEmprestimo(int idAlunoEmprestimo) {
        int id = -1;
        ResultSet rs = listar("SELECT id_emprestimo FROM tb_emprestimo WHERE id_aluno_emprestimo = ?", String.valueOf(idAlunoEmprestimo));
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
    
    public boolean existeEmprestimo(int idLivro, int idAluno) {
        boolean existe = false;
        String dados[] = new String[]{
            String.valueOf(idLivro),
            String.valueOf(idAluno)
        };
        
        ResultSet rs = listar("SELECT * FROM tb_emprestimo WHERE id_livro_emprestimo = ? and id_aluno_emprestimo= ? ", dados);
        
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
    
    public int quantidadeEmprestimo(int idAluno) {
        boolean existe = false;
        String dado = String.valueOf(idAluno);
        int cont=0;
        ResultSet rs = listar("SELECT * FROM tb_emprestimo WHERE id_aluno_emprestimo= ? ", dado);
        
        try {
            if (rs != null) {
                while (rs.next()) {
                    cont++;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return cont;
    }
    
    public boolean addEmprestimo(Emprestimo e){
        
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        
        String dados[] = new String[]{
            formatoData.format(e.getDataInicio()),
            formatoData.format(e.getDataFim()),
            String.valueOf(e.getIdLivro()),
            String.valueOf(e.getIdAluno())
        };
        return executar("INSERT INTO tb_emprestimo VALUES (0,?,?,?,?)", dados);
    }
    
    public boolean delEmprestimo(int idAluno, int idLivro){
        String dados[] = new String[]{
            String.valueOf(idAluno),
            String.valueOf(idLivro)
        };
        return executar("DELETE FROM tb_emprestimo WHERE id_aluno_emprestimo = ? and id_livro_emprestimo=?" , dados);
    }
}
