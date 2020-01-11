package pralnia;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Pralnia {

    private List<Usługa> listaUsług = new ArrayList<>();
    private PriorityQueue<Usługa> kolejka = new PriorityQueue<>();


    public void dodajUsługe(Usługa usługa) {
        listaUsług.add(usługa);
        kolejka.offer(usługa);
    }

    public void wykonanoUsługe(Usługa usługa) {
        if (listaUsług.contains(usługa)) {
            listaUsług.remove(usługa);
        }
        if (kolejka.contains(usługa)) {
            kolejka.remove(usługa);
        }
    }

    public List<Usługa> usługiKonkretnegoKlienta(Klient klient){
        List<Usługa> lista = new ArrayList<>();
        for(Usługa usługa: listaUsług){
            if(usługa.getKlient().equals(klient)){
                lista.add(usługa);
            }
        }
        return lista;
    }

    public List<Usługa> usługiKonkretnegoKlientaStream(Klient klient){
        return listaUsług.stream()
                .filter(usługa -> usługa.getKlient().equals(klient))
                .collect(Collectors.toList());
    }

    public List<Usługa> usługiZKonkretnymMateriałem(Materiał materiał){
        return listaUsług.stream()
                .filter(usługa -> usługa.getUbranie().getMateriał().equals(materiał))
                .collect(Collectors.toList());
    }

    public long liczbaUsługZKonkretnymMateriałem(Materiał materiał){
        return listaUsług.stream()
                .filter(usługa -> usługa.getUbranie().getMateriał().equals(materiał))
                .count();
    }

    public void wykonajWszystkieUsługi(){
        while(kolejka.peek() != null){
            System.out.println("Usługa: " + kolejka.peek() + " została wykonana");
            wykonanoUsługe(kolejka.peek());
        }
    }

    public static void main(String[] args) {

        Klient janNowak = new Klient("Jan", "Nowak");
        Klient elaJanusz = new Klient("Ela", "Janusz");
        Klient hieronimZet = new Klient("Hieronim", "Zet");
        Klient adelajdaPe = new Klient("Adelajda", "Pe");

        Ubranie spodnieJana = new Ubranie(Materiał.LEN, "spodnie", "biel");
        Ubranie marynarkaJana = new Ubranie(Materiał.WEŁNA, "marynarka", "czerń");
        Ubranie koszulaJana = new Ubranie(Materiał.BAWEŁNA, "koszula", "zieleń");
        Ubranie spodnieEli = new Ubranie(Materiał.WEŁNA, "spodnie", "biel");
        Ubranie marynarkaHieronima = new Ubranie(Materiał.WEŁNA, "marynarka", "beż");
        Ubranie koszulaAdelajdy = new Ubranie(Materiał.BAWEŁNA, "koszula", "zieleń");

        Usługa usługa1 = new Usługa(janNowak, spodnieJana);
        Usługa usługa2 = new Usługa(janNowak, marynarkaJana);
        Usługa usługa3 = new Usługa(janNowak, koszulaJana);
        Usługa usługa4 = new Usługa(elaJanusz, spodnieEli);
        Usługa usługa5 = new Usługa(hieronimZet, marynarkaHieronima);
        Usługa usługa6 = new Usługa(adelajdaPe, koszulaAdelajdy);

        Pralnia pralnia = new Pralnia();

        pralnia.dodajUsługe(usługa1);
        pralnia.dodajUsługe(usługa2);
        pralnia.dodajUsługe(usługa3);
        pralnia.dodajUsługe(usługa4);
        pralnia.dodajUsługe(usługa5);
        pralnia.dodajUsługe(usługa6);

        System.out.println("I test: lista " + pralnia.listaUsług);
        System.out.println();
        System.out.println("I test: kolejka " + pralnia.kolejka);

        System.out.println();
        System.out.println();

        pralnia.wykonanoUsługe(usługa1);

        System.out.println("II test: lista " + pralnia.listaUsług);
        System.out.println();
        System.out.println("II test: kolejka " + pralnia.kolejka);

        System.out.println();

        System.out.println("III test: usługi klienta " + pralnia.usługiKonkretnegoKlienta(janNowak));

        System.out.println();

        System.out.println("IV test: usługi z materiałem: " + pralnia.usługiZKonkretnymMateriałem(
                Materiał.WEŁNA));

        System.out.println();

        System.out.println("V test: wykonaj wszystko ");
        pralnia.wykonajWszystkieUsługi();
    }

}
