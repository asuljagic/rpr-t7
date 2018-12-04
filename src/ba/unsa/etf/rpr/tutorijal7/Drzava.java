package ba.unsa.etf.rpr.tutorijal7;

import java.io.Serializable;

public class Drzava implements Serializable {
    private String naziv = "";
    private int brStanovnika;
    private double povrsina;
    private String jedinicaZaPovrsinu = "";
    private Grad glavniGrad;

    public Drzava() {
        glavniGrad = new Grad();
    }

    public Drzava(String naziv, int brStanovnika, double povrsina, String jedinicaZaPovrsinu, Grad glavniGrad) {
        this.naziv = naziv;
        this.brStanovnika = brStanovnika;
        this.povrsina = povrsina;
        this.jedinicaZaPovrsinu = jedinicaZaPovrsinu;
        this.glavniGrad = glavniGrad;

    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrStanovnika() {
        return brStanovnika;
    }

    public void setBrStanovnika(int brStanovnika) {
        this.brStanovnika = brStanovnika;
    }

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina = povrsina;
    }

    public String getJedinicaZaPovrsinu() {
        return jedinicaZaPovrsinu;
    }

    public void setJedinicaZaPovrsinu(String jedinicaZaPovrsinu) {
        this.jedinicaZaPovrsinu = jedinicaZaPovrsinu;
    }

    public Grad getGlavniGrad() {
        return glavniGrad;
    }

    public void setGlavniGrad(Grad glavniGrad) {
        this.glavniGrad = glavniGrad;
    }
}
