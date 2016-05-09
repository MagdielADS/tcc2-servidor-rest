/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.service;

import br.edu.ifpb.tcc.model.Tabela;
import br.edu.ifpb.tcc.persistencia.TabelaDao;

/**
 *
 * @author Magdiel
 */
public class TabelaService {
    public void contruirTabela(Tabela tabela){
        TabelaDao.getInstance().createTable(tabela);
    }
}
