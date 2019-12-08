package katalog;

public class KatalogProduktówTest {

    public static Produkt drzwi = new Produkt("drzwi dębowe", 30);
    public static Produkt okno = new Produkt("okno dębowe", 40);
    public static Produkt panel = new Produkt("panel dębowy", 5);
    public static Produkt deska = new Produkt("deska", 5);

    public static Dostawca jan = new Dostawca("U Jana");
    public static Dostawca zosia = new Dostawca("Drewno Zosi");

    static {
        jan.getListaProduktów().add(drzwi);
        jan.getListaProduktów().add(drzwi);
        jan.getListaProduktów().add(drzwi);
        jan.getListaProduktów().add(okno);
        jan.getListaProduktów().add(okno);
        jan.getListaProduktów().add(panel);
        jan.getListaProduktów().add(new Produkt("drzwi dębowe", 30));

        zosia.getListaProduktów().add(panel);
        zosia.getListaProduktów().add(panel);
        zosia.getListaProduktów().add(deska);
        zosia.getListaProduktów().add(deska);
        zosia.getListaProduktów().add(deska);
    }

    public static void main(String[] args) {

        KatalogProduktów katalogProduktów = new KatalogProduktów();

        katalogProduktów.zapewnianyPrzez(jan);
        System.out.println("lista" + katalogProduktów.listaProduktów);
        System.out.println("set" + katalogProduktów.setProduktów);
        System.out.println("Mały van: ");
        System.out.println(katalogProduktów.produktyMalyVan());
        System.out.println("Duży van: ");
        System.out.println(katalogProduktów.produktyDuzyVan());
    }
}
