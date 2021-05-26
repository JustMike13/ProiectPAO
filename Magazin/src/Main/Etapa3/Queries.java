package Main.Etapa3;

public class Queries {
    /**
     * Persoana
     */
    public static final String GET_ALL_PERSONS = "select * from proiectpao.persoana;";
    public static final String ADD_PERSOANA = "insert into proiectpao.persoana(nume, prenume, buget)\n" +
            "values (?,?,?);";
    public static final String UPDATE_PERSOANA = "UPDATE proiectpao.persoana p\n" +
            "set nume = ?, prenume = ?, buget = ?\n" +
            "where p.PersoanaId = ?;";
    public static final String DELETE_PERSOANA = "delete from proiectpao.persoana p\n" +
            "where p.PersoanaId = ?;";
    /**
     * Angajat
     */
    public static final String GET_ALL_ANGAJATI = "select * from proiectpao.angajat;";
    public static final String ADD_ANGAJAT = "insert into proiectpao.angajat(nume, prenume, buget, functie, salariu)\n" +
            "values (?,?,?,?,?);";
    public static final String UPDATE_ANGAJAT = "UPDATE proiectpao.angajat a\n" +
            "set nume = ?, prenume = ?, buget = ?, functie = ?, salariu = ?\n" +
            "where a.AngajatId = ?;";
    public static final String DELETE_ANGAJAT = "delete from proiectpao.angajat a\n" +
            "where a.AngajatId = ?;";
    /**
     * Produs
     */
    public static final String GET_ALL_PRODUCTS = "select * from proiectpao.produs;";
    public static final String ADD_PRODUCT = "insert into proiectpao.produs(denumire, pret, cantitate, unitate, stoc)\n" +
            "values (?,?,?,?,?);";
    public static final String UPDATE_PRODUCT = "UPDATE proiectpao.produs p\n" +
            "set denumire = ?, pret = ?, cantitate = ?, unitate = ?, stoc = ?\n" +
            "where p.productId = ?;";
    public static final String DELETE_PRODUCT = "delete from proiectpao.produs p\n" +
            "where p.ProductId = ?;";
    /**
     * Bautura
     */
    public static final String GET_ALL_BAUTURI = "select * from proiectpao.bautura;";
    public static final String ADD_BAUTURA = "insert into proiectpao.bautura(denumire, pret, cantitate, unitate, stoc, continutzahar)\n" +
            "values (?,?,?,?,?,?);";
    public static final String UPDATE_BAUTURA = "UPDATE proiectpao.bautura b\n" +
            "set denumire = ?, pret = ?, cantitate = ?, unitate = ?, stoc = ?, continutzahar = ?\n" +
            "where b.bauturaId = ?;";
    public static final String DELETE_BAUTURA = "delete from proiectpao.bautura b\n" +
            "where b.bauturaId = ?;";
    /**
     * Report
     */
    public static final String REPORT = "insert into proiectpao.report(Action, Timestamp)\n" +
            "values(?,?)";
}
