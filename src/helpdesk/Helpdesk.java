package helpdesk;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

public class Helpdesk {

    public static final String MEZCZYNA = "M";
    //FIFO
    private final Queue<Zgłoszenie> zgłoszenia = new ArrayDeque<>();

    public void zgłoszenie(final Klient klient, final Kategoria kategoria){
        zgłoszenia.offer(new Zgłoszenie(klient, kategoria));
    }

    public void procesujWszystkieZgłoszenia(){

        Zgłoszenie zgłoszenie;

        while ((zgłoszenie = zgłoszenia.poll()) != null){
            if(zgłoszenie.getKlient().getPlec().equals(MEZCZYNA)){
                zgłoszenie.getKlient().odpowiedź("Czy próbowałeś włączyć i wyłączyć?");
            } else {
                zgłoszenie.getKlient().odpowiedź("Czy próbowałaś włączyć i wyłączyć?");
            }
        }

    }

    public void procesujZgłoszeniaDrukarek(){

        Predicate<Zgłoszenie> warunek = (z -> z.getKategoria() == Kategoria.DRUKARKA);
        String wiadomość = "Czy nie skończył się papier?";

        procesujZgłoszenia(warunek, wiadomość);
    }

    public void procesujZgłoszeniaGeneralne(){

        Predicate<Zgłoszenie> warunek = (z -> z.getKategoria() != Kategoria.DRUKARKA);
        String wiadomość = "Czy próbowałeś/aś włączyć i wyłączyć?";

        procesujZgłoszenia(warunek, wiadomość);
    }

    public void procesujZgłoszenia(Predicate<Zgłoszenie> warunek, String wiadomość) {
        final Zgłoszenie zgłoszenie = zgłoszenia.peek();
        if (zgłoszenie != null && warunek.test(zgłoszenie)) {
            zgłoszenia.remove();
            zgłoszenie.getKlient().odpowiedź(wiadomość);
        } else {
            System.out.println("Nie ma zgłoszeń");
        }
    }


    public static void main(String[] args) {
        Helpdesk helpdesk = new Helpdesk();

        helpdesk.zgłoszenie(Klient.AGATA, Kategoria.KOMPUTER);
        helpdesk.zgłoszenie(Klient.AGNIESZKA, Kategoria.DRUKARKA);
        helpdesk.zgłoszenie(Klient.JACEK, Kategoria.KOMPUTER);

        //helpdesk.procesujWszystkieZgłoszenia();
        helpdesk.procesujZgłoszeniaDrukarek();
        helpdesk.procesujZgłoszeniaGeneralne();
        helpdesk.procesujZgłoszeniaDrukarek();
        helpdesk.procesujZgłoszeniaGeneralne();


    }

}
