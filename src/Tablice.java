import java.util.Arrays;

public class Tablice {

    public static void main(String[] args) {

        Produkt drzwi = new Produkt("drzwi dębowe", 30);
        Produkt okno = new Produkt("okno dębowe", 40);

        // stwórz

        Produkt[] produkty = {drzwi, okno};

        // wyświetl
        System.out.println(produkty);
        System.out.println(Arrays.toString(produkty));

        // dodaj
        System.out.println(produkty[1]);
        Produkt panel =  new Produkt("panel dębowy", 5);
        //produkty[2] = panel;
        produkty = dodajProdukt(produkty, panel);
        System.out.println(Arrays.toString(produkty));

        //duplikaty

        produkty = dodajProdukt(produkty, panel);
        System.out.println(Arrays.toString(produkty));


    }

    public static Produkt[] dodajProdukt(Produkt [] tablica, Produkt produkt){
        int dlugosc = tablica.length;
        Produkt [] nowaTablica = Arrays.copyOf(tablica, dlugosc + 1);
        nowaTablica[dlugosc] = produkt;
        return nowaTablica;
    }
}
