/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.persistencia;

import br.edu.ifpb.tcc.model.Arquivo;
import br.edu.ifpb.tcc.persistencia.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Magdiel
 */
public class ArquivoDao {
    private static ArquivoDao instance;
    
    public static ArquivoDao getInstance(){
        if(instance==null) instance = new ArquivoDao();
        return instance;        
    }
    
    public boolean savarArquivo(Arquivo arquivo) {
        String sql = "INSERT INTO ARQUIVO(nome_do_arquivo, extensao, "
                + "caractere_de_tabulacao, path_arquivo, coluna_de_busca, "
                + "latitude, longitude, referencia_de_lugar, georreferenciado) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = Conexao.getInstance().createConnection();

            PreparedStatement stmt = connection.prepareStatement(sql);
            try {
                stmt.setString(1, arquivo.getNomeDoArquivo());
                stmt.setString(2, arquivo.getExtensao());
                stmt.setString(3, arquivo.getCaractereDeTabulacao());
                stmt.setString(4, arquivo.getPathArquivo());
                stmt.setString(5, arquivo.getColunaDeBusca());
                stmt.setString(6, arquivo.getLatitude());
                stmt.setString(7, arquivo.getLongitude());
                stmt.setString(8, arquivo.getReferenciaDeLugar());
                stmt.setBoolean(9, arquivo.isGeorreferenciado());
                stmt.executeUpdate();
                return true;
            } finally {
                stmt.close();
                connection.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Arquivo> getArquivos() {
        String sql = "SELECT id, nome_do_arquivo, extensao, caractere_de_tabulacao, path_arquivo, coluna_de_busca, "
                + "latitude, longitude, referencia_de_lugar, georreferenciado FROM arquivo";
        List<Arquivo> arquivos = new ArrayList<>();
        try {
            Connection connection = Conexao.getInstance().createConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            try {
                ResultSet rs = stmt.executeQuery();
                Arquivo arquivo = new Arquivo();
                while (rs.next()) {
                    arquivo.setId(rs.getLong("id"));
                    arquivo.setNomeDoArquivo(rs.getString("nome_do_arquivo"));
                    arquivo.setExtensao(rs.getString("extensao"));
                    arquivo.setCaractereDeTabulacao(rs.getString("caractere_de_tabulacao"));
                    arquivo.setPathArquivo(rs.getString("path_arquivo"));
                    arquivo.setColunaDeBusca(rs.getString("coluna_de_busca"));
                    arquivo.setLatitude(rs.getString("latitude"));
                    arquivo.setLongitude(rs.getString("longitude"));
                    arquivo.setReferenciaDeLugar(rs.getString("referencia_de_lugar"));
                    arquivo.setGeorreferenciado(rs.getBoolean("georreferenciado"));
                    
                    
                    arquivos.add(arquivo);
                    arquivo = new Arquivo();
                }
                return arquivos;
            } finally {
                stmt.close();
                connection.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
