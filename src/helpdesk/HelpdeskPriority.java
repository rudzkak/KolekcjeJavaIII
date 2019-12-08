package helpdesk;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static helpdesk.Helpdesk.MEZCZYNA;

public class HelpdeskPriority {

    private static final Comparator<Zgłoszenie> WG_KATEGORII = new Comparator<Zgłoszenie>() {
        @Override
        public int compare(Zgłoszenie o1, Zgłoszenie o2) {
            return o1.getKategoria().compareTo(o2.getKategoria());
        }
    };

    // PRIORITY
    private final Queue<Zgłoszenie> zgłoszenia = new PriorityQueue<>(WG_KATEGORII);

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

    public static void main(String[] args) {
        HelpdeskPriority helpdeskPriority = new HelpdeskPriority();

        helpdeskPriority.zgłoszenie(Klient.JACEK, Kategoria.TELEFON);
        helpdeskPriority.zgłoszenie(Klient.AGATA, Kategoria.KOMPUTER);
        helpdeskPriority.zgłoszenie(Klient.AGNIESZKA, Kategoria.DRUKARKA);
        helpdeskPriority.zgłoszenie(Klient.JACEK, Kategoria.KOMPUTER);

        helpdeskPriority.procesujWszystkieZgłoszenia();

    }
}
