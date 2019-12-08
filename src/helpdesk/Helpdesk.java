package helpdesk;

import java.util.ArrayDeque;
import java.util.Queue;

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
        final Zgłoszenie zgłoszenie = zgłoszenia.peek();
        if(zgłoszenie != null && zgłoszenie.getKategoria() == Kategoria.DRUKARKA){
            zgłoszenia.remove();
            zgłoszenie.getKlient().odpowiedź("Czy nie skończył się papier?");
        } else {
            System.out.println("Nie ma zgłoszeń");
        }
    }

    public void procesujZgłoszeniaGeneralne(){

    }


    public static void main(String[] args) {
        Helpdesk helpdesk = new Helpdesk();

        helpdesk.zgłoszenie(Klient.AGATA, Kategoria.KOMPUTER);
        helpdesk.zgłoszenie(Klient.AGNIESZKA, Kategoria.DRUKARKA);
        helpdesk.zgłoszenie(Klient.JACEK, Kategoria.KOMPUTER);

        helpdesk.procesujWszystkieZgłoszenia();


    }

}
