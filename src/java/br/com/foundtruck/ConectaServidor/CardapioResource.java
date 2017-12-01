/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.ConectaServidor;

import br.com.foundtruck.Converter.FromJson;
import br.com.foundtruck.Converter.ToJson;
import br.com.foundtruck.models.Cardapio;
/**
 *
 * @author Thomas
 */
public class CardapioResource {
    
    ToJson toJson;
    FromJson fromJson;
    ConexaoServer server;
    String json;
    
    private final String resource = "cardapio";
    
    public CardapioResource(){
    
        toJson = new ToJson();
        fromJson = new FromJson();
        server = new ConexaoServer();
    
    }
    
        public void cadastrarC(Cardapio cardapio) {

        
        
        server.postMethod(resource, json);
    }
    
}
