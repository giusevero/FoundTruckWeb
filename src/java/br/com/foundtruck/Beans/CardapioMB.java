/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Beans;

import br.com.foundtruck.ConectaServidor.CardapioResource;
import br.com.foundtruck.models.Cardapio;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Thomas
 */
@Named(value = "cardapioMB")
@ViewScoped
public class CardapioMB implements Serializable {

    Cardapio cardapio;
    CardapioResource resource;
    private FacesContext context;
    private ExternalContext ec;
    
    private String valor;

    /**
     * Creates a new instance of cardapioMB
     */
    public CardapioMB() {
        cardapio = new Cardapio();
        resource = new CardapioResource();
        context = FacesContext.getCurrentInstance();
        ec = context.getExternalContext();
    }

    public void Registrar() {

        try {
            
            cardapio.setValor(Double.parseDouble(valor));
            resource.cadastrarC(cardapio);

            context = FacesContext.getCurrentInstance();
            ec = context.getExternalContext();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registro feito com sucesso!"));

            ec.redirect("Cardapio.xhtml");
        } catch (Exception e) {
            e.printStackTrace();

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro no registro! Tente de novo"));
        }
    }

    public void Atualizar() {

        try {

            resource.atualizaC(cardapio);

            context = FacesContext.getCurrentInstance();
            ec = context.getExternalContext();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registro atualizado com sucesso!"));

            ec.redirect("Cardapio.xhtml");
        } catch (Exception e) {
            e.printStackTrace();

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro no registro! Tente de novo"));
        }

    }

    public Cardapio getCardapio() {

        return cardapio;

    }

    public void setCardapio(Cardapio cardapio) {

        this.cardapio = cardapio;

    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
