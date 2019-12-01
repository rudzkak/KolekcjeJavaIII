import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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

        final Iterator<Produkt> iterator = produkty.iterator();

//        while (iterator.hasNext()){
//            Produkt produkt = iterator.next();
//            if(produkt.getWaga() > 20){
//                System.out.println(produkt);
//            }
//        }

        for (Produkt produkt : produkty) {
            if (produkt.getWaga() > 20) {
                System.out.println(produkt);
            }
        }


    }

}
