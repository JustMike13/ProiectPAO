package Main;

import Persoane.Angajat;
import Persoane.Persoana;
import Produse.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Initializare service
        Service myService = new Service();
        String writeFilePath = "D:\\FMI 2 sem 2\\PAO\\Proiect\\Magazin\\MyFiles\\Report.csv";
        myService.start(writeFilePath);
//
//        String filePath1 = "D:\\FMI 2 sem 2\\PAO\\Proiect\\Magazin\\MyFiles\\Persoane.csv";
//        String filePath2 = "D:\\FMI 2 sem 2\\PAO\\Proiect\\Magazin\\MyFiles\\Angajati.csv";
//
//        Angajat a1 = new Angajat("Ristea","Mihai","Manager", 20000);
//        Angajat a2 = new Angajat("Popescu","George","Lucrator comencial",1000);
//        Angajat a3 = new Angajat("Popa","Marian","Lucrator comercial", 1000);
//
//        myService.adaugaAngajat(a1);
//        myService.adaugaAngajat(a2);
//        myService.adaugaAngajat(a3);
//
//        Mezeluri Salam = new Mezeluri("Salam Victoria",5,3);
//        BauturaAlcoolica Whisky1 = new BauturaAlcoolica("Jack Daniel's Tennessee Whiskey",100,5,"Sticla",40);
//        Dulciuri Bomboane = new Dulciuri("Bomboane",20,"1 kg",60,"Kg");
//
//        myService.adaugaProdus(a1, Salam);
//        myService.adaugaProdus(a1, Whisky1);
//        myService.adaugaProdus(a1, Bomboane,20);
//
//        myService.modificaStoc(a2, Whisky1, 20);
//
//        System.out.println(myService.getPersoane());
//        myService.ListaProduse();
//
//        myService.readPersoana(filePath1);
//        myService.readAngajat(filePath2);
//
//        System.out.println(myService.getPersoane());
//        System.out.println(myService.getAngajati());

        /**
         * Add to database
         */
//        Persoana p = new Persoana("Ion","Ion");
//        myService.addPersoanaDatabase(p);
//        System.out.println(myService.getPersoane());

        /**
         * Update database
         */
//        List<Persoana> persoane = myService.getPersoane();
//        for (Persoana i:persoane
//             ) {
//            if (i.getPersoanaId() == 4) {
//                i.setNume("Popa");
//                myService.UpdatePersoanaDatabase(i);
//            }
//        }
//        System.out.println(myService.getPersoane());
//        myService.end();

        /**
         * Delete
         */
//        List<Persoana> persoane = myService.getPersoane();
//        for (Persoana i:persoane
//             ) {
//            if (i.getPersoanaId() == 4) {
//                myService.DeletePersoanaDatabase(i);
//            }
//        }
//        System.out.println(myService.getPersoane());

//        Produs p = new Produs("produs2", 20, "500g","Buc");
//        myService.addProdusDatabase(p);


//        Set<Produs> list = myService.getProduse();
//        for (Produs i:list
//             ) {
//            if (i.getProductId() == 2) {
//                i.setStoc(200);
//                myService.UpdateProdusDatabase(i);
//            }
//        }

//        Set<Produs> list = myService.getProduse();
//        for (Produs i:list
//             ) {
//            if (i.getProductId() == 2) {
//                myService.DeleteProdusDatabase(i);
//            }
//        }
//        System.out.println(myService.getProduse());

//        Angajat a = new Angajat("aaa", "bbb", "Manager", 1000);
//        myService.addAngajatDatabase(a);

//        for (Angajat i : myService.getAngajati()){
//            if (i.getPersoanaId() == 2){
//                i.setNume("Dinu");
//                i.setPrenume("Irina");
//                myService.UpdateAngajatDatabase(i);
//            }
//        }
//        for (Angajat i : myService.getAngajati()){
//            if (i.getPersoanaId() == 2){
//                myService.DeleteAngajatDatabase(i);
//            }
//        }
//        System.out.println(myService.getAngajati());

//        Bautura b = new Bautura("Jack2",100,15);
//        myService.addBauturaDatabase(b);
//        System.out.println(myService.getProduse());
//
//
//        for(Produs i : myService.getProduse()){
//            if (i instanceof Bautura && i.getProductId() == 5){
//                i.setStoc(100);
//                myService.UpdateBauturaDatabase((Bautura) i);
//            }
//        }
//        System.out.println(myService.getProduse());
//        for(Produs i : myService.getProduse()){
//            if (i instanceof Bautura && i.getProductId() == 5){
//                myService.DeleteBauturaDatabase((Bautura) i);
//            }
//        }
//        System.out.println(myService.getProduse());

        System.out.println(myService.getPersoane());
        Angajat a = new Angajat("aaa", "bbb", "Manager", 1000);
        myService.addAngajatDatabase(a);
        System.out.println(myService.getPersoane());

        myService.end();
    }
}
