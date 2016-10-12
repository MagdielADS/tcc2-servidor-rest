/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.wikimapia;

/**
 *
 * @author Magdiel
 */
public enum LinguagemRespostaWikimapia {
    INGLES("en"), PORTUGUES("pt");
    
    public String value;
    LinguagemRespostaWikimapia(String valor) {
        value = valor;
    }
}
