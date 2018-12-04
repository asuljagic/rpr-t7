package ba.unsa.etf.rpr.tutorijal7;

import java.io.Serializable;

public class Grad implements Serializable {
    private String nazivGrada = "";
    private int brStanovnika = 0;
    private double[] temperature;


    public Grad(){
        temperature = new double[1000];
    }



    public Grad(String naziv, Double[] temperature) {
        this.nazivGrada = naziv;
        this.temperature = new double[1000];
        for (int i = 0; i < temperature.length; i++) {
            this.temperature[i] = temperature[i];
        }
        brStanovnika = 0;
    }

    public String getNaziv() {
        return nazivGrada;
    }

    public void setNaziv(String naziv) {
        this.nazivGrada = naziv;
    }

    public int getBrStanovnika() {
        return brStanovnika;
    }

    public void setBrStanovnika(int brStanovnika) {
        this.brStanovnika = brStanovnika;
    }

    public double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }
}
