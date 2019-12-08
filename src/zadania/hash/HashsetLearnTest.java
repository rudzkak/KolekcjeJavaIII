package zadania.hash;

public class HashsetLearnTest {

    Osoba osoba1 = new Osoba("Jan", "Kowalski", 20);
    Osoba osoba2 = new Osoba("Paweł", "Nowak", 45);
    Osoba osoba3 = new Osoba("Konrad", "Wallenrod", 76);
    Osoba osoba4 = new Osoba("Krystyna", "Janda", 20);
    Osoba osoba5 = new Osoba("Kamila", "Kamilska", 45);
    Osoba osoba6 = new Osoba("Adam", "Kowalski", 20);

    HashsetLearn hashsetLearn = new HashsetLearn();

    public void dodajOsobe(){
        hashsetLearn.dodajOsobe(osoba1);
        hashsetLearn.dodajOsobe(osoba2);
        hashsetLearn.dodajOsobe(osoba3);
        hashsetLearn.dodajOsobe(osoba4);
        hashsetLearn.dodajOsobe(osoba5);
        hashsetLearn.dodajOsobe(osoba6);

        System.out.println("I test: " + hashsetLearn);
    }

    public void usunOsobe(){
        hashsetLearn.usunOsobe(osoba6);
        System.out.println("II test: " + hashsetLearn);
    }

    public void zwrocSeta(){
        System.out.println("III test: ");
        System.out.println(hashsetLearn.zwrocSubseta(10, 15));
    }

    public static void main(String[] args) {
        HashsetLearnTest hashsetLearnTest = new HashsetLearnTest();
        hashsetLearnTest.dodajOsobe();
   //     hashsetLearnTest.usunOsobe();
        hashsetLearnTest.zwrocSeta();
    }
}
