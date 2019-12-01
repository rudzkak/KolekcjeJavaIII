package biblioteka;

import java.util.List;

public class Biblioteka {

    public void dodajNaPółke(Książka książka, Półka półka) {
        półka.getListaKiążek().add(książka);
    }

    public void wypiszZawartosc(Półka półka){
        List<Książka> lista = półka.getListaKiążek();
        System.out.println("Zawartosc półki: " + półka.getNumerPółki());
        for(Książka książka : lista){
            System.out.println(książka);
        }
    }

    public void zdejmijKsiazki(Półka półka, int indeksOd, int indeksDo){
        List<Książka> lista = półka.getListaKiążek();
        if(indeksOd < lista.size() && indeksDo <= lista.size() && indeksOd < indeksDo){
           List<Książka> sublistaKsiazek = lista.subList(indeksOd, indeksDo);
           lista.removeAll(sublistaKsiazek);
        } else{
            System.out.println("Błędne wartości indeksów");
        }
    }
}
