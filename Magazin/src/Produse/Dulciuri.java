package Produse;

public class Dulciuri extends Produs{
    private int ContinutZahar; // gr/100g

    public Dulciuri(String denumire, int pret, String cantitate, int continutZahar, String unitate) {
        super(denumire, pret, cantitate, unitate);
        ContinutZahar = continutZahar;
    }

    public Dulciuri(String denumire, int pret, String cantitate, int continutZahar) {
        super(denumire, pret, cantitate);
        ContinutZahar = continutZahar;
    }

    public int getContinutZahar() {
        return ContinutZahar;
    }

    public void setContinutZahar(int continutZahar) {
        ContinutZahar = continutZahar;
    }

    @Override
    public String toString() {
        return "Dulciuri{" +
                super.getDenumire() +
                '}';
    }
}
