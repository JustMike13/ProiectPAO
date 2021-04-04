package Main;

import Persoane.Angajat;
import Persoane.Persoana;
import Produse.Produs;

import java.sql.SQLOutput;
import java.util.*;

public class Service {
    private static Set<Produs> Produse = new HashSet<Produs>();
    private static List<Persoana> Persoane = new ArrayList<Persoana>();
    private static List<Angajat> Angajati = new ArrayList<Angajat>();

    public Service(){
        System.out.println("S-a creat service-ul!!!");
    }

    public void adaugaPersoana(Persoana P){
        Persoane.add(P);
        System.out.println("S-a adaugat " + P);
    }

    public void adaugaAngajat(Angajat P){
        Persoane.add(P);//un angajat este si persoana
        Angajati.add(P);
        System.out.println("S-a adaugat " + P);
    }

    public void adaugaProdus(Angajat a, Produs p){
        if (a.getFunctie() == "Manager"){
            Produse.add(p);
            System.out.println(p+" a fost adaugat");
        }
        else{
            System.out.println("Doar managerii pot adauga produse noi!!");
        }
    }

    public void adaugaProdus(Angajat a, Produs p, int q){
        if (a.getFunctie() == "Manager"){
            Produse.add(p);
            System.out.println("Produsul a fost adaugat si stocul actualizat!!");
            modificaStoc(a,p,q);
        }
        else{
            System.out.println("Doar managerii pot adauga produse noi!!");
        }
    }

    public void modificaStoc(Angajat a, Produs p, int q){
        a.AdaugaStoc(p, q);
        System.out.println("Stocul produsului "+p.getDenumire() +" a fost actualizat. Stoc curent: "+p.getStoc());
    }

    public void ListaProduse(){
        Iterator<Produs> it = Produse.iterator();
        int index = 1;
        while(it.hasNext()){
            System.out.println(index + ". " + it.next());
            index = index + 1;
        }
    }

    public static Set<Produs> getProduse() {
        return Produse;
    }

    public static List<Persoana> getPersoane() {
        return Persoane;
    }

    public static List<Angajat> getAngajati() {
        return Angajati;
    }
}
