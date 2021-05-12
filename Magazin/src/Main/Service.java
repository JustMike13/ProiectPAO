package Main;

import Main.Utilities.CsvReader;
import Main.Utilities.CsvWriter;
import Persoane.Angajat;
import Persoane.Persoana;
import Produse.*;
import java.sql.SQLOutput;
import java.util.*;

public class Service {
    private static Set<Produs> Produse = new HashSet<Produs>();
    private static List<Persoana> Persoane = new ArrayList<Persoana>();
    private static List<Angajat> Angajati = new ArrayList<Angajat>();
    private static CsvWriter writer;
    public Service(){
        System.out.println("S-a creat service-ul!!!");
    }

    public void adaugaPersoana(Persoana P){
        Persoane.add(P);
        this.write("S-a adaugat " + P);

    }

    public void adaugaAngajat(Angajat P){
        Persoane.add(P);//un angajat este si persoana
        Angajati.add(P);
        this.write("S-a adaugat " + P);
    }

    public void adaugaProdus(Angajat a, Produs p){
        if (a.getFunctie() == "Manager"){
            Produse.add(p);
            this.write(p+" a fost adaugat");
        }
        else{
            System.out.println("Doar managerii pot adauga produse noi!!");
        }
    }

    public void adaugaProdus(Angajat a, Produs p, int q){
        if (a.getFunctie() == "Manager"){
            Produse.add(p);
            this.write("Produsul "+ p +" fost adaugat de catre "+ a +" si stocul actualizat la "+q);
            modificaStoc(a,p,q);
        }
        else{
            System.out.println("Doar managerii pot adauga produse noi!!");
        }
    }

    public void modificaStoc(Angajat a, Produs p, int q){
        a.AdaugaStoc(p, q);
        this.write("Stocul produsului "+p.getDenumire() +" a fost actualizat de catre "+ a +". Stoc curent: "+p.getStoc());
    }

    public void ListaProduse(){
        Iterator<Produs> it = Produse.iterator();
        int index = 1;
        while(it.hasNext()){
            System.out.println(index + ". " + it.next());
            index = index + 1;
        }
        this.write("Afisare lista produse");
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

    public void readAngajat(String filePath){
        List<Angajat> angajati = CsvReader.readAngajat(filePath);
        for (int i = 0; i < angajati.size(); i++) {
            adaugaAngajat(angajati.get(i));
        }
        this.write("Au fost adaugati "+ angajati.size() + " angajati din fisier");
    }
    public void readPersoana(String filePath){
        List<Persoana> persoane = CsvReader.readPersoana(filePath);
        for (int i = 0; i < persoane.size(); i++) {
            adaugaPersoana(persoane.get(i));
        }
        this.write("Au fost adaugate "+ persoane.size() + " persoane din fisier");
    }
    public void readBautura(Angajat a, String filePath){
        List<Bautura> bauturi = CsvReader.readBautura(filePath);
        for (int i = 0; i < bauturi.size(); i++) {
            adaugaProdus(a, bauturi.get(i));
        }
        this.write("Au fost adaugate "+ bauturi.size() + " produse din fisier");
    }
    public void readBauturaAlcoolica(Angajat a, String filePath){
        List<BauturaAlcoolica> bauturi = CsvReader.readBauturaAlcoolica(filePath);
        for (int i = 0; i < bauturi.size(); i++) {
            adaugaProdus(a, bauturi.get(i));
        }
        this.write("Au fost adaugate "+ bauturi.size() + " produse din fisier");
    }
    public void readDulciuri(Angajat a, String filePath){
        List<Dulciuri> dulciuri = CsvReader.readDulciuri(filePath);
        for (int i = 0; i < dulciuri.size(); i++) {
            adaugaProdus(a, dulciuri.get(i));
        }
        this.write("Au fost adaugate "+ dulciuri.size() + " produse din fisier");
    }
    public void readFructLeguma(Angajat a, String filePath){
        List<FructLeguma> produse = CsvReader.readFructLeguma(filePath);
        for (int i = 0; i < produse.size(); i++) {
            adaugaProdus(a, produse.get(i));
        }
        this.write("Au fost adaugate "+ produse.size() + " produse din fisier");
    }
    public void readMezeluri(Angajat a, String filePath){
        List<Mezeluri> produse = CsvReader.readMezeluri(filePath);
        for (int i = 0; i < produse.size(); i++) {
            adaugaProdus(a, produse.get(i));
        }
        this.write("Au fost adaugate "+ produse.size() + " produse din fisier");
    }
    public void start(String filePath){
        writer = new CsvWriter();
        this.writer.setFilePath(filePath);
    }

    public void write(String str){
        this.writer.add(str);
    }

    public void end(){
        this.writer.write();
    }

}
