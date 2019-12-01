package wysyłka;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poczta {

    public static final int PRODUKT_NIE_ISTNIEJE = -1;
    public static final int MINI_VAN_MAX_WAGA = 20;

    private final List<Produkt> produkty = new ArrayList<>();
    private List<Produkt> malyVanProdukty;
    private List<Produkt> duzyVanProdukty;

    public List<Produkt> getMalyVanProdukty() {
        return malyVanProdukty;
    }

    public List<Produkt> getDuzyVanProdukty() {
        return duzyVanProdukty;
    }

    public void dodajProdukt(Produkt produkt){
        produkty.add(produkt);
    }

    public void zamieńProdukt(Produkt staryProdukt, Produkt nowyProdukt){
        int indeks = produkty.indexOf(staryProdukt);

        if(indeks != PRODUKT_NIE_ISTNIEJE) {
            produkty.set(indeks, nowyProdukt);
        } else{
            System.out.println("Nie istnieje produkt o podanym indeksie");
        }
    }

    public void przygotujPrzesylke(){
        //sortowanie wg wagi
        Collections.sort(produkty, Produkt.BY_WAGA);
        // znajdz indeks produktu, który jako pierwszy ma się znaleźć w dużym vanie
        int indeks = znajdzIndeksPodziału();
        malyVanProdukty = produkty.subList(0, indeks);
        duzyVanProdukty = produkty.subList(indeks, produkty.size());
    }

    private int znajdzIndeksPodziału() {
        for(int i =0; i < produkty.size(); i++){
            if(produkty.get(i).getWaga() > MINI_VAN_MAX_WAGA){
                return i;
            }
        }
        return 0;
    }


    @Override
    public String toString(){
        return produkty.toString();
    }

}
