/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.testes;

import br.edu.ifpb.tcc.model.Arquivo;
import br.edu.ifpb.tcc.service.ArquivoService;
import br.edu.ifpb.tcc.util.GerenciadorCSV;
import java.io.File;
import java.util.List;

/**
 *
 * @author Magdiel
 */
public class TesteCadastraArquivo {
    public static void main(String[] args) {
        
        //THREAD DE GEORREFERENCIAMENTO
        
        //SALVAR ARQUIVO
        ArquivoService service = new ArquivoService();
        Arquivo arquivoPerfeito = new Arquivo();
        Arquivo arquivo = new Arquivo();
        
        arquivoPerfeito.setNomeDoArquivo("ubs");
        arquivoPerfeito.setCaractereDeTabulacao(",");
        arquivoPerfeito.setColunaDeBusca("nom_estab");
        arquivoPerfeito.setExtensao("CSV");
        arquivoPerfeito.setGeorreferenciado(true);
        arquivoPerfeito.setLatitude("vlr_latitude");
        arquivoPerfeito.setLongitude("vlr_longitude");
        arquivoPerfeito.setPathArquivo("C:"+File.separator+"Users"+File.separator
                +"Magdiel"+File.separator+"Desktop"+File.separator
                +"Magdiel"+File.separator+"tcc"+File.separator+"ubs-menor.csv");
        arquivoPerfeito.setReferenciaDeLugar("dsc_cidade");
        
        arquivo.setNomeDoArquivo("ubs");
        arquivo.setCaractereDeTabulacao(",");
        arquivo.setColunaDeBusca("nom_estab");
        arquivo.setExtensao("CSV");
        arquivo.setGeorreferenciado(true);
        arquivo.setPathArquivo("C:"+File.separator+"Users"+File.separator
                +"Magdiel"+File.separator+"Desktop"+File.separator
                +"Magdiel"+File.separator+"tcc"+File.separator+"ubs.csv");
        
//        service.cadastrarArquivo(arquivoPerfeito);
        
//        LER ARQUIVO E RECUPERAR AS COLUNAS
        File arq = new File(arquivoPerfeito.getPathArquivo());
        System.out.println("path "+arquivoPerfeito.getPathArquivo());
        List<String> cols = GerenciadorCSV.getNomeDasColunas(arquivoPerfeito.getPathArquivo(), arquivoPerfeito.getCaractereDeTabulacao().charAt(0));
        
        arquivoPerfeito.setIndexDeBusca(cols.indexOf(arquivoPerfeito.getColunaDeBusca()));
        for (String col : cols) {
            System.out.println(col);
        }
        
        //CRIAR A TABELA COM AS COLUNAS DO ARQUIVOS
        //nomeDaTabela = nomeDoArquivo
        //colunas = colunas do arquivo todas como varchar e the_geom (geometry)
//        Tabela tabela = new Tabela();
//        tabela.setName(arquivoPerfeito.getNomeDoArquivo());
//        tabela.setColumns(cols);
        
        //Criar sql de criação da tabela
        //Executar sql
//        TabelaDao.getInstance().createTable(tabela);

        //BUSCAR LATITUDE E LONGITUDE
        //Verificar se latitude e longitude do arquivo são nulos
        //  Se for nulo
        //    Verificar se a referenciaDeLugar é nulo
        //      Se for nulo
        //        Ler arquivo em busca de referências de lugar (salvar o index das colunas com referência)
        //        Buscar referência mais interna (salva index)
        //        Recuperar latitude e longitude da referencia
        //      Se não for nulo
        //        Buscar geometria da referência no gazzetter 
        //        (se não encontrar, assumir que ela é nula e voltar ao passo anterior)
        //        Recuperar latitude e longitude
        //  Se não for nulo
        //    Continuar...
        
        
//        if(arquivoPerfeito.getLatitude() == null || arquivoPerfeito.getLongitude() == null){
//            if(arquivoPerfeito.getReferenciaDeLugar() == null){
                //Recupera os valores do arquivo;
//                List<List<String>> linhas = GerenciadorCSV.getValoresDoArquivo(arq, arquivoPerfeito.getCaractereDeTabulacao().charAt(0));
//                
//                //Navegar no arquivo
//                
//                int index = -1;
//                List<Local> locais = null;
//                List<Local> lAux = null;
//                
//                for(List<String> linha : linhas){
//                    locais = new ArrayList<>();
//                    System.out.println("======================================LINHA=="+linhas.indexOf(linha)+"=============================================");
//                    
//                    if(index != -1){
//                        if(linha.get(index)!= null && linha.get(index) != ""){
//                            locais = GazetteerDAO.recuperaLocais(linha.get(index), index);
//                        }else{
//                            for (String valor : linha) {
//                                System.out.println("Tentativa: " + valor + " - " + linha.indexOf(valor));
//                                lAux = new ArrayList<>();
//                                lAux = GazetteerDAO.recuperaLocais(valor, linha.indexOf(valor));
//                                locais.addAll(lAux);
//                            }
//                        }
//                    }else{
//                        for (String valor : linha) {
//                            System.out.println("==>TENTATIVA: "+valor+" - "+linha.indexOf(valor));
//                            lAux = new ArrayList<>();
//                            lAux = GazetteerDAO.recuperaLocais(valor, linha.indexOf(valor));
//                            locais.addAll(lAux);
//                        }
//                    }
//                    
//                    for(Local l : locais){
//                        System.out.println("Local: "+l);
//                    }
//                    Mapeamento map = GerenciaLocais.construirMapeamento(locais);
//                    System.out.println("Mapeamento: "+map.toString());
//                    
//                    Local localMais = GerenciaLocais.geometriaMaisInterna(map);
//                    
//                    if(localMais != null){
//                        index = localMais.getIndex();
//                        System.out.println("Local mais interno: "+"Local: " + localMais.getNome() + " - " + localMais.getTipo() + " - " + localMais.getIndex());
//                        
//                        Ponto ponto = GazetteerDAO.recuperaPonto(localMais);
//                        System.out.println("==========Ponto : "+ponto+"========================================");
//                        
//                        System.out.println("======BUSCA==>"+linha.get(arquivoPerfeito.getIndexDeBusca())+" - "+ponto.getLatitude()+" - "+ponto.getLongitude());
//                        
//                        String valor = linha.get(arquivoPerfeito.getIndexDeBusca());   
//                    }
//                }
//            }
//        }
        
        //WIKIMAPIA
        //Fazer consulta pela coluna de busca e latitude e longitude encontradas
        
        //INSERIR VALORES NO BANCO
        //Ler arquivo, recuperar os valores
        //Montar sql de inserção com os valores e a geometria btida do Wikimapia
        //Executar sql
    }
}
