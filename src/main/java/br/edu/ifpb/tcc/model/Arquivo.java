/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.model;

/**
 *
 * @author Magdiel
 */
public class Arquivo {
    private Long id;
    private String nomeArquivo;
    private String extensao;
    private String caractereTabulacao;
    private String pathArquivo;
    private String colunaBusca;
    private String latitude;
    private String longitude;
    private String referenciaLugar;
    private boolean georreferenciado;
    private int indexDeBusca;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getNomeDoArquivo() {
        return nomeArquivo;
    }

    public void setNomeDoArquivo(String nomeDoArquivo) {
        this.nomeArquivo = nomeDoArquivo;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public String getCaractereDeTabulacao() {
        return caractereTabulacao;
    }

    public void setCaractereDeTabulacao(String caractereDeTabulacao) {
        this.caractereTabulacao = caractereDeTabulacao;
    }

    public String getPathArquivo() {
        return pathArquivo;
    }

    public void setPathArquivo(String pathArquivo) {
        this.pathArquivo = pathArquivo;
    }

    public String getColunaDeBusca() {
        return colunaBusca;
    }

    public void setColunaDeBusca(String colunaDeBusca) {
        this.colunaBusca = colunaDeBusca;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getReferenciaDeLugar() {
        return referenciaLugar;
    }

    public void setReferenciaDeLugar(String referenciaDeLugar) {
        this.referenciaLugar = referenciaDeLugar;
    }

    public boolean isGeorreferenciado() {
        return georreferenciado;
    }

    public void setGeorreferenciado(boolean georreferenciado) {
        this.georreferenciado = georreferenciado;
    }

    public int getIndexDeBusca() {
        return indexDeBusca;
    }

    public void setIndexDeBusca(int indexDeBusca) {
        this.indexDeBusca = indexDeBusca;
    }

    
    
    @Override
    public String toString() {
        return "Arquivo{" + "id=" + id + ", nomeDoArquivo=" + nomeArquivo + ", extensao=" + extensao + ", caractereDeTabulacao=" + caractereTabulacao + ", pathArquivo=" + pathArquivo + ", colunaDeBusca=" + colunaBusca + ", latitude=" + latitude + ", longitude=" + longitude + ", referenciaDeLugar=" + referenciaLugar + ", georreferenciado=" + georreferenciado + '}';
    }
}
