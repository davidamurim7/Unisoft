/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Alan Nascimento
 */
public class Emprestimo {
    private int id;
    private Date dataInicio;
    private Date dataFim;
    private int idLivro;
    private int idAluno;

    public Emprestimo(int id, Date dataInicio, Date dataFim, int idLivro, int idAluno) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.idLivro = idLivro;
        this.idAluno = idAluno;
    }

    public Emprestimo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    
    
}
