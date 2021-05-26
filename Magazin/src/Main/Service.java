package Main;

import Main.Etapa2.CsvReader;
import Main.Etapa2.CsvWriter;
import Main.Etapa3.DbConnection;
import Persoane.Angajat;
import Persoane.Persoana;
import Produse.*;

import java.sql.*;
import java.time.Instant;
import java.util.*;

import static Main.Etapa3.Queries.*;

public class Service {
    private static Set<Produs> Produse = new HashSet<Produs>();
    private static List<Persoana> Persoane = new ArrayList<Persoana>();
    private static List<Angajat> Angajati = new ArrayList<Angajat>();
    private static CsvWriter writer;
    public Service(){
        System.out.println("S-a creat service-ul!!!");
    }
    private DbConnection dbConnection;

    public void adaugaPersoana(Persoana P){
        this.addPersoanaDatabase(P);
        this.write("S-a adaugat " + P);

    }

    public void adaugaAngajat(Angajat P){
        this.addAngajatDatabase(P);
        this.write("S-a adaugat " + P);
    }

    public void adaugaProdus(Angajat a, Produs p){
        if (a.getFunctie() == "Manager"){
            if(p instanceof Produs)
            {
                this.addProdusDatabase(p);
            }else if (p instanceof Bautura){
                this.addBauturaDatabase((Bautura) p);
            }else {
                Produse.add(p);
            }
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

    public static void setProduse(Set<Produs> produse) {
        Produse = produse;
    }

    public static void setPersoane(List<Persoana> persoane) {
        Persoane = persoane;
    }

    public static void setAngajati(List<Angajat> angajati) {
        Angajati = angajati;
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
        this.dbConnection = DbConnection.getInstance();
        this.updatePersoane();
        this.updateProduseList();
    }

    public void write(String str){
        this.writer.add(str);
        Timestamp ts = Timestamp.from(Instant.now());
        try {
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(REPORT);
            preparedStatement.setString(1,str);
            preparedStatement.setString(2,ts.toString());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void end(){
        this.writer.write();
    }

    // Persoana
    public List<Persoana> ReadPersoaneDatabase(){
        List<Persoana> res = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(GET_ALL_PERSONS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Persoana p = new Persoana(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                res.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a citit lista de persoane");
        return res;
    }
    public void addPersoanaDatabase(Persoana p){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(ADD_PERSOANA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, p.getNume());
            preparedStatement.setString(2, p.getPrenume());
            preparedStatement.setInt(3, p.getBuget());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            int genId = 0;
            while(resultSet.next()){
                genId = Integer.parseInt(resultSet.getString(1));
            }
            p.setPersoanaId(genId);
            this.updatePersoane();
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a adaugat o persoana");
    }
    public void UpdatePersoanaDatabase(Persoana p){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(UPDATE_PERSOANA);
            preparedStatement.setString(1, p.getNume());
            preparedStatement.setString(2, p.getPrenume());
            preparedStatement.setInt(3, p.getBuget());
            preparedStatement.setInt(4, p.getPersoanaId());
            preparedStatement.executeUpdate();
            this.updatePersoane();
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a modificat o persoana");
    }
    public void DeletePersoanaDatabase(Persoana p){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(DELETE_PERSOANA);
            preparedStatement.setInt(1, p.getPersoanaId());
            preparedStatement.executeUpdate();
            this.updatePersoane();
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a sters o persoana");
    }

    // Angajat
    public List<Angajat> ReadAngajatiDatabase(){
        List<Angajat> res = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(GET_ALL_ANGAJATI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Angajat p = new Angajat(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getInt(6));
                res.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a citit lista de angajati");
        return res;
    }
    public void addAngajatDatabase(Angajat a){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(ADD_ANGAJAT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, a.getNume());
            preparedStatement.setString(2, a.getPrenume());
            preparedStatement.setInt(3, a.getBuget());
            preparedStatement.setString(4, a.getFunctie());
            preparedStatement.setInt(5, a.getSalariu());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            int genId = 0;
            while(resultSet.next()){
                genId = Integer.parseInt(resultSet.getString(1));
            }
            a.setPersoanaId(genId);
            this.updatePersoane();
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a adaugat un angajat");
    }
    public void UpdateAngajatDatabase(Angajat a){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(UPDATE_ANGAJAT);
            preparedStatement.setString(1, a.getNume());
            preparedStatement.setString(2, a.getPrenume());
            preparedStatement.setInt(3, a.getBuget());
            preparedStatement.setString(4, a.getFunctie());
            preparedStatement.setInt(5, a.getSalariu());
            preparedStatement.setInt(6, a.getPersoanaId());
            preparedStatement.executeUpdate();
            this.updatePersoane();
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a modificat un angajat");
    }
    public void DeleteAngajatDatabase(Angajat a){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(DELETE_ANGAJAT);
            preparedStatement.setInt(1, a.getPersoanaId());
            preparedStatement.executeUpdate();
            this.updatePersoane();
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a sters un angajat");
    }

    // Produs
    public Set<Produs> ReadProduseDatabase(){
        Set<Produs> res = new HashSet<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(GET_ALL_PRODUCTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Produs p = new Produs(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getFloat(6));
                res.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a citit lista de Produse");
        return res;
    }
    public void addProdusDatabase(Produs p){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(ADD_PRODUCT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, p.getDenumire());
            preparedStatement.setInt(2, p.getPret());
            preparedStatement.setString(3, p.getCantitate());
            preparedStatement.setString(4, p.getUnitate());
            preparedStatement.setFloat(5, p.getStoc());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            int genId = 0;
            while(resultSet.next()){
                genId = Integer.parseInt(resultSet.getString(1));
            }
            p.setProductId(genId);
            this.updateProduseList();
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a adaugat un produs");
    }
    public void UpdateProdusDatabase(Produs p){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, p.getDenumire());
            preparedStatement.setInt(2, p.getPret());
            preparedStatement.setString(3, p.getCantitate());
            preparedStatement.setString(4, p.getUnitate());
            preparedStatement.setFloat(5, p.getStoc());
            preparedStatement.setInt(6, p.getProductId());
            preparedStatement.executeUpdate();
            this.updateProduseList();
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a modificat un produs");
    }
    public void DeleteProdusDatabase(Produs p){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, p.getProductId());
            preparedStatement.executeUpdate();
            this.updateProduseList();
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a sters un produs");
    }

    //Bautura
    public Set<Bautura> ReadBauturaDatabase(){
        Set<Bautura> res = new HashSet<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(GET_ALL_BAUTURI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Bautura p = new Bautura(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getFloat(6), resultSet.getInt(7));
                res.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a citit lista de bauturi");
        return res;
    }
    public void addBauturaDatabase(Bautura p){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(ADD_BAUTURA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, p.getDenumire());
            preparedStatement.setInt(2, p.getPret());
            preparedStatement.setString(3, p.getCantitate());
            preparedStatement.setString(4, p.getUnitate());
            preparedStatement.setFloat(5, p.getStoc());
            preparedStatement.setInt(6, p.getContinutZahar());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            int genId = 0;
            while(resultSet.next()){
                genId = Integer.parseInt(resultSet.getString(1));
            }
            p.setProductId(genId);
            this.updateProduseList();
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a adaugat o bautura");
    }
    public void UpdateBauturaDatabase(Bautura p){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(UPDATE_BAUTURA);
            preparedStatement.setString(1, p.getDenumire());
            preparedStatement.setInt(2, p.getPret());
            preparedStatement.setString(3, p.getCantitate());
            preparedStatement.setString(4, p.getUnitate());
            preparedStatement.setFloat(5, p.getStoc());
            preparedStatement.setInt(6, p.getContinutZahar());
            preparedStatement.setInt(7, p.getProductId());
            preparedStatement.executeUpdate();
            this.updateProduseList();
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a modificat o bautura");
    }
    public void DeleteBauturaDatabase(Bautura p){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDbConnection().prepareStatement(DELETE_BAUTURA);
            preparedStatement.setInt(1, p.getProductId());
            preparedStatement.executeUpdate();
            this.updateProduseList();
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.write("S-a sters o bautura");
    }

    public void updateProduseList(){
        Set<Produs> list1 = this.ReadProduseDatabase();
        Set<Bautura> list2 = this.ReadBauturaDatabase();
        for (Bautura i : list2){
            list1.add(i);
        }
        this.setProduse(list1);
    }
    public void updatePersoane(){
        List<Persoana> list1 = this.ReadPersoaneDatabase();
        List<Angajat> list2 = this.ReadAngajatiDatabase();
        for (Angajat i : list2){
            list1.add(i);
        }
        this.setPersoane(list1);
        this.setAngajati(list2);
    }














































}
