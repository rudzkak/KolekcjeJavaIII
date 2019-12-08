package samochód;

import java.util.ArrayDeque;
import java.util.Queue;

public class Myjnia {

    public Queue<Samochód> kolejka = new ArrayDeque<>();

    public void dodajDoKolejki(Samochód samochód){
        kolejka.offer(samochód);
    }

    public void umyjWszystkieSamochody(){
        while (kolejka.peek() != null){
            System.out.println("Został umyty: "
                    + kolejka.poll());
        }
    }

    public static void main(String[] args) {

        Samochód samochód1 = new Samochód("Fiat", "Bravo", 2010, 12000);
        Samochód samochód2 = new Samochód("Jeep", "Renegade", 2017, 40000);
        Samochód samochód3 = new Samochód("Nissan", "Xtrail", 2017, 80000);
        Samochód samochód4 = new Samochód("Renault", "Megane", 2019, 75000);
        Samochód samochód5 = new Samochód("Toyota", "Yaris", 2016, 35000);
        Samochód samochód6 = new Samochód("Toyota", "Yaris", 2016, 30000);
        Samochód samochód7 = new Samochód("Toyota", "Yaris", 2017, 31000);

        Myjnia myjnia = new Myjnia();

        myjnia.dodajDoKolejki(samochód1);
        myjnia.dodajDoKolejki(samochód2);
        myjnia.dodajDoKolejki(samochód3);
        myjnia.dodajDoKolejki(samochód4);
        myjnia.dodajDoKolejki(samochód5);
        myjnia.dodajDoKolejki(samochód6);

        myjnia.umyjWszystkieSamochody();
    }
}
