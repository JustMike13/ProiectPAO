package Persoane;

import Produse.Produs;

public class Persoana {
    private String nume;
    private String prenume;
    private int buget;

    public Persoana(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
        this.buget = 0;
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
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", buget=" + buget +
                '}';
    }
    public String getNumeComplet(){
        return nume+" "+prenume;
    }

    public void Cumpara(Produs p, int Quantity){
        int pret = p.Cumpara(Quantity);
        this.ActualizeazaBuget(-pret);
    }

    public void ActualizeazaBuget(int b) {
        this.buget = this.buget + b;
    }
}
