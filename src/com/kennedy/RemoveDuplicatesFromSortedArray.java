package com.kennedy;

/**
 * Created by adixith on 12/10/16.
 */
public class RemoveDuplicatesFromSortedArray {
    // {1,1,2,3,3,7}
    public int removeDulpicates(int[] arr) {
        int place = 0;
        for(int i:arr) {
            if(place < 2  || i > arr[place - 2])
                arr[place++] = i;
        }
        return place;
    }

    public static void main(String args[]) {
       System.out.print(new RemoveDuplicatesFromSortedArray().removeDulpicates(new int[]{1,1,2,3,3,7}));
    }
}
