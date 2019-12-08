package zadOsoba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class RejestrOsób {

    private List<Osoba> osoby;

    public RejestrOsób(){
        this.osoby = new ArrayList<>();
    }

    public List<Osoba> getOsoby() {
        return osoby;
    }

    public void dodajOsobe(Osoba osoba){
        osoby.add(osoba);
    }

    public void usunOsobe(Osoba osoba){
        if(!osoby.remove(osoba)){
            System.out.println("Takiej osoby nigdy nie było na liście");
        }
    }
    public void wypiszListeOsób(){
        Iterator<Osoba> iterator = osoby.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next() + "\n");
        }
    }

    public Osoba znajdzOsobe(String nazwisko){
        for(int i=0; i<=osoby.size(); i++){
            if(osoby.get(i).getNazwisko().equals(nazwisko)){
                return osoby.get(i);
            }
        }
        return null;
    }

    public Optional<Osoba> znajdzOsobeStream(String nazwisko){
       return osoby.stream().filter(osoba -> osoba.getNazwisko().equals(nazwisko))
                .findFirst();
    }

    public double avg(){
        double suma = 0;
        for(Osoba osoba : osoby){
            suma += osoba.getWiek();
        }
        return suma/osoby.size();
    }

    public double avgStream(){
        return osoby.stream().mapToDouble(Osoba::getWiek).sum()/osoby.size();
    }

    public Osoba min(){
        Osoba najmlodsza = osoby.get(0);
        for(Osoba osoba : osoby){
            if(osoba.getWiek()< najmlodsza.getWiek()){
                najmlodsza = osoba;
            }
        }
        return najmlodsza;
    }

    public Osoba minStream(){
        osoby.sort(Comparator.comparing(Osoba::getWiek));
        return osoby.get(0);
    }

    public Osoba max(){
        Osoba najstarsza = osoby.get(0);
        for(Osoba osoba : osoby){
            if(osoba.getWiek() > najstarsza.getWiek()){
                najstarsza = osoba;
            }
        }
        return najstarsza;
    }

    public Osoba maxStream(){
        return Collections.max(osoby, Comparator.comparing(Osoba::getWiek));
    }


}
