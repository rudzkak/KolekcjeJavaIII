package mapy;

public interface PrzeglądProduktów {

    void dodajProdukt(Produkt produkt);
    Produkt znajdzPoId(int id);
    void wyczyść();

}
