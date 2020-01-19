package sklep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SiećSklepów {

    private Map<String, Map<GatunekProduktu, List<Produkt>>> mapaSieci = new HashMap<>();

    public void dodajDoSieci(Sklep sklep){
        mapaSieci.put(sklep.getMiasto(), sklep.getMapaSklepu());
    }

    public List<Produkt> znajdzProduktyKonkretnegoGatunkuIKonkretnegoProducentaWDanymMiescie(GatunekProduktu gatunekProduktu, Producent producent, String miasto){
        List<Produkt> lista = new ArrayList<>();
        if(mapaSieci.containsKey(miasto)){
            for(Map.Entry<String, Map<GatunekProduktu, List<Produkt>>> wpis : mapaSieci.entrySet()){
                if(wpis.getKey().equals(miasto)){
                    if(wpis.getValue().containsKey(gatunekProduktu)){
                        for(Map.Entry<GatunekProduktu, List<Produkt>> wpisWSklepie: wpis.getValue().entrySet()){
                            if(wpisWSklepie.getKey().equals(gatunekProduktu)){
                                for(Produkt produkt : wpisWSklepie.getValue()){
                                    if(produkt.getProducent().equals(producent)) {
                                        lista.add(produkt);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return lista;
    }

    public Set<Producent> znajdzProducentowWDanymMiescie(String miasto){
        Set<Producent> set = new HashSet<>();
        if(mapaSieci.containsKey(miasto)){
            for(Map.Entry<GatunekProduktu, List<Produkt>> wpis: mapaSieci.get(miasto).entrySet()){
                for(Produkt produkt : wpis.getValue()){
                    set.add(produkt.getProducent());
                }
            }
        }
        return set;
    }

    public Set<String> znajdzMiastaWKtorychJestDanyProdukt(Produkt produkt){
        Set<String> set = new HashSet<>();
        for(Map.Entry<String, Map<GatunekProduktu, List<Produkt>>> wpis : mapaSieci.entrySet()){
            for(Map.Entry<GatunekProduktu, List<Produkt>> wpisWSklepie : wpis.getValue().entrySet()){
                for(Produkt p : wpisWSklepie.getValue()){
                    if(p.equals(produkt)){
                        set.add(wpis.getKey());
                    }
                }
            }
        }
        return set;
    }

}
