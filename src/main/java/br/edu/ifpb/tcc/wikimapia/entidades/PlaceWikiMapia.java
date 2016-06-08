/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.wikimapia.entidades;

import java.util.List;

/**
 *
 * @author Magdiel
 */
class PlaceWikiMapia {
    private Integer id;
    private String title;
    private List<CoordenadaWikiMapia> polygon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CoordenadaWikiMapia> getPolygon() {
        return polygon;
    }

    public void setPolygon(List<CoordenadaWikiMapia> polygon) {
        this.polygon = polygon;
    }

    @Override
    public String toString() {
        return "PlaceWikiMapia{" + "id=" + id + ", title=" + title + ", polygon=" + polygon + '}';
    }
}
