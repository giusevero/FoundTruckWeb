/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Utils;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author giusevero
 */
public class SessionUtils {

    private static SessionUtils instance;

    public static SessionUtils getIntance() {
        if (instance == null) {
            instance = new SessionUtils();
        }

        return instance;
    }

    private SessionUtils() {
    }

    private ExternalContext currentExternalContext() {
        if (FacesContext.getCurrentInstance() == null) {
            throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
        } else {
            return FacesContext.getCurrentInstance().getExternalContext();
        }
    }

    public void encerrarSessao() {
        currentExternalContext().invalidateSession();
    }

    public Object getAttribute(String nome) {
        return currentExternalContext().getSessionMap().get(nome);
    }

    public void setAttribute(String nome, Object object) {
        currentExternalContext().getSessionMap().put(nome, object);
    }
}
