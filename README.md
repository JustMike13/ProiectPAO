# ProiectPAO
Tema : Magazin

Tipuri de obiecte:
- Persoana
- Angajat (mosteneste Persoana)
- Produs
- Bautura (mosteneste Produs)
- Bautura Alcoolica (mosteneste Bautura)
- Mezeluri (mosteneste Produs)
- Dulciuri (mosteneste Produs)
- FructLeguma (mosteneste Produs)

Actiuni/Interogari implementate:
- Persoana.cumpara(Produs p, int Q) => scade Q din stocul produsului si Q*Produs.getPret din bugetul persoanei
- Persoana.actualizeazaBuget(Int S) => adauga S la bugetul curent al persoanei
- Angajat.adaugaStoc(Produs p, int q) => adauga q la stocul produsului p
- Angajat.Promoveaza(Angajat a, String f) => modifica functia lui a la f, apelabil doar de angajat cu functie == "Manager"
- Angajat.oferaBonus(Angajat a, int b) => adauga b la bugetul lui a, apelabil doar de angajat cu functie == "Manager"
- Service.AdaugaProdus(Angajat a, Produs p) => adauga produsul p in lista de produse, doar daca a.getFunctie == "Manager"
- Service.AdaugaProdus(Angajat a, Produs p, int q) => adauga produsul p in lista de produse si ii modifica stocul la q, doar daca a.getFunctie == "Manager"
- Service.AdaugaAngajat(Angajat a) => adauga angajatul a in lista
- Service.AdaugaPersoana(Persoana p) => adauga persoana p in lista
- Service.ListaProduse() => Afiseaza o lista cu toate produsele din magazin (meniu)
