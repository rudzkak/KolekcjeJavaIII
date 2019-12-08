package zadania;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class zad3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> imiona = new HashSet<>();

        System.out.println("Podaj imiona oddzielone spacją");
        String [] tablicaImion = scanner.nextLine().split("\\s+");

        if(tablicaImion[0].equals("") && tablicaImion.length ==1){
            System.out.println("Lista jest pusta");
        } else{
            for(int i=0; i<tablicaImion.length; i++){
                imiona.add(tablicaImion[i]);
            }
        }
        System.out.println(imiona);

    }

}
