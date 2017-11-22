/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;


import br.com.foundtruck.models.Alimento;
import foundtruck.ConectaServidor.AlimentoResource;
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
public class AlimentoMB implements Serializable{

    Alimento alimento;
    AlimentoResource resource;
    private FacesContext context;
    private ExternalContext ec;
    
    /**
     * Creates a new instance of AlimentoMB
     */
    public AlimentoMB() {
        
        alimento = new Alimento();
        resource = new AlimentoResource();
        context = FacesContext.getCurrentInstance();
        ec = context.getExternalContext();
        
    }
    
    public Alimento getAlimento(){
    
    return alimento;
        
    }
    
    public void setAlimento(Alimento alimento){
    
    this.alimento = alimento;
    
    }
    
}
