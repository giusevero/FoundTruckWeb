package br.com.foundtruck.models;

import java.util.Date;

public class Comentario {

    private int id_foodtruck;
    private String autor;
    private Date data;
    private String comentario;
    private int avaliacao;
    
    

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getId_foodtruck() {
        return id_foodtruck;
    }

    public void setId_foodtruck(int id_foodtruck) {
        this.id_foodtruck = id_foodtruck;
    }

    public int getAvalaicao() {
        return avaliacao;
    }

    public void setAvalaicao(int avalaicao) {
        this.avaliacao = avalaicao;
    }

    
}
