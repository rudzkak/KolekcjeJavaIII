package zadania;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zad1 {

    public static int PUSTA_LISTA = 1;

    public static void main(String[] args) {


        System.out.println("Podaj ciąg liczb oddzielonych spacją");

        Scanner scanner = new Scanner(System.in);
        List<Integer> ciagLiczb = new ArrayList<>();

        String[] ciąg = scanner.nextLine().split("\\s+");

        if (ciąg.length == PUSTA_LISTA && ciąg[0].equals("")) {
            System.out.println("Brak elementów w ciągu");
        } else {

            for (int i = 0; i < ciąg.length; i++) {
                ciagLiczb.add(Integer.parseInt(ciąg[i]));
            }

            int sumaDodatnich = 0;
            int sumaUjemnych = 0;
            int sumaCałkowita = 0;
            int liczbaDodatnich = 0;
            int liczbaUjemnych = 0;

            for (Integer liczba : ciagLiczb) {
                if (liczba > 0) {
                    sumaDodatnich += liczba;
                    liczbaDodatnich += 1;
                } else if (liczba < 0) {
                    sumaUjemnych += liczba;
                    liczbaUjemnych += 1;
                }

                sumaCałkowita += liczba;
            }

            System.out.println("Suma liczb dodatnich: " + sumaDodatnich);
            System.out.println("Suma liczb ujemnych: " + sumaUjemnych);
            System.out.println("Suma całkowita: " + sumaCałkowita);
            System.out.println("Liczba dodatnich: " + liczbaDodatnich);
            System.out.println("Liczba ujemnych: " + liczbaUjemnych);

        }
    }

}
