/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Beans;

import br.com.foundtruck.ConectaServidor.AlimentoResource;
import br.com.foundtruck.models.Alimento;
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
@Named(value = "alimentoMB")
@ViewScoped
public class AlimentoMB implements Serializable{

    Alimento alimento;
    AlimentoResource resource;
    private FacesContext context;
    private ExternalContext ec;
    /**
     * Creates a new instance of alimentoMB
     */
    public AlimentoMB() {
        alimento = new Alimento();
        resource = new AlimentoResource();
        context = FacesContext.getCurrentInstance();
        ec = context.getExternalContext();
    }
    
        public void Registrar(){
        
            try{
        resource.cadastrarA(alimento);
            
        context = FacesContext.getCurrentInstance();
        ec = context.getExternalContext();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registro feito com sucesso!"));
            
            ec.redirect("Alimento.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro no registro! Tente de novo"));
        }
    }
        
        public void Atualizar(){
        
            try{
        resource.atualizaA(alimento);
        
        context = FacesContext.getCurrentInstance();
        ec = context.getExternalContext();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registro atualizado com sucesso!"));
            
            ec.redirect("Alimento.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro no registro! Tente de novo"));
        }
        }
    
    public Alimento getAlimento(){
    
        return alimento;
        
    }
    
    public void setAlimento(Alimento alimento){
    
        this.alimento = alimento;
        
    }
    
}
