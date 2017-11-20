/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.ConectaServidor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giusevero
 */
public class ConexaoServer {
    
    private final String urlServer = "http://localhost:9090/FoundTruckREST/webapi/";
    URL url;
    
    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String PUT = "PUT";
    private static final String DELETE = "DELETE";
    
    private static final String content = "Content-Type";
    private static final String json = "application/json";
    
    public void getMethod(){
        
    }
    
    public void postMethod(String path, String objeto){
        String caminho = urlServer + path;
        String resposta; 
        try {
            url = new URL(caminho);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setDoOutput(true);
            connection.setRequestMethod(POST);
            connection.setRequestProperty(content, json);
            
            OutputStream os = connection.getOutputStream();
            os.write(objeto.getBytes());
            os.flush();
            
            Resposta(connection);
            
            connection.disconnect();
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConexaoServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConexaoServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            Logger.getLogger(ConexaoServer.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void putMethod(){
        
    }
    
    public void deleteMethod(){
        
    }
    
    private void Resposta(HttpURLConnection uRLConnection) throws IOException{
        String resposta = null;
        
        switch (uRLConnection.getResponseCode()) {
            case HttpURLConnection.HTTP_OK:
                resposta = "OK";
                break;
            case HttpURLConnection.HTTP_INTERNAL_ERROR:
                resposta = "INTERNAL_ERROR";
                break;
            case HttpURLConnection.HTTP_UNAUTHORIZED:
                resposta = "UNAUTHORIZED";
                break;
            default:
                break;
        }
    }
}
