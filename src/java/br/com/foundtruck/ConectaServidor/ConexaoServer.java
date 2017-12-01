/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.ConectaServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    private static final String CONTENT = "Content-Type";
    private static final String JSON = "application/json";

    
    /**
     * Requisição HTTP para método GET
     * @param path Caminho da requisição
     * @param paramName Nome do parâmetro a ser enviado
     * @param paramValue Valor do parâmetro a ser devolvido
     * @return String json a ser convertido
     */
    public String getMethod(String path, String paramName, String paramValue) {
        String resposta = null;

        String caminho = urlServer + path;

        if (!paramName.equals("") || paramName != null) {
            caminho = caminho + "?" + paramName + "=" + paramValue;
        }

        try {
            url = new URL(caminho);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(GET);
            connection.setRequestProperty("Accept", JSON);

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            
            resposta = sb.toString();

            connection.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConexaoServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConexaoServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resposta;
    }

    /**
     * Requisição HTTP para método POST para inserir objetos
     * @param path Caminho da requisição
     * @param objeto Objeto a ser inserido
     */
    public void postMethod(String path, String objeto) {
        String caminho = urlServer + path;
        String resposta;
        try {
            url = new URL(caminho);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setRequestMethod(POST);
            connection.setRequestProperty(CONTENT, JSON);

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

    /**
     * Requisição HTTP para método PUT para atualizar objetos
     * @param path Caminho da requisição
     * @param objeto Objeto a ser atualizado
     */
    public void putMethod(String path, String objeto) {
        String caminho = urlServer + path;
        String resposta;
        try {
            url = new URL(caminho);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setRequestMethod(PUT);
            connection.setRequestProperty(CONTENT, JSON);

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

    public void deleteMethod(String path, String objeto) {
            
    }

    private void Resposta(HttpURLConnection uRLConnection) throws IOException {
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
