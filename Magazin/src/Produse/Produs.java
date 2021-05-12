package Produse;

public class Produs {
    private String denumire;
    private int pret;
    String cantitate; //100g sau 1 buc sau 30buc / cutie etc
    private String unitate; //bucata/kg/litru
    private float stoc; // putem avea 2.5 kg pe stoc, de aceea float

    public Produs(String denumire, int pret, String cantitate, String unitate) {
        this.denumire = denumire;
        this.pret = pret;
        this.unitate = unitate;
        this.cantitate = cantitate;
        this.stoc = 0;
    }
    public Produs(String denumire, int pret, String cantitate){
        this.denumire = denumire;
        this.pret = pret;
        this.unitate = "Bucata";
        this.cantitate = cantitate;
        this.stoc = 0;
    }

    public String getCantitate() {
        return cantitate;
    }

    public void setCantitate(String cantitate) {
        this.cantitate = cantitate;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public String getUnitate() {
        return unitate;
    }

    public void setUnitate(String unitate) {
        this.unitate = unitate;
    }

    public float getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "denumire= '" + denumire + '\'' +
                '}';
    }
    public void adaugaStoc(int s){
        this.stoc = this.stoc + s;
    }

    public int Cumpara(int n){
        this.stoc = this.stoc - n;
        return n * this.pret;
    }
}
