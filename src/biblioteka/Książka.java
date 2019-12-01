package biblioteka;

import java.util.Objects;

public class Książka {

    private String autor;
    private String tytuł;

    public Książka(String autor, String tytuł) {
        this.autor = autor;
        this.tytuł = tytuł;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTytuł() {
        return tytuł;
    }

    public void setTytuł(String tytuł) {
        this.tytuł = tytuł;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Książka książka = (Książka) o;
        return Objects.equals(autor, książka.autor) &&
                Objects.equals(tytuł, książka.tytuł);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, tytuł);
    }

    @Override
    public String toString() {
        return "Książka{" +
                "autor='" + autor + '\'' +
                ", tytuł='" + tytuł + '\'' +
                '}';
    }
}
