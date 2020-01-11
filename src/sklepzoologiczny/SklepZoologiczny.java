package sklepzoologiczny;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SklepZoologiczny {

    private List<Zwierzę> lista = new ArrayList<>();
    private Set<Zwierzę> kataolg = new HashSet<>();

    public void dodajZwierze(Zwierzę zwierzę){
        lista.add(zwierzę);
        kataolg.add(zwierzę);
    }

    public void kupionoZwierze(Zwierzę zwierzę){
        if(lista.contains(zwierzę) && kataolg.contains(zwierzę)){
            int licznik = 0;
            for(Zwierzę zwierz : lista){
                if(zwierz.equals(zwierzę)){
                    licznik++;
                }
            }
            if(licznik == 1){
                kataolg.remove(zwierzę);
            }

            lista.remove(zwierzę);
        }
    }

    public List<Zwierzę> znajdzRodzaj(Rodzaj rodzaj){
        return lista.stream()
                .filter(zwierzę -> zwierzę.getRodzaj().equals(rodzaj))
                .collect(Collectors.toList());
    }

    public List<Zwierzę> znajdzGatunek(String gatunek){
        return lista.stream()
                .filter(zwierzę -> zwierzę.getGatunek().equals(gatunek))
                .collect(Collectors.toList());
    }

    public void wypiszZKataloguOprocz(String gatunek){
        for(Zwierzę zwierzę : kataolg){
            if(!zwierzę.getGatunek().equals(gatunek)){
                System.out.println(zwierzę);
            }
        }
    }
    public void wypiszZKataloguStream(String gatunek){
        kataolg.stream()
                .filter(zwierzę -> !zwierzę.getGatunek().equals(gatunek))
                .forEach(System.out :: println);
    }

    public long liczbaDostepnychZwierzat(String gatunek){
        return kataolg.stream()
                .filter(zwierzę -> zwierzę.getGatunek().equals(gatunek))
                .count();
    }

    public int obliczWartoscZamowienia(Zamówienie zamówienie){
        return zamówienie.getIlosc() * zamówienie.getZwierzę().getCena();
    }

    public static void main(String[] args) {

        Zwierzę zwierzę1 = new Zwierzę(Rodzaj.SSSAK, "pies", 550);
        Zwierzę zwierzę2 = new Zwierzę(Rodzaj.SSSAK, "pies", 550);
        Zwierzę zwierzę3 = new Zwierzę(Rodzaj.SSSAK, "pies", 550);
        Zwierzę zwierzę4 = new Zwierzę(Rodzaj.PŁAZ, "żaba", 35);
        Zwierzę zwierzę5 = new Zwierzę(Rodzaj.RYBA, "złota rybka", 50);
        Zwierzę zwierzę6 = new Zwierzę(Rodzaj.RYBA, "złota rybka", 50);

        SklepZoologiczny sklepZoologiczny = new SklepZoologiczny();

        sklepZoologiczny.dodajZwierze(zwierzę1);
        sklepZoologiczny.dodajZwierze(zwierzę2);
        sklepZoologiczny.dodajZwierze(zwierzę3);
        sklepZoologiczny.dodajZwierze(zwierzę4);
        sklepZoologiczny.dodajZwierze(zwierzę5);
        sklepZoologiczny.dodajZwierze(zwierzę6);

        System.out.println("I test: lista " + sklepZoologiczny.lista);
        System.out.println();
        System.out.println("I test: katalog " + sklepZoologiczny.kataolg);

        System.out.println();

        sklepZoologiczny.kupionoZwierze(zwierzę1);
        System.out.println("II test: lista " + sklepZoologiczny.lista);
        System.out.println("II test: katalog " + sklepZoologiczny.kataolg);

        System.out.println();

        System.out.println("III test: po rodzaju " + sklepZoologiczny.znajdzRodzaj(Rodzaj.RYBA));

        System.out.println();
        System.out.println("IV test: po gatunku " + sklepZoologiczny.znajdzGatunek("pies"));


        System.out.println();

        System.out.println("V test: " );
        sklepZoologiczny.wypiszZKataloguOprocz("pies");

        System.out.println();
        System.out.println("VI test: ");
        sklepZoologiczny.wypiszZKataloguStream("pies");

        System.out.println();
        System.out.println("VII test: " + sklepZoologiczny.liczbaDostepnychZwierzat("pies"));

        Zamówienie zamówienie = new Zamówienie(zwierzę2, 2);
        System.out.println();
        System.out.println("VIII test: "
                + sklepZoologiczny.obliczWartoscZamowienia(zamówienie));

    }
}
