package algorytmy.quicksortZadanie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort {

    List<Osoba> listaOsob = new ArrayList<>();
    private int rozmiar;

    public void sort(List<Osoba> lista){

        if(lista == null || lista.size() == 0){
            return;
        }

        this.listaOsob = lista;
        this.rozmiar = lista.size();

        quicksort(0, rozmiar -1);
    }

    public void quicksort(int mniejszyIndeks, int wiekszyIndeks){

        int i = mniejszyIndeks;
        int j = wiekszyIndeks;

        int pivotIndeks = mniejszyIndeks + (wiekszyIndeks - mniejszyIndeks)/2;
        Osoba pivot = listaOsob.get(pivotIndeks);

        while (i<=j){

            while (listaOsob.get(i).compareTo(pivot) < 0){
                i++;
            }

            while (listaOsob.get(j).compareTo(pivot) > 0){
                j--;
            }

            if(i<=j){
                zamienOsoby(i, j);
                i++;
                j--;
            }
        }

        if(mniejszyIndeks<j){
            quicksort(mniejszyIndeks,j);
        }
        if(i<wiekszyIndeks){
            quicksort(i, wiekszyIndeks);
        }
    }

    public void zamienOsoby(int i, int j){
        Osoba temp = listaOsob.get(i);
        listaOsob.set(i, listaOsob.get(j));
        listaOsob.set(j, temp);
    }

    public static void main(String[] args) {

        Osoba osoba1 = new Osoba("Janek", 1991);
        Osoba osoba2 = new Osoba("Stefan", 1876);
        Osoba osoba3 = new Osoba("Krystian", 2010);
        Osoba osoba4 = new Osoba("Jan", 1990);

        List<Osoba> lista = new ArrayList<>();

        Collections.addAll(lista, osoba1, osoba2, osoba3, osoba4);
        lista.forEach(System.out::println);

        System.out.println("------");

        QuickSort quickSort = new QuickSort();
        quickSort.sort(lista);
        lista.forEach(System.out::println);
    }
}
