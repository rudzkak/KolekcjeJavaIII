package praca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Praca {

    private Map<Stanowisko, Set<Zadania>> zadaniaNaStanowisku = new HashMap<>();

    public void dodajZadanieNaStanowisko(Zadania zadanie, Stanowisko stanowisko){
        Set<Zadania> setZadan = new HashSet<>();
        if(zadaniaNaStanowisku.containsKey(stanowisko)){
            zadaniaNaStanowisku.get(stanowisko).add(zadanie);
        } else {
            setZadan.add(zadanie);
            zadaniaNaStanowisku.put(stanowisko, setZadan);
        }
    }

    public void usunZadanieZeStanowiska(Stanowisko stanowisko, Zadania zadania){
        if(zadaniaNaStanowisku.containsKey(stanowisko)){
            if (zadaniaNaStanowisku.get(stanowisko).contains(zadania)) {
                zadaniaNaStanowisku.get(stanowisko).remove(zadania);
            }
        }
    }

    public void wypiszZadaniaNaStanowisku(Stanowisko stanowisko){
        if(zadaniaNaStanowisku.containsKey(stanowisko)){
            Set<Zadania> set = zadaniaNaStanowisku.get(stanowisko);
            System.out.println("Lista zadań na stanowisku: " + stanowisko);
            for(Zadania zadanie : set){
                System.out.println(zadanie);
            }
        }
    }

    public Set<Zadania> zwrocListeZadanPracownika(Pracownik pracownik){
        if(zadaniaNaStanowisku.containsKey(pracownik.getStanowisko())){
            return zadaniaNaStanowisku.get(pracownik.getStanowisko());
        }
        else{
            return new HashSet<>();
        }
    }

    public static void main(String[] args) {

        Praca praca = new Praca();

        Pracownik pracownik1 = new Pracownik("Jan", "Nowak", Stanowisko.KIEROWCA);
        Pracownik pracownik2 = new Pracownik("Zenon", "Zet", Stanowisko.PRACOWNIK_MAGAZYNU);


        praca.dodajZadanieNaStanowisko(Zadania.DOSTARCZENIE_PACZEK, Stanowisko.KIEROWCA);
        praca.dodajZadanieNaStanowisko(Zadania.ODBIERANIE_PACZEK, Stanowisko.KIEROWCA);
        praca.dodajZadanieNaStanowisko(Zadania.ROZWIĄZYWANIE_KONFLIKTÓW, Stanowisko.KOORDYNATOR_PLACÓWKI);
        praca.dodajZadanieNaStanowisko(Zadania.SORTOWANIE_PACZEK, Stanowisko.PRACOWNIK_MAGAZYNU);
        praca.dodajZadanieNaStanowisko(Zadania.ŁADOWANIE_SAMOCHODU, Stanowisko.KIEROWCA);

        praca.zadaniaNaStanowisku.forEach(((stanowisko, zadania) ->
                System.out.println(stanowisko + " -> " + zadania)));

        praca.usunZadanieZeStanowiska(Stanowisko.KIEROWCA, Zadania.ODBIERANIE_PACZEK);

        System.out.println();
        praca.zadaniaNaStanowisku.forEach(((stanowisko, zadania) ->
                System.out.println(stanowisko + " -> " + zadania)));

        praca.wypiszZadaniaNaStanowisku(Stanowisko.KIEROWCA);

        System.out.println();

        System.out.println(praca.zwrocListeZadanPracownika(pracownik2));

    }

}
