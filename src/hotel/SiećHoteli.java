package hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SiećHoteli {

    private Map<String, Hotel> siećHoteli;

    public SiećHoteli(Map<String, Hotel> siećHoteli) {
        this.siećHoteli = siećHoteli;
    }

    public List<Pokój> znajdzWolnePokojeWMiescie(String miasto){
        List<Pokój> lista = new ArrayList<>();

        for(Map.Entry<String, Hotel> wpis : siećHoteli.entrySet()){
            if(wpis.getValue().getMiasto().equals(miasto)){
                for(Map.Entry<Pokój, Gość> wpisDoHotelu: wpis.getValue().getMapaPokoi().entrySet()){
                    if(wpisDoHotelu.getValue().equals(Hotel.DEFAULT)){
                        lista.add(wpisDoHotelu.getKey());
                    }
                }
            }
        }
        return lista;
    }

    public int liczbaGosciWSieciHotelu(){
        int licznik = 0;
        for(Map.Entry<String, Hotel> wpis : siećHoteli.entrySet()){
            for(Map.Entry<Pokój, Gość> wpisWHotelu : wpis.getValue().getMapaPokoi().entrySet()){
                if(!wpisWHotelu.getValue().equals(Hotel.DEFAULT)){
                    licznik++;
                }
            }
        }
        return licznik;
    }

    public static void main(String[] args) {

        Hotel holidayInnKrk = new Hotel("Holiday Inn Krk", "Kraków");
        Hotel holidayInnWaw = new Hotel("Holiday Inn Waw", "Warszawa");
        Hotel holidayInnKtw = new Hotel("Holiday Inn Ktw", "Katowice");
        Hotel holidayInnPzn = new Hotel("Holiday Inn Pzn", "Poznań");

        Gość janNowak = new Gość("Jan", "Nowak");
        Gość krystynaJanda = new Gość("Krystyna", "Janda");
        Gość zenonZet = new Gość("Zenon", "Zet");
        Gość padTad = new Gość("Pad", "Tad");
        Gość jackToe = new Gość("Jack", "Toe");
        Gość flipFlap = new Gość("Flip", "Flap");

        holidayInnKrk.zameldujGoscia(Hotel.pokójApartament1, jackToe);
        holidayInnKrk.zameldujGoscia(Hotel.pokójPodstawa2, janNowak);
        holidayInnKrk.zameldujGoscia(Hotel.pokójPodwyższony3, krystynaJanda);
        holidayInnKrk.zameldujGoscia(Hotel.pokójPodstawa5, zenonZet);
        holidayInnKrk.zameldujGoscia(Hotel.pokójApartament2, flipFlap);
        holidayInnKrk.zameldujGoscia(Hotel.pokójPodstawa3, padTad);

        holidayInnKtw.zameldujGoscia(Hotel.pokójApartament1, jackToe);
        holidayInnKtw.zameldujGoscia(Hotel.pokójPodstawa2, janNowak);
        holidayInnKtw.zameldujGoscia(Hotel.pokójPodwyższony3, krystynaJanda);
        holidayInnKtw.zameldujGoscia(Hotel.pokójPodstawa5, zenonZet);
        holidayInnKtw.zameldujGoscia(Hotel.pokójApartament2, flipFlap);
        holidayInnKtw.zameldujGoscia(Hotel.pokójPodstawa3, padTad);

        holidayInnPzn.zameldujGoscia(Hotel.pokójApartament1, jackToe);
        holidayInnPzn.zameldujGoscia(Hotel.pokójPodstawa2, janNowak);
        holidayInnPzn.zameldujGoscia(Hotel.pokójPodwyższony3, krystynaJanda);

        holidayInnWaw.zameldujGoscia(Hotel.pokójPodstawa5, zenonZet);
        holidayInnWaw.zameldujGoscia(Hotel.pokójApartament2, flipFlap);
        holidayInnWaw.zameldujGoscia(Hotel.pokójPodstawa3, padTad);

        Map<String, Hotel> mapaSieci = new HashMap<>();
        mapaSieci.put(holidayInnKrk.getNazwa(), holidayInnKrk);
        mapaSieci.put(holidayInnKtw.getNazwa(), holidayInnKtw);
        mapaSieci.put(holidayInnPzn.getNazwa(), holidayInnPzn);
        mapaSieci.put(holidayInnWaw.getNazwa(), holidayInnWaw);

        SiećHoteli siećHoteli = new SiećHoteli(mapaSieci);

        System.out.println(siećHoteli.znajdzWolnePokojeWMiescie("Warszawa"));

        System.out.println();

        System.out.println(siećHoteli.liczbaGosciWSieciHotelu());


    }

}
