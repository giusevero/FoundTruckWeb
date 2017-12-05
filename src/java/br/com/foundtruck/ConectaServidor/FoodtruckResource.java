/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.ConectaServidor;

import br.com.foundtruck.Converter.FromJson;
import br.com.foundtruck.Converter.ToJson;
import br.com.foundtruck.Utils.SessionUtils;
import br.com.foundtruck.models.Foodtruck;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giusevero
 */
public class FoodtruckResource {

    ToJson toJson;
    FromJson fromJson;
    ConexaoServer server;
    String json;
    SessionUtils utils;
    private final String resource = "foodtruck";

    public FoodtruckResource() {
        toJson = new ToJson();
        fromJson = new FromJson();

        utils = SessionUtils.getIntance();
    }

    /**
     * Cadastro do foodtruck
     * @param foodtruck Objeto foodtruck a ser cadastrado
     */
    public void cadastrar(Foodtruck foodtruck) {
        server = new ConexaoServer();

        foodtruck.setEmail_usuario((String) utils.getAttribute("usuario"));
        foodtruck.setAtivo("1");
        json = toJson.foodtruckToJson(foodtruck);

        server.postMethod(resource, json);
    }

    /**
     * Método para atualizar foodtruck no banco
     * @param foodtruck Objeto Foodtruck
     */
    public void atualiza(Foodtruck foodtruck){
        server = new ConexaoServer();
        
        json = toJson.foodtruckToJson(foodtruck);
        server.putMethod(resource, json);
    }
    
    /**
     * Método para carregar foodtruck associado a um usuário
     * @return Foodtruck do usuário
     */
    public Foodtruck dados() {
        server = new ConexaoServer();
        String foodtruckJson;
        Foodtruck foodtruck = new Foodtruck();
        
        foodtruckJson = server.getMethod(resource + "/" + resource, "email", (String) utils.getAttribute("usuario"));
        
        foodtruck = fromJson.foodtruckFromJson(foodtruckJson);
        
        utils.setAttribute("id_foodtruck", foodtruck.getId());
        return foodtruck;
    }
    
    public List<Foodtruck> foodtrucks(){
        server = new ConexaoServer();
        String foodtruckJson;
        List<Foodtruck> listaFoodtruck = new ArrayList<>();
        
        foodtruckJson = server.getMethod(resource+"/lista", "", "");
        
        listaFoodtruck = fromJson.listaFoodtruckFromJson(foodtruckJson);
        
        return listaFoodtruck;
    }
}
