package zadOsoba;

import java.util.Optional;

public class RejestrOsóbTest {

    Osoba osoba1 = new Osoba("Kowalski", 20);
    Osoba osoba2 = new Osoba("Nowak", 45);
    Osoba osoba3 = new Osoba("Wallenrod", 76);
    Osoba osoba4 = new Osoba("Pająk", 27);
    Osoba osoba5 = new Osoba("Janda", 54);
    Osoba osoba6 = new Osoba("Kamilska", 34);

    RejestrOsób rejestrOsób = new RejestrOsób();

    public void dodajOsobe(){
        rejestrOsób.dodajOsobe(osoba1);
        rejestrOsób.dodajOsobe(osoba2);
        rejestrOsób.dodajOsobe(osoba3);
        rejestrOsób.dodajOsobe(osoba4);
        rejestrOsób.dodajOsobe(osoba5);
        rejestrOsób.dodajOsobe(osoba6);

        System.out.println("Test I: " + rejestrOsób.getOsoby());
    }

    public void usunOsobe(){
        rejestrOsób.usunOsobe(osoba6);
        System.out.println("II test: " + rejestrOsób.getOsoby());
    }

    public void usunOsobeNull(){
        System.out.println("III test: ");
        rejestrOsób.usunOsobe(new Osoba("Pietrzak", 24));
    }

    public void wypiszListe(){
        System.out.println("IV test: ");
        rejestrOsób.wypiszListeOsób();
    }

    public void znajdzOsobe() {
        System.out.println("V test: ");
        System.out.println(rejestrOsób.znajdzOsobe("Janda"));
    }

    public void znajdzOsobeStream(){
        System.out.println("VI test: ");
        rejestrOsób.znajdzOsobeStream("Janda")
                .ifPresent(osoba -> System.out.println(osoba));

//        Optional<Osoba> osobaOptional = rejestrOsób.znajdzOsobeStream("Janda");
//        if(osobaOptional.isPresent()){
//            System.out.println(osobaOptional.get());
//        }
    }

    public void avg(){
        System.out.println("VII test: ");
        System.out.println(rejestrOsób.avg());
    }

    public void avgStream(){
        System.out.println("VIII test: ");
        System.out.println(rejestrOsób.avgStream());
    }

    public void min(){
        System.out.println("IX test: ");
        System.out.println(rejestrOsób.min());
    }

    public void minStream(){
        System.out.println("X test: ");
        System.out.println(rejestrOsób.minStream());
    }


    public void max(){
        System.out.println("XI test: ");
        System.out.println(rejestrOsób.max());
    }

    public void maxStream(){
        System.out.println("XII test: ");
        System.out.println(rejestrOsób.maxStream());
    }
    public static void main(String[] args) {
        RejestrOsóbTest rejestrOsóbTest = new RejestrOsóbTest();
        rejestrOsóbTest.dodajOsobe();
        rejestrOsóbTest.usunOsobe();
        rejestrOsóbTest.usunOsobeNull();
        rejestrOsóbTest.wypiszListe();
        rejestrOsóbTest.znajdzOsobe();
        rejestrOsóbTest.znajdzOsobeStream();
        rejestrOsóbTest.avg();
        rejestrOsóbTest.avgStream();
        rejestrOsóbTest.min();
        rejestrOsóbTest.minStream();
        rejestrOsóbTest.max();
        rejestrOsóbTest.maxStream();
    }
}
