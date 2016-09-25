/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.resource;

import br.edu.ifpb.tcc.model.Arquivo;
import br.edu.ifpb.tcc.service.ArquivoService;
import br.edu.ifpb.tcc.util.GerenciadorCSV;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author Magdiel
 */
@Path("/georef")
public class ArquivoResource {
    private final String DIRETORIO_UPLOAD = "C:"+File.separator+"Users"+File.separator
            +"Magdiel"+File.separator+"Documents"+File.separator+"arquivos-tcc"+File.separator;
    
    @GET
    @Path("/arquivos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArquivos() {
        System.out.println("Requisição");
        List<Arquivo> arquivos = new ArrayList<>();
        ArquivoService service = new ArquivoService();
        arquivos = service.buscaTodosArquivos();
        
        return Response.ok().entity(arquivos).build();
    }
    
    @POST
    @Path("/salvararquivo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Arquivo arquivo){
        System.out.println("Requisição feita");
        ArquivoService service = new ArquivoService();
        return service.cadastrarArquivo(arquivo) ? Response.ok().entity(new String("Salvo com sucesso!")).build() 
                : Response.serverError().entity(new String("Salvo com sucesso!")).build();
    }
    
    @GET
    @Path("/colunas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getColunasArquivo(@QueryParam("caminho") String caminho, @QueryParam("caractere") String caractere) {
        List<String> colunas = new ArrayList<>();
        
        String c = File.separator;
        String[] r = caminho.split("10");
        String caminhoFormatado = "";
        for (String s : r) {
            caminhoFormatado += s+File.separator;
        }
        caminhoFormatado = caminhoFormatado.substring(0, caminhoFormatado.length()-1);
        
        colunas = GerenciadorCSV.getNomeDasColunas(caminhoFormatado, caractere.charAt(0));
        return Response.ok().entity(colunas).build();
    }
    
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response upload(File uploadedInputStream) {
        String pathArquivo = "";
        
        FileReader fis = null;
        try {
            File arquivoOrigem = new File(uploadedInputStream.toString());
            fis = new FileReader(arquivoOrigem);
            BufferedReader bufferedReader = new BufferedReader(fis);
            StringBuilder buffer = new StringBuilder();
            String line = "";
            
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line).append("\n");
            }   fis.close();
            
            bufferedReader.close();
            
            pathArquivo = DIRETORIO_UPLOAD + Math.random()+".csv";
            
            File arquivoDestino = new File(pathArquivo);
            FileWriter writer = new FileWriter(arquivoDestino);
            writer.write(buffer.toString());
            writer.flush();
            writer.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoResource.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ArquivoResource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return Response.ok().entity(pathArquivo).build();
    }   
}
