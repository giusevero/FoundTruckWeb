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
    
    ToJson toJson = new ToJson();
    FromJson fromJson = new FromJson();
    ConexaoServer server = new ConexaoServer();
    String json;
    
    private final String resource = "usuario";
    
    public void login(Usuario usuario){
        
        json = toJson.usuarioToJson(usuario);
        
        server.postMethod(resource+"/login", json);
    }
}
