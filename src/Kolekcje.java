import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Kolekcje {

    public static void main(String[] args) {
        Produkt drzwi = new Produkt("drzwi dębowe", 30);
        Produkt okno = new Produkt("okno dębowe", 40);
        Produkt panel = new Produkt("panel dębowy", 5);
        Produkt deska = new Produkt("deska sosnowa", 5);

        Collection<Produkt> produkty = new ArrayList<>();
        produkty.add(drzwi);
        produkty.add(okno);
        produkty.add(panel);
        produkty.add(deska);

        System.out.println(produkty);

        Iterator<Produkt> iterator = produkty.iterator();

        while (iterator.hasNext()){
            Produkt produkt = iterator.next();
            if(produkt.getWaga() > 20){
                System.out.println(produkt);
            } else {
                iterator.remove();
            }
        }
        System.out.println("Wynik while'a : " + produkty);

//        for (Produkt produkt : produkty) {
//            if (produkt.getWaga() > 20) {
//                System.out.println(produkt);
//            } else {
//                produkty.remove(produkt);
//            }
//        }
//        System.out.println("Wynik for each'a: " + produkty);

        System.out.println(produkty.size());
        System.out.println(produkty.isEmpty());
        System.out.println(produkty.contains(deska));
        produkty.remove(okno);
        System.out.println(produkty.contains(okno));

        List<Produkt> listaPomocnicza = new ArrayList<>();
        listaPomocnicza.add(drzwi);
        listaPomocnicza.add(okno);

        produkty.addAll(listaPomocnicza);
        System.out.println(produkty);
        produkty.removeAll(listaPomocnicza);
        System.out.println(produkty);
    }
}
