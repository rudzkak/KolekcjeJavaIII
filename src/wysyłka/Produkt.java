package wysyłka;

import java.util.Comparator;
import java.util.Objects;

public class Produkt {

    private String nazwa;
    private int waga;

    public Produkt(String nazwa, int waga) {
        this.nazwa = nazwa;
        this.waga = waga;
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }

//    public static final Comparator<katalog.Produkt> BY_WAGA =
//            new Comparator<katalog.Produkt>() {
//                @Override
//                public int compare(katalog.Produkt o1, katalog.Produkt o2) {
//                    return Integer.compare(o1.getWaga(), o2.getWaga());
//                }
//            }
//
    public static final Comparator<Produkt> BY_WAGA =
            Comparator.comparing(produkt -> produkt.getWaga());

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produkt produkt = (Produkt) o;
        return waga == produkt.waga &&
                Objects.equals(nazwa, produkt.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, waga);
    }

    @Override
    public String toString() {
        return "katalog.Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", waga=" + waga +
                '}';
    }
}
