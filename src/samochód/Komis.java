package samochód;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Komis {

    public List<Samochód> listaSamochodów = new ArrayList<>();
    public Set<Samochód> setSamochodów = new HashSet<>();

    public void dodajSamochód(Samochód samochód) {
        listaSamochodów.add(samochód);
        setSamochodów.add(samochód);
    }

    public void kupionoSamochód(Samochód samochód) {
        if (listaSamochodów.contains(samochód)) {
            int licznik = 0;
            for (Samochód auto : listaSamochodów) {
                if (auto.equals(samochód)) {
                    licznik++;
                }
            }
            if (licznik == 1) {
                setSamochodów.remove(samochód);
            }
            listaSamochodów.remove(samochód);
        }
    }

    public List<Samochód> znajdzSamochodyMarki(String marka) {
        List<Samochód> lista = new ArrayList<>();
        for (Samochód samochód : listaSamochodów) {
            if (samochód.getMarka().equalsIgnoreCase(marka)) {
                lista.add(samochód);
            }
        }
        if (lista.isEmpty()) {
            System.out.println("Nie ma takiegi samochodu w komisie");
        }
        return lista;
    }

    public List<Samochód> znajdzSamochodyMarkiIModelu(String marka, String model) {
        return listaSamochodów.stream()
                .filter(auto -> auto.getMarka().equalsIgnoreCase(marka)
                        && auto.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }

    public List<Samochód> samochodyZPrzedziałuLat(int wiekOd, int wiekDo) {
        List<Samochód> lista = new ArrayList<>();
        if (wiekOd < wiekDo) {
            for (Samochód samochód : listaSamochodów) {
                if (samochód.getRokProdukcji() >= wiekOd
                        && samochód.getRokProdukcji() <= wiekDo) {
                    lista.add(samochód);
                }
            }
            return lista;
        } else {
            System.out.println("Błędne dane wejściowe");
            return lista;
        }
    }

    public List<Samochód> samochodyZPrzedziałuLatStream(int wiekOd, int wiekDo) {
        if (wiekOd < wiekDo) {
            return listaSamochodów.stream()
                    .filter(auto -> auto.getRokProdukcji() >= wiekOd
                            && auto.getRokProdukcji() <= wiekDo).collect(Collectors.toList());
        } else {
            System.out.println("Błędne dane wejściowe");
            return new ArrayList<>();
        }
    }

    public List<Samochód> samochodyDoKwoty(int kwotaMax) {
        List<Samochód> lista = new ArrayList<>();
        for (Samochód samochód : listaSamochodów) {
            if (samochód.getCena() <= kwotaMax) {
                lista.add(samochód);
            }
        }
        return lista;
    }

    public List<Samochód> samochodyDoKwotyStream(int kwotaMax){
        return listaSamochodów.stream().filter(a -> a.getCena()<= kwotaMax)
                .collect(Collectors.toList());
    }

    public void wypiszDostępneSamochody(){
        System.out.println(setSamochodów);
    }


    public static void main(String[] args) {
        Samochód samochód1 = new Samochód("Fiat", "Bravo", 2010, 12000);
        Samochód samochód2 = new Samochód("Jeep", "Renegade", 2017, 40000);
        Samochód samochód3 = new Samochód("Nissan", "Xtrail", 2017, 80000);
        Samochód samochód4 = new Samochód("Renault", "Megane", 2019, 75000);
        Samochód samochód5 = new Samochód("Toyota", "Yaris", 2016, 35000);
        Samochód samochód6 = new Samochód("Toyota", "Yaris", 2016, 30000);
        Samochód samochód7 = new Samochód("Toyota", "Yaris", 2017, 31000);

        Komis komis = new Komis();

        komis.dodajSamochód(samochód1);
        komis.dodajSamochód(samochód2);
        komis.dodajSamochód(samochód3);
        komis.dodajSamochód(samochód4);
        komis.dodajSamochód(samochód5);
        komis.dodajSamochód(samochód6);
        komis.dodajSamochód(samochód7);

        System.out.println("I test: ");
        System.out.println("Lista: " + komis.listaSamochodów);
        System.out.println("Set: " + komis.setSamochodów);

        komis.kupionoSamochód(samochód5);
        System.out.println("II test: ");
        System.out.println("Lista: " + komis.listaSamochodów);
        System.out.println("Set: " + komis.setSamochodów);

        komis.kupionoSamochód(samochód1);
        System.out.println("III test: ");
        System.out.println("Lista: " + komis.listaSamochodów);
        System.out.println("Set: " + komis.setSamochodów);

        System.out.println("IV test: ");
        System.out.println(komis.znajdzSamochodyMarki("Toyota"));

        System.out.println("V test: ");
        System.out.println(komis.znajdzSamochodyMarkiIModelu("Jeep", "Renegade"));

        System.out.println("VI test: ");
        System.out.println(komis.samochodyZPrzedziałuLatStream(2017, 2019));

        System.out.println("VII test: ");
        System.out.println(komis.samochodyDoKwoty(50000));

        System.out.println("VIII test: ");
        System.out.println(komis.samochodyDoKwotyStream(50000));

        System.out.println("IX test: ");
        komis.wypiszDostępneSamochody();

    }

}
