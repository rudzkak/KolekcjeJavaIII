import java.util.Objects;

public class Produkt {

    private final String nazwa;
    private final int waga;

    public Produkt(String nazwa, int waga){
        this.nazwa = nazwa;
        this.waga = waga;
    }

    public String getNazwa(){
        return nazwa;
    }

    public int getWaga(){
        return waga;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", waga=" + waga +
                '}';
    }

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
}
