package mapy;

import java.util.HashMap;
import java.util.Map;

public class PrzeglądProduktówMapa implements PrzeglądProduktów {

    Map<Integer, Produkt> mapaProduktów = new HashMap<>();

    @Override
    public void dodajProdukt(Produkt produkt) {
        if(mapaProduktów.containsKey(produkt.getId())){
            throw new IllegalArgumentException("Nie można dodać produktu "
                    + produkt + " bo to duplikat");
        }
        mapaProduktów.put(produkt.getId(), produkt);
    }

    @Override
    public Produkt znajdzPoId(int id) {
        return mapaProduktów.get(id);
    }

    @Override
    public void wyczyść() {
        mapaProduktów.clear();
    }
}
