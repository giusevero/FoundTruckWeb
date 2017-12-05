/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Beans;

import br.com.foundtruck.ConectaServidor.FoodtruckResource;
import br.com.foundtruck.models.Foodtruck;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author giuse
 */
@Named(value = "indexAdmin")
@ViewScoped
public class IndexAdmin implements Serializable {

    private MapModel model;
    private FoodtruckResource resource;
    private LatLng latLng;

    private List<Foodtruck> lista;
    private List<LatLng> coords;
    
    private Foodtruck foodtruck;

    /**
     * Creates a new instance of IndexAdmin
     */
    public IndexAdmin() {
        resource = new FoodtruckResource();
        
        
    }

    public void foodtruckProprio(){
        foodtruck = new Foodtruck();
        
        foodtruck = resource.dados();
    }
    
    public void foodtruckPosicao() {
        coords = new ArrayList<>();
        lista = new ArrayList<>();
        model = new DefaultMapModel();
        lista = resource.foodtrucks();

        for (int i = 0; i < lista.size(); i++) {
            latLng = new LatLng(lista.get(i).getLat(), lista.get(i).getLongi());
            coords.add(latLng);
        }

        StringBuilder imgPath = new StringBuilder();
        imgPath.append(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        imgPath.append("/img/marcador.png");
        for (int i = 0; i < coords.size(); i++) {
            
            model.addOverlay(new Marker(coords.get(i), lista.get(i).getNome(),null, imgPath.toString()));
        }
    }

    public MapModel getModel() {
        return model;
    }

    public void setModel(MapModel model) {
        this.model = model;
    }

    public Foodtruck getFoodtruck() {
        return foodtruck;
    }

    public void setFoodtruck(Foodtruck foodtruck) {
        this.foodtruck = foodtruck;
    }
    
    
}
