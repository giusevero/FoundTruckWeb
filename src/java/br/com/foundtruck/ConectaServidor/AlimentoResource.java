/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.ConectaServidor;

import br.com.foundtruck.Converter.FromJson;
import br.com.foundtruck.Converter.ToJson;
import br.com.foundtruck.Utils.SessionUtils;
import br.com.foundtruck.models.Alimento;
/**
 *
 * @author Thomas
 */
public class AlimentoResource {
    
    ToJson toJson;
    FromJson fromJson;
    ConexaoServer server;
    String json;
    SessionUtils utils;    
    
    private final String resource = "alimento";
    
    public AlimentoResource(){

        toJson = new ToJson();
        fromJson = new FromJson();
        server = new ConexaoServer();

}
    
        public void cadastrarA(Alimento alimento){
            
        server = new ConexaoServer();    
    
        json = toJson.alimentoToJson(alimento);
        server.postMethod(resource, json);
        
    }
        
        public void atualizaA(Alimento alimento){
        
        server = new ConexaoServer();
        
        json = toJson.alimentoToJson(alimento);
        server.putMethod(resource, json);
        }
    
}
