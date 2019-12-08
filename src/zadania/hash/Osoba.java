package zadania.hash;

import java.util.Objects;

public class Osoba implements Comparable<Osoba> {

    private String imie;
    private String nazwisko;
    private int wiek;

    public Osoba(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "\n" + "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return wiek == osoba.wiek &&
                Objects.equals(imie, osoba.imie) &&
                Objects.equals(nazwisko, osoba.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, wiek);
    }

    @Override
    public int compareTo(Osoba o) {
      if(getWiek() > o.getWiek()){
          return 1;
      } else if(getWiek() < o.getWiek()){
          return -1;
      } else {
          if (getNazwisko().compareTo(o.getNazwisko()) == 0){
              return getImie().compareTo(o.getImie());
          } else {
              return getNazwisko().compareTo(o.getNazwisko());
          }
      }
    }
}
