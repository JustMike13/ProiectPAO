package Main;

import Persoane.Angajat;
import Produse.Produs;

public class MainPrezentare {
    public static void main(String[] args) {
        // Initializare service
        Service myService = new Service();
        String writeFilePath = "D:\\FMI 2 sem 2\\PAO\\Proiect\\Magazin\\MyFiles\\Report.csv";
        myService.start(writeFilePath);
        System.out.println("Date initiale:");
        System.out.println(myService.getPersoane());
        System.out.println(myService.getAngajati());
        System.out.println(myService.getProduse());

        // Adaug angajati in Db
        Angajat a1 = new Angajat("Radu","Ion","Lucrator comercial",1800);
        Angajat a2 = new Angajat("Popescu","Viorel","Lucrator comercial",1800);
        myService.addAngajatDatabase(a1);
        myService.addAngajatDatabase(a2);
        System.out.println("Adaugare angajati:");
        System.out.println(myService.getAngajati());

        // Modific angajat
        for (Angajat a : myService.getAngajati()){
            if ( a.getNume().equals("Radu")  && a.getPrenume().equals("Ion")){
                a.setFunctie("Sef raion");
                a.setSalariu(2500);
                myService.UpdateAngajatDatabase(a);
            }
        }
        System.out.println("Modific angajatul Radu Ion:");
        System.out.println(myService.getAngajati());

        // Adaug produs
        Produs p = new Produs("Apa Zizin",3,"2 litri","sticla");
        myService.addProdusDatabase(p);
        System.out.println("\nAdaugare produs:");
        System.out.println(myService.getProduse());

        // Stergere produs
        for (Produs j : myService.getProduse()){
            if( j.getDenumire().equals("Apa Zizin") ){
                myService.DeleteProdusDatabase(j);
            }
        }
        System.out.println("\nStergere Produs");
        System.out.println(myService.getProduse());






        myService.end();
    }
}
