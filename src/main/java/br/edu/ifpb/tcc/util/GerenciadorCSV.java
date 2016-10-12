/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.tcc.util;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Desenvolvedor01
 */
public class GerenciadorCSV {
    
    /**
     * 
     * @param file arquivo do tipo CSV
     * @param caracTabulacao char de tabulação, para ser usado no processo de criação do leitor de CSV
     * @return List de Arrays de String, contendo assim para cada item da lista uma linha do arquivo, sendo os índices do Array as colunas separadas da linha. 
     * A primeira linha seria o cabeçalho do arquivo.
     */
    public static List<List<String>> lerArquivo(File file, char caracTabulacao){
        List<List<String>> retorno = new ArrayList<>();
        
        List<String[]> linhas = new ArrayList();
        try {
            CSVReader reader = new CSVReader(new FileReader(file),caracTabulacao);
            linhas = reader.readAll();
            
            List<String> l = null;
            
            for (int i = 0; i < linhas.size(); i++) {
                l = new ArrayList<>();
                for (int j = 0; j < linhas.get(i).length; j++) {
                    l.add(linhas.get(i)[j]);
                }
                retorno.add(l);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public static List<String[]> lerArquivo(File file){
        
        List<String[]> linhas = new ArrayList();
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            linhas = reader.readAll();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linhas;
    }
    
    public static List<String> getNomeDasColunas(String caminho, char caracTabulacao){
        File file = new File(caminho);
        List<List<String>> linhas = lerArquivo(file, caracTabulacao);
        return linhas.get(0);
    }
    
    public static List<List<String>> getValoresDoArquivo(File file, char caracTabulacao){
        
        List<List<String>> linhas = lerArquivo(file,caracTabulacao);
        linhas.remove(0);
        
        return linhas;
    }
    
    public static boolean verificarSeColunaExiste(String caminho, String coluna, char caracTabulacao){
        List<String> colunas = getNomeDasColunas(caminho, caracTabulacao);
        boolean result = false;
        
        return colunas.contains(coluna);
    }
    
    public static int qtdeLinhas(File file, char caracTabulacao){
        int result = 0;
        try {
            CSVReader reader = new CSVReader(new FileReader(file), caracTabulacao);
            result = reader.readAll().size() - 1;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static boolean validarLinha(String linha){
        if(linha.equals("") || linha.equals(" ")){
            return false;
        }else if(linha.charAt(0) == '-' && linha.charAt(1) == '-'){
            return false;
        }else if(linha.contains("=") || linha.contains(":")){
            return false;
        }
        return true;
    }
}
