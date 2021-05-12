package Produse;

public class FructLeguma extends Produs{
    String Origine;
    String Tip;

    public FructLeguma(String denumire, int pret, String cantitate, String origine, String tip, String unitate) {
        super(denumire, pret, cantitate, unitate);
        Origine = origine;
        Tip = tip;
    }

    public FructLeguma(String denumire, int pret, String cantitate, String origine, String tip) {
        super(denumire, pret, cantitate,"Kg");
        Origine = origine;
        Tip = tip;
    }

    public String getOrigine() {
        return Origine;
    }

    public void setOrigine(String origine) {
        Origine = origine;
    }

    public String getTip() {
        return Tip;
    }

    public void setTip(String tip) {
        Tip = tip;
    }

    @Override
    public String toString() {
        return "FructLeguma{" +
                super.getDenumire() +
                "Origine= '" + Origine + '\'' +
                "; Tip='" + Tip + '\'' +
                '}';
    }
}
