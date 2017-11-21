/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Beans;

import br.com.foundtruck.ConectaServidor.UsuarioResource;
import br.com.foundtruck.Utils.SessionUtils;
import br.com.foundtruck.models.Usuario;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
    private SessionUtils utils;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuario = new Usuario();
        resource = new UsuarioResource();
        utils = SessionUtils.getIntance();
    }

    public void Login() {

        try {

            context = FacesContext.getCurrentInstance();
            ec = context.getExternalContext();

            resource.login(usuario);

            utils.setAttribute("usuario", usuario.getEmail());

            ec.redirect("");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void logout() {
        utils.encerrarSessao();

        try {
            context = FacesContext.getCurrentInstance();
            ec = context.getExternalContext();
            ec.redirect("index.html");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
