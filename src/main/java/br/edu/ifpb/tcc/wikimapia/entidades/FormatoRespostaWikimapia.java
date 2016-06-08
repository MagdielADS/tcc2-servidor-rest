/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.wikimapia.entidades;

/**
 *
 * @author Magdiel
 */
public enum FormatoRespostaWikimapia {
    
    JSONResposta("json"),XMLResposta("xml");
    
    public String value;
    FormatoRespostaWikimapia(String valor){
        value = valor;
    }
}
