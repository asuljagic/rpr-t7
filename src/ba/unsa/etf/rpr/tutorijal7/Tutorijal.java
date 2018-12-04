package ba.unsa.etf.rpr.tutorijal7;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {

    public static ArrayList<Grad> ucitajGradove()throws FileNotFoundException {
        ArrayList<Grad> gradovi = new ArrayList<Grad>();
        Scanner ulaz;
        try {
            ulaz = new Scanner(new FileReader("mjerenja.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka mjerenja.txt ne postoji ili se ne može otvoriti");
            throw e;
        }
        ulaz.useDelimiter("\n");
        while (ulaz.hasNext()) {
            String podaci = ulaz.next();
            String[] nizPodataka = podaci.split(",");
            String grad = nizPodataka[0];
            Double[] temperature = new Double[nizPodataka.length-1];
            for (int i = 1; i < nizPodataka.length; i++) {
                temperature[i - 1] = Double.parseDouble(nizPodataka[i]);
            }
            gradovi.add(new Grad(grad, temperature));
        }
        ulaz.close();
        return gradovi;
    }

    public static UN ucitajXml(ArrayList<Grad> gradovi){
        UN un = null;
        try{
            XMLDecoder ulaz = new XMLDecoder(new FileInputStream("drzave.xml"));
            un = (UN) ulaz.readObject();
            ulaz.close();
        }catch(Exception e){
            System.out.println(e);
        }
        for(Drzava d : un.getDrzave()){
            for (int i = 0; i < gradovi.size(); i++) {
                if(gradovi.get(i).getNaziv().equals(d.getGlavniGrad().getNaziv()))
                    d.getGlavniGrad().setTemperature(gradovi.get(i).getTemperature());
            }
        }

        return un;
    }

    public static void zapisiXml(UN un){
        try{
            XMLEncoder izlaz = new XMLEncoder(new FileOutputStream("un.xml"));
            izlaz.writeObject(un);
            izlaz.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ArrayList<Grad> rez=new ArrayList<Grad>();

        try {
            rez = ucitajGradove();
            for (var grad : rez) {
                System.out.println(grad);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Grad g1=rez.get(0);
        Grad g2=rez.get(1);
        Drzava drzava=new Drzava();
        drzava.setGlavniGrad(g1);
        drzava.setNaziv("BiH");
        drzava.setBrStanovnika(400000);
        drzava.setJedinicaZaPovrsinu("km");
        drzava.setPovrsina(122132.0);

        Drzava drzava1=new Drzava();
        drzava1.setGlavniGrad(g2);
        drzava1.setNaziv("Srbija");
        drzava1.setBrStanovnika(455);
        drzava1.setJedinicaZaPovrsinu("km");
        drzava1.setPovrsina(2343.0);


        UN drzavaD=new UN();
        drzavaD.dodajDrzavu(drzava);
        drzavaD.dodajDrzavu(drzava1);

        zapisiXml(drzavaD);
    }
}
