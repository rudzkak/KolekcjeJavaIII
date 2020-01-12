package mapy;

import java.util.HashMap;
import java.util.Map;

public class Java8Nowości {

    public static void main(String[] args) {

        Produkt drzwi = new Produkt(1, "drzwi dębowe", 25);
        Produkt okno = new Produkt(2, "okno dębowe", 30);
        Produkt panel = new Produkt(3, "panel dębowy", 5);

        Produkt produktDefault = new Produkt(-1, "domyślny", 100);

        Map<Integer, Produkt> mapa = new HashMap<>();

        mapa.put(drzwi.getId(), drzwi);
        mapa.put(okno.getId(), okno);
        mapa.put(panel.getId(), panel);

        Produkt produkt = mapa.get(10);
        System.out.println(produkt);

        Produkt produktNieistniejacy = mapa.getOrDefault(10, produktDefault);
        System.out.println(produktNieistniejacy);
        System.out.println();
        System.out.println(mapa);

        Produkt prodktIstniejacy = mapa.getOrDefault(1, produktDefault);
        System.out.println(prodktIstniejacy);

        System.out.println();
        Produkt wynik = mapa.replace(1, new Produkt(1, "duże drzwi", 30));
        System.out.println(wynik);
        System.out.println(mapa.get(1));

        Produkt nieobecny = mapa.replace(4,new Produkt(1, "duże drzwi", 30));
        System.out.println(nieobecny);
        System.out.println(mapa.get(4));
        System.out.println();

        mapa.replaceAll((id, staryProdukt) ->
                new Produkt(staryProdukt.getId() , staryProdukt.getNazwa(),
                        staryProdukt.getWaga() + 10));
        System.out.println(mapa);
        System.out.println();

        Produkt nieobecny2 = mapa.computeIfAbsent(10, (id) ->
                new Produkt(10, "nowy produkt", 10));
        System.out.println(nieobecny2);
        System.out.println();
        System.out.println(mapa);
        System.out.println();

        Produkt obecny = mapa.computeIfAbsent(10, (id) ->
                new Produkt(10, "nowy produkt", 20));
        System.out.println(obecny);
        System.out.println();
        System.out.println(mapa);

        mapa.forEach((klucz, wartość) ->
                System.out.println(klucz + " -> " + wartość));
    }
}
