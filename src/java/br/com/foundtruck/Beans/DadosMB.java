/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Beans;

import br.com.foundtruck.models.Usuario;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author giusevero
 */
@Named(value = "dadosMB")
@ViewScoped
public class DadosMB implements Serializable{

    Usuario usuario;
    
    /**
     * Creates a new instance of DadosMB
     */
    public DadosMB() {
        
        usuario = new Usuario();
    }
    
    public void carregaDados(){
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
