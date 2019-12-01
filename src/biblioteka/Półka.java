package biblioteka;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Półka {

    private int numerPółki;
    private List<Książka> listaKiążek;

    public Półka(int numerPółki) {
        this.numerPółki = numerPółki;
        this.listaKiążek = new ArrayList<>();
    }

    public int getNumerPółki() {
        return numerPółki;
    }

    public void setNumerPółki(int numerPółki) {
        this.numerPółki = numerPółki;
    }

    public List<Książka> getListaKiążek() {
        return listaKiążek;
    }

    public void setListaKiążek(List<Książka> listaKiążek) {
        this.listaKiążek = listaKiążek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Półka półka = (Półka) o;
        return numerPółki == półka.numerPółki &&
                Objects.equals(listaKiążek, półka.listaKiążek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerPółki, listaKiążek);
    }

    @Override
    public String toString() {
        return "Półka{" +
                "numerPółki=" + numerPółki +
                ", listaKiążek=" + listaKiążek +
                '}';
    }
}
