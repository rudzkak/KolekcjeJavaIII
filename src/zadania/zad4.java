package zadania;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class zad4 {

    public static void main(String[] args) {

        Queue<Double> kolejka = new PriorityQueue<>();

        Random random = new Random(10);

        do{
            kolejka.offer(random.nextDouble());
        } while (kolejka.size() < 20);

        while (kolejka.peek() != null){
            System.out.println(kolejka.poll());
        }
    }
}
