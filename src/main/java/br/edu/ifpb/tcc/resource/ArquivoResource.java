/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.resource;

import br.edu.ifpb.tcc.model.Arquivo;
import br.edu.ifpb.tcc.service.ArquivoService;
import br.edu.ifpb.tcc.util.GerenciadorCSV;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
}
