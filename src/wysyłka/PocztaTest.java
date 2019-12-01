package wysyłka;

public class PocztaTest {
    Produkt drzwi = new Produkt("drzwi dębowe", 30);
    Produkt okno = new Produkt("okno dębowe", 40);
    Produkt panel = new Produkt("panel dębowy", 5);
    Produkt deska = new Produkt("deska sosnowa", 5);

    private Poczta poczta = new Poczta();

    public void dodanieProduktu(){
        poczta.dodajProdukt(drzwi);
        poczta.dodajProdukt(okno);

        System.out.println("I test: " + "\n" + poczta);

    }

    public void zamianaProduktu(){
        poczta.zamieńProdukt(drzwi, panel);
        System.out.println("II test: " + '\n' + poczta);
    }

    public void zamianaNieinstniejącegoProduktu(){
        System.out.println("III test: " );
        poczta.zamieńProdukt(deska, okno);
        System.out.println(poczta);
    }

    public void podzialNaVany(){
        Poczta pocztaVany = new Poczta();
        pocztaVany.dodajProdukt(okno);
        pocztaVany.dodajProdukt(drzwi);
        pocztaVany.dodajProdukt(panel);
        pocztaVany.dodajProdukt(deska);

        pocztaVany.przygotujPrzesylke();

        System.out.println("IV test: " + '\n' + "zawartość małego vana: " +
                pocztaVany.getMalyVanProdukty() + "\n" + "zawartość dużego vana: " +
                pocztaVany.getDuzyVanProdukty());
    }

    public static void main(String[] args) {
        PocztaTest pocztaTest = new PocztaTest();
        pocztaTest.dodanieProduktu();
        pocztaTest.zamianaProduktu();
        pocztaTest.zamianaNieinstniejącegoProduktu();
        pocztaTest.podzialNaVany();

    }
}
