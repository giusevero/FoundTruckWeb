/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Beans;

import br.com.foundtruck.ConectaServidor.UsuarioResource;
import br.com.foundtruck.models.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author giuse
 */
@Named(value = "registroMB")
@ViewScoped
public class RegistroMB implements Serializable{

    Usuario usuario;
    UsuarioResource resource;
    private FacesContext context;
    private ExternalContext ec;
    /**
     * Creates a new instance of RegistroMB
     */
    public RegistroMB() {
        
        usuario = new Usuario();
        resource = new UsuarioResource();
        context = FacesContext.getCurrentInstance();
        ec = context.getExternalContext();
    }
    
    public void Registrar(){
        
        try {
            resource.cadastrar(usuario);
            
            context = FacesContext.getCurrentInstance();
            ec = context.getExternalContext();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registro feito com sucesso!"));
            
            ec.redirect("login.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro no registro! Tente de novo"));
        }
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
