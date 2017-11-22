/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.ConectaServidor;

import br.com.foundtruck.Converter.FromJson;
import br.com.foundtruck.Converter.ToJson;
import br.com.foundtruck.models.Usuario;

/**
 *
 * @author giusevero
 */
public class UsuarioResource {

    ToJson toJson;
    FromJson fromJson;
    ConexaoServer server;
    String json;

    private final String resource = "usuario";

    public UsuarioResource() {
        toJson = new ToJson();
        fromJson = new FromJson();
        server = new ConexaoServer();
    }

    public void login(Usuario usuario) {

        json = toJson.usuarioToJson(usuario);

        server.postMethod(resource + "/login", json);
    }

    public void cadastrar(Usuario usuario) {

        json = toJson.usuarioToJson(usuario);
        
        server.postMethod(resource, json);
    }
}
