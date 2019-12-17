package com.besolutions.drnour.Scenarios.ScenarioViewAllReservations.Model;

public class View_All_Model {

    private String textoperate;
    private String textprice;
    private String textdate;

    public View_All_Model(String textoperate, String textprice, String textdate) {
        this.textoperate = textoperate;
        this.textprice = textprice;
        this.textdate = textdate;
    }

    public String getTextoperate() {
        return textoperate;
    }

    public void setTextoperate(String textoperate) {
        this.textoperate = textoperate;
    }

    public String getTextprice() {
        return textprice;
    }

    public void setTextprice(String textprice) {
        this.textprice = textprice;
    }

    public String getTextdate() {
        return textdate;
    }

    public void setTextdate(String textdate) {
        this.textdate = textdate;
    }
}
