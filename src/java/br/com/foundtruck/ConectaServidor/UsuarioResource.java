/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.ConectaServidor;

import br.com.foundtruck.Converter.FromJson;
import br.com.foundtruck.Converter.ToJson;
import br.com.foundtruck.Utils.SessionUtils;
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
    SessionUtils utils;
    private final String resource = "usuario";

    public UsuarioResource() {
        toJson = new ToJson();
        fromJson = new FromJson();
        utils = SessionUtils.getIntance();
    }

    public boolean login(Usuario usuario) {
        server = new ConexaoServer();
        boolean resposta;
        
        try {
            json = toJson.usuarioToJson(usuario);

            server.postMethod(resource + "/login", json);
            
            return resposta = true;
        } catch (Exception e) {
            e.printStackTrace();
            
            return resposta = false;
        }
        
    }

    public void cadastrar(Usuario usuario) {
        server = new ConexaoServer();
        json = toJson.usuarioToJson(usuario);
        
        server.postMethod(resource, json);
    }
    
    public Usuario dados(String email){
        Usuario usuario = new Usuario();
        String usuarioJson;
        server = new ConexaoServer();
        
        usuarioJson = server.getMethod(resource+"/usuario", "email", email);
        usuario = fromJson.usuarioFromJson(usuarioJson);
        
        return usuario;
    }
    
    public void atualizar(Usuario usuario){
        server = new ConexaoServer();
        json = toJson.usuarioToJson(usuario);
        if(usuario.getSenha().equals("")||usuario.getSenha()==null)
            usuario.setSenha((String) utils.getAttribute("senha"));
        server.putMethod(resource, json);
        
    }
}
