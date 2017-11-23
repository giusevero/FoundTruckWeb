/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Beans;

import br.com.foundtruck.models.Foodtruck;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author giuse
 */
@Named(value = "foodtruckMB")
@ViewScoped
public class FoodtruckMB implements Serializable{

    Foodtruck foodtruck;
    
    /**
     * Creates a new instance of FoodtruckMB
     */
    public FoodtruckMB() {
        foodtruck = new Foodtruck();
    }

    public Foodtruck getFoodtruck() {
        return foodtruck;
    }

    public void setFoodtruck(Foodtruck foodtruck) {
        this.foodtruck = foodtruck;
    }
    
    
}
