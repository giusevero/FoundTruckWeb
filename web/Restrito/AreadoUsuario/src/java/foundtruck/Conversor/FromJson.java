/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Converter;

import br.com.foundtruck.models.Alimento;
import br.com.foundtruck.models.Cardapio;
import br.com.foundtruck.models.Comentario;
import br.com.foundtruck.models.Foodtruck;
import br.com.foundtruck.models.Usuario;

import com.google.gson.Gson;

/**
 *
 * @author giusevero
 */
public class FromJson {

    Gson gson = null;
    
    public Alimento alimentoFromJson(String objeto){
        gson = new Gson();
        Alimento alimento = gson.fromJson(objeto, Alimento.class);
        
        return alimento;
    }
    
    public Cardapio cardapioFromJson(String objeto) {
    	gson = new Gson();
    	
    	Cardapio cardapio = gson.fromJson(objeto, Cardapio.class);
    	
    	return cardapio;
    }
   
    public Comentario comentarioFromJson(String objeto) {
    	gson = new Gson();
    	
    	Comentario comentario = gson.fromJson(objeto, Comentario.class);
    	
    	return comentario;
    }
    
    public Foodtruck foodtruckFromJson(String objeto) {
    	gson = new Gson();
    	
    	Foodtruck foodtruck = gson.fromJson(objeto, Foodtruck.class);
    	
    	return foodtruck;
    }
    
    public Usuario usuarioFromJson(String json) {
    	gson = new Gson();
    	
    	Usuario usuario = gson.fromJson(json, Usuario.class);
    	
    	return usuario;
    }
}
