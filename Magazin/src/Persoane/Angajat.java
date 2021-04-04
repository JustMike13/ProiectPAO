package Persoane;

import Produse.Produs;

public class Angajat extends Persoana{
    String functie;
    int salariu;

    public Angajat(String nume, String prenume, String functie, int salariu) {
        super(nume, prenume);
        this.functie = functie;
        this.salariu = salariu;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public void Promoveaza(Angajat a,String f){
        if(this.functie == "Manager"){
            a.setFunctie(f);
            System.out.println("Functia angajatului"+a.getNumeComplet() +"modificata cu succes!");
        }
        else
            System.out.println("Doar un manager poate modifica functia unui angajat!");
    }

    public void oferaBonus(Angajat a,int suma){
        if(this.functie == "Manager"){
            a.ActualizeazaBuget(suma);
            System.out.println("Bonusul de "+suma +" lei a fost oferit angajatului"+a.getNumeComplet());
        }
        else
            System.out.println("Doar un manager poate oferi bonusuri!");
    }

    @Override
    public String toString() {
        return "Angajat{" +this.getPrenume() + " " +
                this.getNume() +
                '}';
    }

    public void AdaugaStoc(Produs p, int q){
        p.adaugaStoc(q);
    }
}

