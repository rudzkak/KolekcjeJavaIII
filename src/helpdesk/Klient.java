package helpdesk;

import biblioteka.Książka;

import java.util.Objects;

public class Klient {

    private String imie;
    private String plec;

    public Klient(String imie, String plec) {
        this.imie = imie;
        this.plec = plec;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klient klient = (Klient) o;
        return Objects.equals(imie, klient.imie) &&
                Objects.equals(plec, klient.plec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, plec);
    }

    @Override
    public String toString() {
        return "Klient{" +
                "imie='" + imie + '\'' +
                ", plec='" + plec + '\'' +
                '}';
    }

    public void odpowiedź(String wiadomość){
        System.out.println(imie + ":" + wiadomość);
    }

    public static final Klient JACEK = new Klient("Jacek", "M");
    public static final Klient AGNIESZKA = new Klient("Agnieszka", "K");
    public static final Klient AGATA = new Klient("Agata", "K");
}
