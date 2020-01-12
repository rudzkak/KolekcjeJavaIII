package mapy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cennik {

    public static void main(String[] args) {

        Map<String, Double> cennik = new HashMap<>();

        cennik.put("chleb",2.4);
        cennik.put("bagietka", 1.6);
        cennik.put("mleko", 4.0);

        Scanner skaner = new Scanner(System.in);
        System.out.println("Podaj produkt, którego cenę chcesz poznać");

        String klucz = skaner.nextLine();

        if(cennik.containsKey(klucz)){
            System.out.println(cennik.get(klucz));
        } else {
            System.out.println("W cenniku nie ma takiego produktu");
        }
    }
}
