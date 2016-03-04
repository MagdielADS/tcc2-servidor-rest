/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.persistencia.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Magdiel
 */
public class Conexao {

    private static Conexao instancia;
//    private final File file = null;
//    private Properties prop = null;

//    private Conexao() {
//        try {
//            InputStream input = new FileInputStream("propriedades_conexao_bd.properties");
//            prop = new Properties();
//            prop.load(input);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public static Conexao getInstance() {
        if (instancia == null) {
            return instancia = new Conexao();
        }
        return instancia;
    }

    public Connection createConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/tcc", "postgres","123456");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
