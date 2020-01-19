package usprawnienia;


import wysyłka.Produkt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMax {

    public static void main(String[] args) {

        Produkt produkt1 = new Produkt("drzwi,", 40);
        Produkt produkt2 = new Produkt("okno", 20);
        Produkt produkt3 = new Produkt("panel", 5);

        List<Produkt> lista = new ArrayList<>();

        Collections.addAll(lista, produkt1, produkt2, produkt3);

        Produkt min = Collections.min(lista, Produkt.BY_WAGA);
        System.out.println(min);

        Produkt max = Collections.max(lista, Produkt.BY_WAGA);
        System.out.println(max);

        System.out.println("-----");
        Collections.sort(lista, Produkt.BY_WAGA);
        lista.forEach(System.out::println);

        System.out.println("-----");
        Collections.shuffle(lista);
        lista.forEach(System.out::println);

        System.out.println("-----");
        Collections.shuffle(lista);
        lista.forEach(System.out::println);

        System.out.println("-----");
        Collections.rotate(lista,2);
        lista.forEach(System.out::println);

        System.out.println("-----");
        Collections.rotate(lista,2);
        lista.forEach(System.out::println);

        System.out.println("-----");
        Collections.rotate(lista,1);
        lista.forEach(System.out::println);

    }
}
