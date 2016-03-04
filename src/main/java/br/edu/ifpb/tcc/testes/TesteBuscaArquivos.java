/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.testes;

import br.edu.ifpb.tcc.model.Arquivo;
import br.edu.ifpb.tcc.service.ArquivoService;

/**
 *
 * @author Magdiel
 */
public class TesteBuscaArquivos {
    public static void main(String[] args) {
        ArquivoService service = new ArquivoService();
        for (Arquivo arq : service.buscaTodosArquivos()) {
            System.out.println(arq.toString());
        }
    }
}
