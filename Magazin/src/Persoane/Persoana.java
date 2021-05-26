package Persoane;

import Produse.Produs;

public class Persoana {
    private int persoanaId = 0;
    private String nume;
    private String prenume;
    private int buget;

    public Persoana(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
        this.buget = 0;
    }
    public Persoana(int id, String nume, String prenume, int buget) {
        this.persoanaId = id;
        this.nume = nume;
        this.prenume = prenume;
        this.buget = buget;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getBuget() {
        return buget;
    }

    public void setBuget(int buget) {
        this.buget = buget;
    }

    @Override
    public String toString() {
        return persoanaId + ". Persoana{" +nume + ' ' + prenume +'}';
    }
    public String getNumeComplet(){
        return nume+" "+prenume;
    }

    public void Cumpara(Produs p, int Quantity){
        int pret = p.Cumpara(Quantity);
        this.ActualizeazaBuget(-pret);
    }

    public int getPersoanaId() {
        return persoanaId;
    }

    public void setPersoanaId(int persoanaId) {
        this.persoanaId = persoanaId;
    }

    public void ActualizeazaBuget(int b) {
        this.buget = this.buget + b;
    }

}
