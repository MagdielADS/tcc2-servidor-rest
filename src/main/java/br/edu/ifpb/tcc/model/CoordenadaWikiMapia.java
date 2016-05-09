/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.model;

import java.math.BigDecimal;

/**
 *
 * @author Magdiel
 */
class CoordenadaWikiMapia {
    private BigDecimal x;
    private BigDecimal y;

    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "PolygonWikiMapia{" + "x=" + x + ", y=" + y + '}';
    }
}
