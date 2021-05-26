package Produse;

public class Mezeluri extends Produs{
    private int valabilitate; //zile de la cumparare

    public Mezeluri(String denumire, int pret, int valabilitate) {
        super(denumire,pret,"Kg");
        this.valabilitate = valabilitate;
    }

    public int getValabilitate() {
        return valabilitate;
    }

    public void setValabilitate(int valabilitate) {
        this.valabilitate = valabilitate;
    }

    public int Cumpara(int n){
        System.out.println("Produsul "+this.getDenumire());
        return super.Cumpara(n);
    }

    @Override
    public String toString() {
        return "Mezeluri{" +
                super.getDenumire() +
                '}';
    }
}
