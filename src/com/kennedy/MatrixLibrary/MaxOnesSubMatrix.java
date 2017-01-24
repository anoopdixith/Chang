package com.kennedy.MatrixLibrary;

/**
 * Created by adixith on 12/28/16.
 */
public class MaxOnesSubMatrix {
    public static void main(String args[]) {
        int rows = 10;
        int columns = 10;
        int[][] matrix = MatrixUtility.biasedBinaryMatrix(rows,columns, 80);
        MatrixUtility.print2DMatrix(matrix);
        new MaxOnesSubMatrix().findMaxOnesSubMatrix(matrix);
    }

    private void findMaxOnesSubMatrix(int[][] matrix) {
        int[][] maxHere =  new int[matrix.length][matrix[0].length];
        for(int i=0; i < matrix.length; i++) {
            maxHere[i][0] = matrix[i][0];
            maxHere[0][i] = matrix[0][i];
        }
        for(int i=1; i < matrix.length; i++) {
            for(int j=1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    maxHere[i][j] = 1 + Math.min(Math.min(maxHere[i-1][j], maxHere[i][j-1]), maxHere[i-1][j-1]);
                }
                else {
                    maxHere[i][j] = 0;
                }
            }
        }
        MatrixUtility.print2DMatrix(maxHere);
    }
}
