package Main.Utilities;

import Persoane.Angajat;
import Persoane.Persoana;
import Produse.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReader {
    public static List<Angajat> readAngajat (String filePath) {
        try(Scanner sc = new Scanner(new File(filePath))){
            List<Angajat> list = new ArrayList<Angajat>();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String [] dataLine = line.split(",");
                if(!(dataLine[0].equals("nume") && dataLine[1].equals("prenume") && dataLine[2].equals("functie") && dataLine[3].equals("salariu"))){

                    Angajat angajat = new Angajat(dataLine[0], dataLine[1], dataLine[2], Integer.parseInt(dataLine[3]));

                    list.add(angajat);
                }
            }
            return list;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Persoana> readPersoana (String filePath) {
        try(Scanner sc = new Scanner(new File(filePath))){
            List<Persoana> list = new ArrayList<Persoana>();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String [] dataLine = line.split(",");
                if(!(dataLine[0].equals("nume") && dataLine[1].equals("prenume"))){

                    Persoana persoana = new Persoana(dataLine[0], dataLine[1]);

                    list.add(persoana);
                }
            }
            return list;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Bautura> readBautura (String filePath) {
        try(Scanner sc = new Scanner(new File(filePath))){
            List<Bautura> list = new ArrayList<Bautura>();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String [] dataLine = line.split(",");
                if(!(dataLine[0].equals("denumire") && dataLine[1].equals("pret") && dataLine[1].equals("zahar") && dataLine[1].equals("unitate"))){

                    Bautura bautura = new Bautura(dataLine[0], Integer.parseInt(dataLine[1]), Integer.parseInt(dataLine[2]), dataLine[3]);

                    list.add(bautura);
                }
            }
            return list;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static List<BauturaAlcoolica> readBauturaAlcoolica(String filePath) {
        try(Scanner sc = new Scanner(new File(filePath))){
            List<BauturaAlcoolica> list = new ArrayList<BauturaAlcoolica>();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String [] dataLine = line.split(",");
                if(!(dataLine[0].equals("denumire") && dataLine[1].equals("pret") && dataLine[1].equals("zahar") && dataLine[1].equals("unitate") && dataLine[1].equals("alcool"))){

                    BauturaAlcoolica bautura = new BauturaAlcoolica(dataLine[0], Integer.parseInt(dataLine[1]), Integer.parseInt(dataLine[2]), dataLine[3], Integer.parseInt(dataLine[4]));

                    list.add(bautura);
                }
            }
            return list;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Dulciuri> readDulciuri(String filePath) {
        try(Scanner sc = new Scanner(new File(filePath))){
            List<Dulciuri> list = new ArrayList<Dulciuri>();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String [] dataLine = line.split(",");
                if(!(dataLine[0].equals("denumire") && dataLine[1].equals("pret") && dataLine[1].equals("cantitate") && dataLine[1].equals("continutZahar") && dataLine[1].equals("unitate"))){

                    Dulciuri dulciuri = new Dulciuri(dataLine[0], Integer.parseInt(dataLine[1]), dataLine[2], Integer.parseInt(dataLine[3]), dataLine[4]);

                    list.add(dulciuri);
                }
            }
            return list;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static List<FructLeguma> readFructLeguma(String filePath) {
        try(Scanner sc = new Scanner(new File(filePath))){
            List<FructLeguma> list = new ArrayList<FructLeguma>();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String [] dataLine = line.split(",");
                if(!(dataLine[0].equals("denumire") && dataLine[1].equals("pret") && dataLine[1].equals("cantitate") && dataLine[1].equals("origine") && dataLine[1].equals("tip") && dataLine[1].equals("unitate"))){

                    FructLeguma frlg = new FructLeguma(dataLine[0], Integer.parseInt(dataLine[1]), dataLine[2], dataLine[3], dataLine[4], dataLine[5]);

                    list.add(frlg);
                }
            }
            return list;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Mezeluri> readMezeluri(String filePath) {
        try(Scanner sc = new Scanner(new File(filePath))){
            List<Mezeluri> list = new ArrayList<Mezeluri>();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String [] dataLine = line.split(",");
                if(!(dataLine[0].equals("denumire") && dataLine[1].equals("pret") && dataLine[1].equals("valabilitate"))){

                    Mezeluri prod = new Mezeluri(dataLine[0], Integer.parseInt(dataLine[1]), Integer.parseInt(dataLine[2]));

                    list.add(prod);
                }
            }
            return list;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Produs> readProdus(String filePath) {
        try(Scanner sc = new Scanner(new File(filePath))){
            List<Produs> list = new ArrayList<Produs>();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String [] dataLine = line.split(",");
                if(!(dataLine[0].equals("denumire") && dataLine[1].equals("pret") && dataLine[1].equals("cantitate") && dataLine[1].equals("unitate"))){

                    Produs prod = new Produs(dataLine[0], Integer.parseInt(dataLine[1]), dataLine[2], dataLine[3]);

                    list.add(prod);
                }
            }
            return list;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
