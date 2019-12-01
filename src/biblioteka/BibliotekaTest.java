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

    public static void main(String[] args) {

        BibliotekaTest bibliotekaTest = new BibliotekaTest();

        bibliotekaTest.dodanieNaPółke();
        bibliotekaTest.wypiszZawartosc();
        bibliotekaTest.zdejmijKsiazki();
    }


}
