package biblioteka;


public class BibliotekaTest {
    Książka wPustyniIWPuszczy = new Książka("Henryk Sienkiweicz", "W pustyni iw puszczy");
    Książka harryPotter = new Książka("J.R.R Rowling", "Harry Potter");
    Książka panTadeusz = new Książka("Henryk Sienkiewicz", "Pan Tadeusz");
    Książka ogniemIMieczem = new Książka("Henryk Sienkiewicz", "Ogniem i Mieczem");
    Książka panWolodyjowski = new Książka("Henryk Sienkiewicz", "Pan Wolodyjowski");
    Książka mojaKSiazka = new Książka("Karolia Rudzka", "Ja");

    Półka półka1 = new Półka(1);
    Półka półka2 = new Półka(2);
    Półka półka3 = new Półka(3);
    Półka półka4 = new Półka(4);

    private Biblioteka biblioteka = new Biblioteka();

    public void dodanieNaPółke(){
        biblioteka.dodajNaPółke(wPustyniIWPuszczy, półka1);
        biblioteka.dodajNaPółke(harryPotter, półka2);
        biblioteka.dodajNaPółke(panTadeusz, półka3);
        biblioteka.dodajNaPółke(ogniemIMieczem, półka1);
        biblioteka.dodajNaPółke(panWolodyjowski,półka1);
        biblioteka.dodajNaPółke(mojaKSiazka, półka4);

        System.out.println("I test: " + "\n" + półka1.getNumerPółki() + " " + półka1.getListaKiążek() + "\n" +
                półka2.getNumerPółki() + " " + półka2.getListaKiążek() + "\n" +
                półka3.getNumerPółki() + " " + półka3.getListaKiążek() + "\n" +
                półka4.getNumerPółki() + " " + półka4.getListaKiążek() + "\n");

    }

    public void wypiszZawartosc(){
        System.out.println("II test: " + '\n');
        biblioteka.wypiszZawartosc(półka1);
    }

    public void zdejmijKsiazki(){
        System.out.println("III test: pre" + półka1.getListaKiążek());
        biblioteka.zdejmijKsiazki(półka1, 1,2);
        System.out.println("III test: post" + półka1.getListaKiążek());
    }

    public void przełóżKsiążke(){
        System.out.println("IV test: pre ");
        System.out.println(półka1);
        System.out.println(półka3);
        biblioteka.przelozKsiązke(półka1, półka3,panWolodyjowski);
        System.out.println("IV test: post ");
        System.out.println(półka1);
        System.out.println(półka3);
    }

    public void opróżnijPółke(){
        System.out.println("V test: pre ");
        System.out.println(półka3);
        biblioteka.opróżnijPółke(półka3);
        System.out.println("V test: post ");
        System.out.println(półka3);
    }

    public void liczbaPozycjiNaPółce(){
        System.out.println("VI test: liczba pozycji na półce nr "
                + półka2.getNumerPółki() + " " + biblioteka.liczbaPozycjiNaPółce(półka2));
    }

    public void numerPozycjiNaPółce(){
        System.out.println("VII test: ");
        System.out.println(biblioteka.numerPozycjiNaPółce(panWolodyjowski, półka3));
    }

    public static void main(String[] args) {

        BibliotekaTest bibliotekaTest = new BibliotekaTest();

        bibliotekaTest.dodanieNaPółke();
        bibliotekaTest.wypiszZawartosc();
        bibliotekaTest.zdejmijKsiazki();
        bibliotekaTest.przełóżKsiążke();
        //bibliotekaTest.opróżnijPółke();
        bibliotekaTest.liczbaPozycjiNaPółce();
        bibliotekaTest.numerPozycjiNaPółce();
    }

}
