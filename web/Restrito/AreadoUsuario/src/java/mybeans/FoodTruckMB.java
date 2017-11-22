/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

import foundtruck.ConectaServidor.FoodtruckResource;
import br.com.foundtruck.models.Foodtruck;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Thomas
 */

@ManagedBean
@ViewScoped
public class FoodTruckMB implements Serializable{

    Foodtruck foodtruck;
    FoodtruckResource resource;
    private FacesContext context;
    private ExternalContext ec;
    /**
     * Creates a new instance of FoodTruckMB
     */
    public FoodTruckMB() {
        
        foodtruck = new Foodtruck();
        resource = new FoodtruckResource();
        context = FacesContext.getCurrentInstance();
        ec = context.getExternalContext();
        
    }
    
    public Foodtruck getFoodtruck(){
    
    return foodtruck;
        
    }
    
    public void setFoodtruck(Foodtruck foodtruck){
    
    this.foodtruck = foodtruck;
    
    }
    
}
