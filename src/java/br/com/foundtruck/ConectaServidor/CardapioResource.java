/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.ConectaServidor;

import br.com.foundtruck.CompositeModels.Possui;
import br.com.foundtruck.Converter.FromJson;
import br.com.foundtruck.Converter.ToJson;
import br.com.foundtruck.Utils.SessionUtils;
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
    SessionUtils utils;

    private final String resource = "cardapio";

    public CardapioResource() {

        toJson = new ToJson();
        fromJson = new FromJson();
        server = new ConexaoServer();

    }

    public void cadastrarC(Cardapio cardapio) {
        String responseServer;
        String path = "/possui";
        Cardapio cardapio1 = new Cardapio();
        Possui possui = new Possui();
        server = new ConexaoServer();

        json = toJson.cardapioToJson(cardapio);
        //server.postMethod(resource, json);
        responseServer = server.postMethodResponse(resource, json);
        cardapio1 = fromJson.cardapioFromJson(responseServer);

        possui.setId_cardapio(cardapio1.getId());
        possui.setId_foodtruck((int) utils.getAttribute("id_foodtruck"));
        String possuiJson = toJson.possuiToJson(possui);

        server.postMethod(resource + path, possuiJson);

    }

    public void atualizaC(Cardapio cardapio) {

        server = new ConexaoServer();

        json = toJson.cardapioToJson(cardapio);
        server.putMethod(resource, json);
    }

    public Cardapio dados() {

        server = new ConexaoServer();
        String cardapioJson;
        Cardapio cardapio = new Cardapio();

        cardapioJson = server.getMethod(resource + "/" + resource, json, (String) utils.getAttribute(json));

        cardapio = fromJson.cardapioFromJson(cardapioJson);
        utils.setAttribute("id_cardapio", cardapio.getId());

        return cardapio;

    }
}
