package com.kennedy.MatrixLibrary;

/**
 * Created by adixith on 12/28/16.
 */
public class MatrixUtility {
    public static void print2DMatrix(int[][] matrix) {
        for(int i=0; i < matrix.length; i++) {
            for(int j=0; j < matrix[0].length;j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] transpose(int[][] matrix) {
        for(int i=0; i < matrix.length/2; i++) {
            for(int j=i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

    public static int[][] sampleMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        int k = 1;
        for(int i=0; i <matrix.length; i++) {
            for(int j=0; j < matrix[0].length; j++) {
                matrix[i][j] = k++;
            }
        }
        return matrix;
    }

    public static int[][] sampleBinaryMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        for(int i=0; i <matrix.length; i++) {
            for(int j=0; j < matrix[0].length; j++) {
                matrix[i][j] = (int)(Math.random()*2);
            }
        }
        return matrix;
    }

    public static int[][] biasedBinaryMatrix(int m, int n, double biasPercent) {
        int[][] matrix = new int[m][n];
        for(int i=0; i <matrix.length; i++) {
            for(int j=0; j < matrix[0].length; j++) {
                if(Math.random() < biasPercent/100)
                    matrix[i][j] = 1;
                else
                    matrix[i][j] = 0;
            }
        }
        return matrix;
    }
}
