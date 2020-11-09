package top.kindless.sort.utils;

import java.util.Random;

public class SortUtil {
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void show(Comparable[] a){
        for (Comparable comparable : a) {
            System.out.print(comparable+" ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0)
                return false;
        }
        return true;
    }

    public static Integer[] randomIntegerArray(int size){
        Integer[] integers = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            integers[i] = random.nextInt();
        }
        return integers;
    }

    public static Integer[] randomIntegerArray(int size,int min,int max){
        if (max < min)
            throw new RuntimeException("Max number must not less than min number, max number:"+max+", min number:"+min+".");
        Integer[] integers = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            integers[i] = Math.abs(random.nextInt()) % (max - min + 1) + min;
        }
        return integers;
    }

    public static Character[] randomCharacterArray(int size){
        Character[] characters = new Character[size];
        for (int i = 0; i < size; i++) {
            characters[i] = randomChar();
        }
        return characters;
    }

    public static char randomChar(){
        Random random = new Random();
        return (char)((Math.abs(random.nextInt()) % 95) + 33);
    }
}
