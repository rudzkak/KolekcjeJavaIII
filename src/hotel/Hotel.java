package hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Hotel {

    public static final Gość DEFAULT = new Gość("nikt", "ważny");

    public static final Pokój pokójPodstawa1 = new Pokój(1, Standard.PODSTAWOWY);
    public static final Pokój pokójPodstawa2 = new Pokój(2, Standard.PODSTAWOWY);
    public static final Pokój pokójPodstawa3 = new Pokój(3, Standard.PODSTAWOWY);
    public static final Pokój pokójPodstawa4 = new Pokój(4, Standard.PODSTAWOWY);
    public static final Pokój pokójPodstawa5 = new Pokój(5, Standard.PODSTAWOWY);
    public static final Pokój pokójPodwyższony1 = new Pokój(6, Standard.PODWYŻSZONY);
    public static final Pokój pokójPodwyższony2 = new Pokój(7, Standard.PODWYŻSZONY);
    public static final Pokój pokójPodwyższony3 = new Pokój(8, Standard.PODWYŻSZONY);
    public static final Pokój pokójApartament1 = new Pokój(9, Standard.APARTAMENT);
    public static final Pokój pokójApartament2 = new Pokój(10, Standard.APARTAMENT);

    private static final int NIE_MA_TAKIEGO_POKOJU = -1;
    private String nazwa;
    private String miasto;
    private Map<Pokój, Gość> mapaPokoi;


    public Hotel(String nazwa, String miasto) {
        this.nazwa = nazwa;
        this.miasto = miasto;
        this.mapaPokoi = new HashMap<>();

        mapaPokoi.put(pokójPodstawa1, DEFAULT);
        mapaPokoi.put(pokójPodstawa2, DEFAULT);
        mapaPokoi.put(pokójPodstawa3, DEFAULT);
        mapaPokoi.put(pokójPodstawa4, DEFAULT);
        mapaPokoi.put(pokójPodstawa5, DEFAULT);
        mapaPokoi.put(pokójPodwyższony1, DEFAULT);
        mapaPokoi.put(pokójPodwyższony2, DEFAULT);
        mapaPokoi.put(pokójPodwyższony3, DEFAULT);
        mapaPokoi.put(pokójApartament1, DEFAULT);
        mapaPokoi.put(pokójApartament2, DEFAULT);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public Map<Pokój, Gość> getMapaPokoi() {
        return mapaPokoi;
    }

    public void setMapaPokoi(Map<Pokój, Gość> mapaPokoi) {
        this.mapaPokoi = mapaPokoi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(nazwa, hotel.nazwa) &&
                Objects.equals(miasto, hotel.miasto) &&
                Objects.equals(mapaPokoi, hotel.mapaPokoi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, miasto, mapaPokoi);
    }

    @Override
    public String
    toString() {
        return "Hotel{" +
                "nazwa='" + nazwa + '\'' +
                ", miasto='" + miasto + '\'' +
                ", mapaPokoi=" + mapaPokoi +
                '}';
    }

    public void zameldujGoscia(Pokój pokój, Gość gość){
        mapaPokoi.put(pokój,gość);
    }

    public void wymeldujGoscia(Pokój pokój){
        mapaPokoi.put(pokój, DEFAULT);
    }

    public Gość znajdzGosciaPoNrPokoju(int numerPokoju){
        for(Map.Entry<Pokój, Gość> wpis : mapaPokoi.entrySet()){
            if(wpis.getKey().getNumerPokoju() == numerPokoju){
                return wpis.getValue();
            }
        }
        return null;
    }

    public Optional<Gość> znajdzGosciaPoNrPokojuStream(int numerPokoju){
        return mapaPokoi.entrySet().stream()
                .filter(wpis-> wpis.getKey().getNumerPokoju() == numerPokoju)
                .findAny().map(wpis -> wpis.getValue());
    }

    public int znajdzNumerPokojuPoNazwisku(String nazwisko){
        for(Map.Entry<Pokój, Gość> wpis : mapaPokoi.entrySet()){
            if(wpis.getValue().getNazwisko().equals(nazwisko)){
                return wpis.getKey().getNumerPokoju();
            }
        }
        return NIE_MA_TAKIEGO_POKOJU;
    }

//    public Optional<Integer> znajdz(String n){
//        return mapaPokoi.entrySet().stream()
//                .filter(wpis-> wpis.getValue().getNazwisko().equals(n))
//                .findAny().map(wpis-> wpis.getKey().getNumerPokoju());
//    }

    public List<Pokój> znajdzWolnePokojeWStandardzie(Standard standard){
        List<Pokój> lista = new ArrayList();
        for(Map.Entry<Pokój, Gość> wpis : mapaPokoi.entrySet()){
            if(wpis.getKey().getStandard().equals(standard)
            && wpis.getValue().equals(DEFAULT)){
                lista.add(wpis.getKey());
            }
        }
        return lista;
    }

    public static void main(String[] args) {

        Gość janNowak = new Gość("Jan", "Nowak");
        Gość krystynaJanda = new Gość("Krystyna", "Janda");
        Gość zenonZet = new Gość("Zenon", "Zet");
        Gość padTad = new Gość("Pad", "Tad");
        Gość jackToe = new Gość("Jack", "Toe");
        Gość flipFlap = new Gość("Flip", "Flap");

        Hotel hotel = new Hotel("Ibis", "Kraków");

        hotel.mapaPokoi.forEach(((pokój, gość) ->
                System.out.println(pokój + " -> " + gość)));

        System.out.println();

        hotel.zameldujGoscia(pokójApartament1, jackToe);
        hotel.zameldujGoscia(pokójPodstawa2, janNowak);
        hotel.zameldujGoscia(pokójPodwyższony3, krystynaJanda);
        hotel.zameldujGoscia(pokójPodstawa5, zenonZet);
        hotel.zameldujGoscia(pokójApartament2, flipFlap);
        hotel.zameldujGoscia(pokójPodstawa3, padTad);

        hotel.mapaPokoi.forEach(((pokój, gość) ->
                System.out.println(pokój + " -> " + gość)));

        System.out.println();

        hotel.wymeldujGoscia(pokójApartament1);

        hotel.mapaPokoi.forEach(((pokój, gość) ->
                System.out.println(pokój + " -> " + gość)));

        System.out.println();

        System.out.println(hotel.znajdzGosciaPoNrPokoju(5));
        System.out.println(hotel.znajdzGosciaPoNrPokojuStream(5).get());

        System.out.println();
        System.out.println(hotel.znajdzNumerPokojuPoNazwisku("Nowak"));

        System.out.println();
        System.out.println(hotel.znajdzWolnePokojeWStandardzie(Standard.PODSTAWOWY));


    }
}
