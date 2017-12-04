/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Beans;

import java.io.Serializable;
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
public class IndexAdmin implements Serializable{

    private MapModel model = new DefaultMapModel();
    
    /**
     * Creates a new instance of IndexAdmin
     */
    public IndexAdmin() {
        
        
    }
    
}
