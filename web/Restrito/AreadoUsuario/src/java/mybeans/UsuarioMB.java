/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

import br.com.foundtruck.ConectaServidor.UsuarioResource;
import br.com.foundtruck.models.Usuario;
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
public class UsuarioMB implements Serializable{

    Usuario usuario;
    UsuarioResource resource;
    private FacesContext context;
    private ExternalContext ec;

    /**
     * Creates a new instance of UsuarioMB
     */
    public UsuarioMB() {
        
        usuario = new Usuario();
        resource = new UsuarioResource();
        context = FacesContext.getCurrentInstance();
        ec = context.getExternalContext();
        
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    
    
}
