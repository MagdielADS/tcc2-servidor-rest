/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.persistencia;


import br.edu.ifpb.tcc.model.Local;
import br.edu.ifpb.tcc.model.Ponto;
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
 * @author Magdiel Ildefonso
 */
public class GazetteerDao {

    private static Connection conn;
    static PreparedStatement pst;

    public static List<Local> recuperaLocais(String nome, int index) {
        List<Local> locais = new ArrayList<>();
        try {
            String sql = "select gid, ref_orig_gid, nome, tipo, ST_AsText(the_geom) "
                    + "as geo from gazetteer where unaccent(nome) ilike unaccent(?)";
            conn = Conexao.getInstance().createConnection();

            pst = conn.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Local local = new Local();
                local.setId(rs.getInt("gid"));
                local.setGid(rs.getInt("ref_orig_gid"));
                local.setNome(rs.getString("nome"));
                local.setTipo(rs.getString("tipo"));
                local.setGeometria(rs.getString("geo"));
                local.setIndex(index);
                locais.add(local);
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GazetteerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locais;
    }

    public static String recuperaCentroide(Local local) {
        String centroide = null;

        try {
            String sql = "select ST_AsText(ST_Centroid(the_geom)) as centroide from gazetteer where gid = ?";
            conn = Conexao.getInstance().createConnection();

            pst = conn.prepareStatement(sql);
            pst.setInt(1, local.getId());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                centroide = rs.getString("centroide");
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GazetteerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return centroide;
    }

    public static Ponto recuperaPonto(Local local) {
        Ponto p = new Ponto();
        try {
            String sql = "select ST_X(ST_Centroid(the_geom)) as long, ST_Y(ST_Centroid(the_geom)) as lat "
                    + "from gazetteer where ref_orig_gid = ?";
            conn = Conexao.getInstance().createConnection();

            pst = conn.prepareStatement(sql);
            pst.setInt(1, local.getGid());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p.setLatitude(String.valueOf(rs.getFloat("lat")));
                p.setLongitude(String.valueOf(rs.getFloat("long")));
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GazetteerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public static boolean contem(Local l1, Local l2) {
        System.out.println("Controle gid "+l1.getGid()+" - "+l2.getGid());
        boolean result = false;
        try {

            String sql = "select ST_Contains((select the_geom from gazetteer" 
                    + " where ref_orig_gid = " + l1.getGid() + "),(select the_geom "
                    + "from gazetteer where ref_orig_gid = " + l2.getGid() + ")) as contem";

            conn = Conexao.getInstance().createConnection();
            pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                result = rs.getBoolean("contem");
            }
            
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GazetteerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Result contem: "+result);
        return result;
    }

//   public boolean regiaoContemEstado(Local regiao, Local estado){
//       boolean result = false;
//       try {
//           String sql = "select * from estado where gid = ? and gid_regiao = ?";
//           conn = Conexao.getInstance().createConnection();
//           
//           pst = conn.prepareStatement(sql);
//           pst.setInt(1, estado.getGid());
//           pst.setInt(2, regiao.getGid());
//           ResultSet rs = pst.executeQuery();
//           if (rs.next()) {
//               result = true;
//           }
//       } catch (SQLException ex) {
//           Logger.getLogger(GazetteerDao.class.getName()).log(Level.SEVERE, null, ex);
//       }
//       return result;
//   }
//   
//   public boolean estadoContemMeso(Local estado, Local meso){
//       boolean result = false;
//       try {
//           String sql = "select * from mesorregiao where gid = ? and gid_estado = ?";
//           conn = Conexao.getInstance().createConnection();
//           
//           pst = conn.prepareStatement(sql);
//           pst.setInt(1, meso.getGid());
//           pst.setInt(2, estado.getGid());
//           ResultSet rs = pst.executeQuery();
//           if (rs.next()) {
//               result = true;
//           }
//       } catch (SQLException ex) {
//           Logger.getLogger(GazetteerDao.class.getName()).log(Level.SEVERE, null, ex);
//       }
//       return result;
//   }
//   
//   public boolean mesoContemMicro(Local meso, Local micro){
//       boolean result = false;
//       try {
//           String sql = "select * from microorregiao where gid = ? and gid_meso = ?";
//           conn = Conexao.getInstance().createConnection();
//           
//           pst = conn.prepareStatement(sql);
//           pst.setInt(1, micro.getGid());
//           pst.setInt(2, meso.getGid());
//           ResultSet rs = pst.executeQuery();
//           if (rs.next()) {
//               result = true;
//           }
//       } catch (SQLException ex) {
//           Logger.getLogger(GazetteerDao.class.getName()).log(Level.SEVERE, null, ex);
//       }
//       return result;
//   }
//   
//   public boolean microContemMunicipio(Local micro, Local municipio){
//       boolean result = false;
//       try {
//           String sql = "select * from municipio where gid = ? and gid_micro = ?";
//           conn = Conexao.getInstance().createConnection();
//           
//           pst = conn.prepareStatement(sql);
//           pst.setInt(1, municipio.getGid());
//           pst.setInt(2, micro.getGid());
//           ResultSet rs = pst.executeQuery();
//           if (rs.next()) {
//               result = true;
//           }
//       } catch (SQLException ex) {
//           Logger.getLogger(GazetteerDao.class.getName()).log(Level.SEVERE, null, ex);
//       }
//       return result;
//   }
}
