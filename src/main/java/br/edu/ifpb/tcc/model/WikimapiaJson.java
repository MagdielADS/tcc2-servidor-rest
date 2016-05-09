/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.model;

import java.util.List;

/**
 *
 * @author Magdiel
 */
public class WikimapiaJson {
    private List<PlaceWikiMapia> places;

    public List<PlaceWikiMapia> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceWikiMapia> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "WikimapiaJson{" + "places=" + places + '}';
    }
}
