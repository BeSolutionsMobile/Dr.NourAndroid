package com.besolutions.drnour.Scenarios.ScenarioAllServices.Model;

public class AllServicesModel {

    String txtservice;
    int poster;

    public AllServicesModel(String txtservice, int poster) {
        this.txtservice = txtservice;
        this.poster = poster;
    }

    public String getTxtservice() {
        return txtservice;
    }

    public void setTxtservice(String txtservice) {
        this.txtservice = txtservice;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
