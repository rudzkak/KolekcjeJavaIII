package zadania;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class zad2 {

    public static void main(String[] args) {

        List<Integer> lista = new LinkedList<>();
        Random random = new Random();

        do{
            lista.add(lista.size()/2, random.nextInt(10));
            System.out.println(lista);
        } while (lista.size() <20);
    }
}
