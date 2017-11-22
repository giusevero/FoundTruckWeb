/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Beans;

import br.com.foundtruck.ConectaServidor.UsuarioResource;
import br.com.foundtruck.models.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author giuse
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    private Usuario usuario;
    private UsuarioResource resource;
    private FacesContext context;
    private ExternalContext ec;
    
    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuario = new Usuario();
        resource = new UsuarioResource();
        
    }

    public void Login(){
        
        try {
            
            context = FacesContext.getCurrentInstance();
            ec = context.getExternalContext();
            
            resource.login(usuario);
            
            ec.redirect("registro.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
            
            FacesContext.getCurrentInstance().validationFailed();
            
        }
        
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
