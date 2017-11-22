package br.com.foundtruck.models;

public class Usuario {

    private String email;
    private String senha;
    private String nome;
    private String ativo;
    private String foodtruck;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getFoodtruck() {
        return foodtruck;
    }

    public void setFoodtruck(String foodtruck) {
        this.foodtruck = foodtruck;
    }

}
