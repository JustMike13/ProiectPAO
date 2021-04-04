package Produse;

public class Bautura extends Produs{
    int ContinutZahar; //gr/100ml
    public Bautura(String denumire, int pret,int Zahar, String unitate){
        super(denumire,pret,"1",unitate);
        this.ContinutZahar = Zahar;
    }
    public Bautura(String denumire, int pret,int Zahar){
        super(denumire,pret,"1","Sticla");
        this.ContinutZahar = Zahar;
    }

    public int getContinutZahar() {
        return ContinutZahar;
    }

    public void setContinutZahar(int continutZahar) {
        ContinutZahar = continutZahar;
    }


    @Override
    public String toString() {
        return "Bautura{" +
                super.getDenumire() +
                '}';
    }
}
