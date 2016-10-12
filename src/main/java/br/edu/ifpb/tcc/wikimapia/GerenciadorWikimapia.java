/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.wikimapia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author Magdiel
 */
public class GerenciadorWikimapia {

    public static String montarUrlDeRequisicaoWikimapia(String query, String latitude, String longitude,
            FormatoRespostaWikimapia formatoDeResposta, LinguagemRespostaWikimapia linguagemDeResposta) {
        StringBuilder url = new StringBuilder();
        url.append("http://api.wikimapia.org/?key=example&function=place.search&q=");
        url.append(query);
        url.append("&lat=");
        url.append(latitude);
        url.append("&lon=");
        url.append(longitude);
        url.append("&format=");
        url.append(formatoDeResposta.value);
        url.append("&pack=&language=");
        url.append(linguagemDeResposta.value);
        url.append("&page=1&count=50&category=&categories_or=&categories_and=&distance=");

        return url.toString();
    }

    public static ObjetoJSONWikimapia buscarPlacesPorQueryECoordenadas(String urlRequisicao) {
        String jsonString = "";
        ObjetoJSONWikimapia retorno = null;
        try {
            URL url = new URL(urlRequisicao);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                jsonString = inputLine;
            }
            in.close();

            Gson gson = new GsonBuilder().create();
            retorno = gson.fromJson(jsonString, ObjetoJSONWikimapia.class);
        } catch (IOException | JsonSyntaxException e) {
            e.getMessage();
        } 
        return retorno;
    }
}