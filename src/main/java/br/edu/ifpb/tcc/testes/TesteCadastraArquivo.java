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
public class TesteCadastraArquivo {
    public static void main(String[] args) {
        ArquivoService service = new ArquivoService();
        Arquivo arquivo = new Arquivo();
        
        arquivo.setNomeDoArquivo("teste2");
        arquivo.setCaractereDeTabulacao(",");
        arquivo.setColunaDeBusca("coluna de busca");
        arquivo.setExtensao("CSV");
        arquivo.setGeorreferenciado(true);
        arquivo.setLatitude("latitude");
        arquivo.setLongitude("longitude");
        arquivo.setPathArquivo("path");
        arquivo.setReferenciaDeLugar("referencia");
        
        service.cadastrarArquivo(arquivo);
    }
}
