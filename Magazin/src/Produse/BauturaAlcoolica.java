package Produse;

public class BauturaAlcoolica extends Bautura{
    private int alcool;//procent

    public BauturaAlcoolica(String denumire, int pret, int Zahar, String unitate, int alcool) {
        super(denumire, pret, Zahar, unitate);
        this.alcool = alcool;
    }

    public BauturaAlcoolica(String denumire, int pret, int Zahar, int alcool) {
        super(denumire, pret, Zahar);
        this.alcool = alcool;
    }

    public int getAlcool() {
        return alcool;
    }

    public void setAlcool(int alcool) {
        this.alcool = alcool;
    }

    @Override
    public String toString() {
        return "BauturaAlcoolica{" +
                super.getDenumire() +
                "; alcool= " + alcool +"%"+
                '}';
    }
}
