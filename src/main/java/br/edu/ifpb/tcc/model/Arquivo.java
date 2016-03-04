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
    private String nomeDoArquivo;
    private String extensao;
    private String caractereDeTabulacao;
    private String pathArquivo;
    private String colunaDeBusca;
    private String latitude;
    private String longitude;
    private String referenciaDeLugar;
    private boolean georreferenciado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }

    public void setNomeDoArquivo(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public String getCaractereDeTabulacao() {
        return caractereDeTabulacao;
    }

    public void setCaractereDeTabulacao(String caractereDeTabulacao) {
        this.caractereDeTabulacao = caractereDeTabulacao;
    }

    public String getPathArquivo() {
        return pathArquivo;
    }

    public void setPathArquivo(String pathArquivo) {
        this.pathArquivo = pathArquivo;
    }

    public String getColunaDeBusca() {
        return colunaDeBusca;
    }

    public void setColunaDeBusca(String colunaDeBusca) {
        this.colunaDeBusca = colunaDeBusca;
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
        return referenciaDeLugar;
    }

    public void setReferenciaDeLugar(String referenciaDeLugar) {
        this.referenciaDeLugar = referenciaDeLugar;
    }

    public boolean isGeorreferenciado() {
        return georreferenciado;
    }

    public void setGeorreferenciado(boolean georreferenciado) {
        this.georreferenciado = georreferenciado;
    }

    @Override
    public String toString() {
        return "Arquivo{" + "id=" + id + ", nomeDoArquivo=" + nomeDoArquivo + ", extensao=" + extensao + ", caractereDeTabulacao=" + caractereDeTabulacao + ", pathArquivo=" + pathArquivo + ", colunaDeBusca=" + colunaDeBusca + ", latitude=" + latitude + ", longitude=" + longitude + ", referenciaDeLugar=" + referenciaDeLugar + ", georreferenciado=" + georreferenciado + '}';
    }
}
