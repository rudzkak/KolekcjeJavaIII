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
}
