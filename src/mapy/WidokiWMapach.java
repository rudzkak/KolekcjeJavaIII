package mapy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WidokiWMapach {


    public static void main(String[] args) {

        Produkt drzwi = new Produkt(1, "drzwi dębowe", 50);
        Produkt okno = new Produkt(2, "okno dębowe", 30);
        Produkt panel = new Produkt(3, "panel", 5);

        Map<Integer, Produkt> mapa = new HashMap<>();

        mapa.put(drzwi.getId(), drzwi);
        mapa.put(okno.getId(), okno);
        mapa.put(panel.getId(), panel);

        System.out.println(mapa);
        System.out.println();

        Set<Integer> ids = mapa.keySet();
        System.out.println(ids);

        ids.remove(1);
        System.out.println(ids);
        System.out.println(mapa);

       // ids.add(4); -> tutaj będzie błąd
//
//        Set<Integer> nowySet = new HashSet<>();
//        nowySet.addAll(ids);
//        nowySet.add(4);
//        System.out.println(nowySet);

        Set<Map.Entry<Integer, Produkt>> wpisy = mapa.entrySet();
        for(Map.Entry<Integer, Produkt> wpis : wpisy){
            System.out.println(wpis.getKey() + "-> " + wpis.getValue());
        }

        for(Map.Entry<Integer, Produkt> wpis : wpisy){
            wpis.setValue(drzwi);
            System.out.println(wpis.getKey() + "-> " + wpis.getValue());
        }

        System.out.println(mapa.values());

    }



}
