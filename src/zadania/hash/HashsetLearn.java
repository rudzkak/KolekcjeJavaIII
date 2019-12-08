package zadania.hash;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class HashsetLearn {

    SortedSet<Osoba> osoby = new TreeSet<>();

    public void dodajOsobe(Osoba osoba){
        osoby.add(osoba);
    }

    public void usunOsobe(Osoba osoba){
        if(osoby.contains(osoba)){
            osoby.remove(osoba);
        } else {
            System.out.println("Takiej nie ma osoby nie ma w secie");
        }
    }

    public Set<Osoba> zwrocSubseta(int wiekOd, int wiekDo){

        if(wiekOd > 0 && wiekOd < wiekDo){
            Osoba osobaOd = null;
            Osoba osobaDo = null;

            for(Osoba osoba : osoby){
                if(osoba.getWiek() >= wiekOd){
                    osobaOd = osoba;
                    break;
                }
            }
            if(osobaOd == null){
                System.out.println("Nie ma osoby starszej niż podany dolny wiek");
                return new TreeSet<>();
            }

            for(Osoba osoba : osoby){
                if(osoba.getWiek() <=wiekDo){
                    osobaDo = osoba;
                }
            }
            if(osobaDo == null){
                System.out.println("Nie ma osoby młodszej niż podany górny wiek");
                return new TreeSet<>();
            }

            Set<Osoba> set = new TreeSet<>();
            for(Osoba osoba : osoby){
                if(osoba.getWiek() >= osobaOd.getWiek()
                && osoba.getWiek() <= osobaDo.getWiek()){
                    set.add(osoba);
                }
            }
          return set;
        } else {
            System.out.println("Błędne dane wejściowe");
            return new TreeSet<>();
        }

    }

    @Override
    public String toString() {
        return "\n" + "osoby=" + osoby +
                '}';
    }
}
