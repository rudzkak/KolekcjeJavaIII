package sklepzoologiczny;

import java.util.Objects;

public class Zamówienie {

    private Zwierzę zwierzę;
    private int ilosc;

    public Zamówienie(Zwierzę zwierzę, int ilosc) {
        this.zwierzę = zwierzę;
        this.ilosc = ilosc;
    }

    public Zwierzę getZwierzę() {
        return zwierzę;
    }

    public void setZwierzę(Zwierzę zwierzę) {
        this.zwierzę = zwierzę;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zamówienie that = (Zamówienie) o;
        return ilosc == that.ilosc &&
                Objects.equals(zwierzę, that.zwierzę);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zwierzę, ilosc);
    }

    @Override
    public String toString() {
        return "Zamówienie{" +
                "zwierzę=" + zwierzę +
                ", ilosc=" + ilosc +
                '}';
    }
}
