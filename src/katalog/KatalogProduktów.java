package katalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class KatalogProduktów {

    public static final int MAX_WAGA = 10;
    public List<Produkt> listaProduktów = new ArrayList<>();
    public SortedSet<Produkt> setProduktów = new TreeSet<>(Produkt.BY_WAGA);

    public void zapewnianyPrzez(Dostawca dostawca){
        listaProduktów = dostawca.getListaProduktów();
        setProduktów.addAll(listaProduktów);
    }

    public Set<Produkt> produktyMalyVan(){
        Produkt najciezszyWMalymVanie = najlejszyWDuzymVanie();
        return setProduktów.headSet(najciezszyWMalymVanie);
    }

    public Set<Produkt> produktyDuzyVan(){

        return setProduktów.tailSet(najlejszyWDuzymVanie());
    }

    private Produkt najlejszyWDuzymVanie() {
        for(Produkt produkt : setProduktów){
            if(produkt.getWaga() > MAX_WAGA) {
                return produkt;
            }
        }
        return setProduktów.last();
    }


}
