/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.testes;

import br.edu.ifpb.tcc.wikimapia.entidades.ObjetoJSONWikimapia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author Magdiel
 */
public class TesteJson {
    public static void main(String[] args) {
        String jsonString = null;

        try {
            String query = "Eiffel";
            String latitude = "48.858252";
            String longitude = "2.29451";
            StringBuilder urlTeste = new StringBuilder();
            urlTeste.append("http://api.wikimapia.org/?key=example&function=place.search&");
            urlTeste.append("q=Eiffel&lat=48.858252&lon=2.29451&format=json&pack=&language=pt");
            urlTeste.append("&page=1&count=50&category=&categories_or=&categories_and=&distance=");
            URL url = new URL("http://api.wikimapia.org/?key=example&function=place.search&q=Eiffel&lat=48.858252&lon=2.29451&format=json&pack=&language=pt&page=1&count=50&category=&categories_or=&categories_and=&distance=");
            
            System.out.println("URL: "+url.getPath()+" "+url.getHost());
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("LINHA "+inputLine);
                jsonString = inputLine;
            }
            in.close();
            //Create gson
            Gson gson = new GsonBuilder().create();
            ObjetoJSONWikimapia r = gson.fromJson(jsonString, ObjetoJSONWikimapia.class);
            
            if(r != null){
                System.out.println("JSON: "+r.toString());
            }
            
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
