/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

import br.com.foundtruck.models.Cardapio;
import foundtruck.ConectaServidor.CardapioResource;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Thomas
 */
@ManagedBean
@ViewScoped
public class CardapioMB implements Serializable{

    Cardapio cardapio;
    CardapioResource resource;
    private FacesContext context;
    private ExternalContext ec;
    /**
     * Creates a new instance of CardapioMB
     */
    public CardapioMB() {
        
        cardapio = new Cardapio();
        resource = new CardapioResource();
        context = FacesContext.getCurrentInstance();
        ec = context.getExternalContext();
        
    }
    
      public Cardapio getCardapio(){
    
    return cardapio;
        
    }
    
    public void setCardapio(Cardapio cardapio){
    
    this.cardapio = cardapio;
    
    }
    
}
