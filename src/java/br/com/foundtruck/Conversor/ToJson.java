/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Converter;

import java.util.List;

import com.google.gson.Gson;

import br.com.foundtruck.models.Alimento;
import br.com.foundtruck.models.Cardapio;
import br.com.foundtruck.models.Comentario;
import br.com.foundtruck.models.Foodtruck;
import br.com.foundtruck.models.Usuario;

/**
 *
 * @author giuse
 */
public class ToJson {

    Gson gson = null;

    public String alimentoToJson(Alimento objeto) {
        gson = new Gson();

        String alimento = gson.toJson(objeto);

        return alimento;
    }
    
    public String usuarioToJson(Usuario objeto){
        gson = new Gson();
        
        String usuario = gson.toJson(objeto);
        
        return usuario;
    }
    
    public String listaAlimentoToJson(List<Alimento> lista) {
        gson = new Gson();

        String alimento = gson.toJson(lista);

        return alimento;
    }

    public String listaCardapioToJson(List<Cardapio> lista) {
        gson = new Gson();

        String cardapio = gson.toJson(lista);

        return cardapio;
    }

    public String listaComentarioToJson(List<Comentario> lista) {
        gson = new Gson();

        String comentario = gson.toJson(lista);

        return comentario;
    }

    public String listaFoodtruckToJson(List<Foodtruck> lista) {
        gson = new Gson();

        String foodtruck = gson.toJson(lista);

        return foodtruck;
    }

    public String listaUsuarioToJson(List<Usuario> lista) {
        gson = new Gson();

        String usuario = gson.toJson(lista);

        return usuario;
    }
}