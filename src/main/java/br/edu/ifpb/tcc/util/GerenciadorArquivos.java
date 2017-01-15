/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.util;

import br.edu.ifpb.tcc.resource.ArquivoResource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Magdiel
 */
public class GerenciadorArquivos {
    private static final String DIRETORIO_UPLOAD = "E:"+File.separator+"Magdiel Bruno"+File.separator+"Documents"+File.separator+"arquivos-tcc"+File.separator;
    
    public static String copiarArquivo(String path, String extensao){
        boolean retorno = true;
        String pathArquivo = "";
        
        FileReader fis = null;
        try {
            File arquivoOrigem = new File(path);
            fis = new FileReader(arquivoOrigem);
            BufferedReader bufferedReader = new BufferedReader(fis);
            StringBuilder buffer = new StringBuilder();
            String line = "";
            int count = 0;
            
            while ((line = bufferedReader.readLine()) != null) {
                count++;
                if(validarLinha(line) && count > 3){
                    buffer.append(line).append("\n");
                }
            }   
            
            fis.close();
            bufferedReader.close();
            
            pathArquivo = DIRETORIO_UPLOAD + UUID.randomUUID().toString() + "." + extensao;
            
            File arquivoDestino = new File(pathArquivo);
            FileWriter writer = new FileWriter(arquivoDestino);
            writer.write(buffer.toString());
            writer.flush();
            writer.close();
            
            fis.close();
        } catch (IOException ex) {
            Logger.getLogger(ArquivoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pathArquivo;
    }
    
    private static boolean validarLinha(String linha){
        if(linha.equals("") || linha.equals(" ")){
            return false;
        }else if(linha.charAt(0) == '-' && linha.charAt(1) == '-'){
            return false;
        }
        return true;
    }
}
