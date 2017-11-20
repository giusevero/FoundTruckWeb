/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.models;

/**
 *
 * @author giusevero
 */
public class Cardapio {
    
    private int id;
    private String nome_alimento;
    private String desc_alimento;
    private double valor;
    private String imagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_alimento() {
        return nome_alimento;
    }

    public void setNome_alimento(String nome_alimento) {
        this.nome_alimento = nome_alimento;
    }

    public String getDesc_alimento() {
        return desc_alimento;
    }

    public void setDesc_alimento(String desc_alimento) {
        this.desc_alimento = desc_alimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    
}
