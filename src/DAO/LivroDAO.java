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
import model.Livro;

/**
 *
 * @author Alan Nascimento
 */
public class LivroDAO extends ExecuteSQL{
    
    public LivroDAO(Connection conexao) {
        super(conexao);
    }
    
    public List<Livro> listarLivro() {
        List<Livro> lista = new ArrayList<>();
        ResultSet rs = listar("SELECT * FROM tb_livro ORDER BY titulo_livro ASC");
        try {
            if (rs != null) {
                while (rs.next()) {
                    Livro l = new Livro(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6)
                    );
                    lista.add(l);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean existeLivro(String isbn) {
        boolean existe = false;
        ResultSet rs = listar("SELECT * FROM tb_livro WHERE isbn_livro = ?", isbn);
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
    
    public Livro selecionarLivro(int id) {
        Livro l = null;
        ResultSet rs = listar("SELECT * FROM tb_livro WHERE id_livro = ?", String.valueOf(id));
        try {
            if (rs != null) {
                while (rs.next()) {
                    l = new Livro(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                    );
                }
                return l;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public int retornaIdLivro(String tituloOuIsbn) {
        int id = -1;
        ResultSet rs = listar("SELECT id_livro FROM tb_livro WHERE titulo_livro = ? OR isbn_livro = ?", new String [] {tituloOuIsbn, tituloOuIsbn});
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
    
    public boolean addLivro(Livro l){
        
        String dados[] = new String[]{
            l.getIsbn(),
            l.getTitulo(),
            l.getAutor(),
            l.getImagem(),
            l.getDescricao(),
        };
        return executar("INSERT INTO tb_livro VALUES (0,?,?,?,?,?)", dados);
    }
    
    public boolean delLivro(Livro l){
        String dados = String.valueOf(l.getId());
        return executar("DELETE FROM tb_livro WHERE id_livro = ?", dados);
    }
}
