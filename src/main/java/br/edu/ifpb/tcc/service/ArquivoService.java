/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.service;

import br.edu.ifpb.tcc.model.Arquivo;
import br.edu.ifpb.tcc.persistencia.ArquivoDao;
import java.util.List;

/**
 *
 * @author Magdiel
 */
public class ArquivoService {
    
    public boolean cadastrarArquivo(Arquivo arquivo){
        return ArquivoDao.getInstance().savarArquivo(arquivo);
    }
    
    public List<Arquivo> buscaTodosArquivos(){
        return ArquivoDao.getInstance().getArquivos();
    }
}
