/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

import foundtruck.ConectaServidor.FavoritoResource;
import foundtruck.models.Favorito;
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
public class FavoritoMB implements Serializable{

    Favorito favorito;
    FavoritoResource resource;
    private FacesContext context;
    private ExternalContext ec;
    /**
     * Creates a new instance of FavoritoMB
     */
    public FavoritoMB() {
        
        favorito = new Favorito();
        resource = new FavoritoResource();
        context = FacesContext.getCurrentInstance();
        ec = context.getExternalContext();
        
    }
    
    public Favorito getFavorito(){
    
    return favorito;
        
    }
    
    public void setFavorito(Favorito favorito){
    
    this.favorito = favorito;
    
    }
    
}
