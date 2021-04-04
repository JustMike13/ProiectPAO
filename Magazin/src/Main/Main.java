package Main;

import Persoane.Angajat;
import Produse.BauturaAlcoolica;
import Produse.Dulciuri;
import Produse.Mezeluri;

public class Main {
    public static void main(String[] args) {
        Service myService = new Service();

        Angajat a1 = new Angajat("Ristea","Mihai","Manager", 20000);
        Angajat a2 = new Angajat("Popescu","George","Lucrator comencial",1000);
        Angajat a3 = new Angajat("Popa","Marian","Lucrator comercial", 1000);

        myService.adaugaAngajat(a1);
        myService.adaugaAngajat(a2);
        myService.adaugaAngajat(a3);

        Mezeluri Salam = new Mezeluri("Salam Victoria",5,3);
        BauturaAlcoolica Whisky1 = new BauturaAlcoolica("Jack Daniel's Tennessee Whiskey",100,5,"Sticla",40);
        Dulciuri Bomboane = new Dulciuri("Bomboane",20,"1 kg",60,"Kg");

        myService.adaugaProdus(a1, Salam);
        myService.adaugaProdus(a1, Whisky1);
        myService.adaugaProdus(a1, Bomboane,20);

        myService.modificaStoc(a2, Whisky1, 20);

        System.out.println(myService.getPersoane());
        myService.ListaProduse();

    }
}
