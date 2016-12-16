package com.kennedy;

/**
 * Created by adixith on 10/30/16.
 */
public class KnuthShuffle {
    private int[] shuffle(int[] array) {
        for(int i=0; i < array.length; i++) {
            int j = new java.util.Random().nextInt(array.length - i);
            swap(array, i, j);
        }
        return array;
    }

    private int[] swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    public static void main(String a[]) {
        int[] arr = new KnuthShuffle().shuffle(new int[]{1,2,3,4,5});
        for(int i:arr) {
            //System.out.print(i);
        }
        System.out.println(new KnuthShuffle().randomInt(300,700));
    }

    private int randomInt(int min, int max) {
        return (new java.util.Random().nextInt(max - min + 1) + min);
    }
}
