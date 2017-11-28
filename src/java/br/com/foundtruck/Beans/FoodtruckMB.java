/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Beans;

import br.com.foundtruck.ConectaServidor.FoodtruckResource;
import br.com.foundtruck.models.Foodtruck;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
    FoodtruckResource resource;
    private FacesContext context;
    private ExternalContext ec;

    /**
     * Creates a new instance of foodtruckMB
     */
    public FoodtruckMB() {
        foodtruck = new Foodtruck();
        resource = new FoodtruckResource();
        context = FacesContext.getCurrentInstance();
        ec = context.getExternalContext();
    }
    
    public void RegistrarF(){
    
        try{
            
            resource.cadastrarF(foodtruck);
            
            context = FacesContext.getCurrentInstance();
            ec = context.getExternalContext();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registro feito com sucesso!"));
            
            ec.redirect("FoodTruck.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro no registro! Tente de novo"));
        }
        
    }
    
    public Foodtruck getFoodtruck(){
    
        return foodtruck;
        
    }
    
    public void setFoodtruck(Foodtruck foodtruck){
    
        this.foodtruck = foodtruck;
        
    }
}
