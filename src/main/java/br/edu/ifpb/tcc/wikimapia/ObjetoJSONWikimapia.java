/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.wikimapia;

import java.util.List;

/**
 *
 * @author Magdiel
 */
public class ObjetoJSONWikimapia {
    private List<PlaceWikimapia> places;

    public List<PlaceWikimapia> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceWikimapia> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "WikimapiaJson{" + "places=" + places + '}';
    }
}
