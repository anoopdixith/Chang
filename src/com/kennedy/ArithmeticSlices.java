package com.kennedy;

/**
 * Created by adixith on 12/30/16.
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        int arr[] = new int[]{1,3,5,7,9,10, 15, 17, 19};
        int numBerOfArithmeticSequences = new ArithmeticSlices().findNumberOfArithmeticSequences(arr);
        System.out.println("Number of Arithmetic seq1 are " + numBerOfArithmeticSequences);
        //int numBerOfArithmeticSequencesOptimized = new ArithmeticSlices().findNumberOfArithmeticSequencesOptimized(arr);
        //System.out.println("Number of Arithmetic seq opti are " + numBerOfArithmeticSequencesOptimized);
        int numBerOfArithmeticSequencesRight = new ArithmeticSlices().numberOfArithmeticSlices(arr);
        System.out.println("Number of Arithmetic seq1 are " + numBerOfArithmeticSequencesRight);
    }

    private int findNumberOfArithmeticSequences(int[] arr) {
        int count = 0;
        for(int i=0; i < arr.length-2; i++) {
            int j = i;
            while(j < arr.length - 2 && arr[j+1] - arr[j] == arr[j+2] - arr[j+1]) {
                count++;
                j++;
            }
        }
        return count;
    }

    private int findNumberOfArithmeticSequencesOptimized(int[] arr) {
        int count = 0;
        int j;
        for (int i = 0; i < arr.length - 2;) {
            j = i;
            while (j < arr.length - 2 && arr[j + 1] - arr[j] == arr[j + 2] - arr[j + 1]) {
                count++;
                j++;
            }
            if(j > i) {
                count += (j - i - 2);
            }
            i = j+1;
        }
        return count;
    }

    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }
}
