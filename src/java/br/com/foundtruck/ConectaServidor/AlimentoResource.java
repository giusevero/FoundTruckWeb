/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.ConectaServidor;

import br.com.foundtruck.CompositeModels.Vende;
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
            
        String responseServer;
        String path = "/vende";
        Alimento alimento1 = new Alimento();
        Vende vende = new Vende();
        server = new ConexaoServer();    
    
        json = toJson.alimentoToJson(alimento);
        //server.postMethod(resource, json);
        responseServer = server.postMethodResponse(resource, json);
        alimento1 = fromJson.alimentoFromJson(responseServer);
        
        vende.setId_alimento(alimento1.getId());
        vende.setId_foodtruck((int) utils.getAttribute("id_foodtruck"));
        String vendeJson = toJson.vendeToJson(vende);
        
        server.postMethod(resource+path, vendeJson);
        
    }
        
        public void atualizaA(Alimento alimento){
        
        server = new ConexaoServer();
        
        json = toJson.alimentoToJson(alimento);
        server.putMethod(resource, json);
        }
        
        public Alimento dados(){
        
        server = new ConexaoServer();
        String alimentoJson;
        Alimento alimento = new Alimento();
        
        alimentoJson = server.getMethod(resource + "/" + resource, json, json);
        
        alimento = fromJson.alimentoFromJson(alimentoJson);
        utils.setAttribute("id_alimento", alimento.getId());
        
        return alimento;
        
        }
    
}
