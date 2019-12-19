package com.besolutions.drnour.Scenarios.ScenarioGallery.Model;

public class Gallery_Model {

    String textAlbum;
    int imggallery;

    public Gallery_Model(String textAlbum, int imggallery) {
        this.textAlbum = textAlbum;
        this.imggallery = imggallery;
    }

    public String getTextAlbum() {
        return textAlbum;
    }

    public void setTextAlbum(String textAlbum) {
        this.textAlbum = textAlbum;
    }

    public int getImggallery() {
        return imggallery;
    }

    public void setImggallery(int imggallery) {
        this.imggallery = imggallery;
    }
}
