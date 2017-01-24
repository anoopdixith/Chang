package com.kennedy.MatrixLibrary;

/**
 * Created by adixith on 12/29/16.
 */
public class MatrixSpiral {
    public static void main(String args[]) {
        int rows = 4;
        int columns = 4;
        int[][] matrix = MatrixUtility.sampleMatrix(rows,columns);
        MatrixUtility.print2DMatrix(matrix);
        new MatrixSpiral().printSpiral(matrix);
    }

    private void printSpiral(int[][] matrix) {
        int[] flatten = new int[matrix.length * matrix[0].length];
        int k = 0;
        for(int i=0; i < matrix.length; i++) {
            for(int j=0; j < matrix[0].length; j++)
                flatten[k++] = matrix[i][j];
        }

        int rowsLimit = matrix.length - 1;
        int columnsLimit = matrix[0].length - 1;
        k =0;
        int layer = 0;
        while(layer <= (rowsLimit+1)/2) {
            for (int i = layer; i <= columnsLimit - layer; i++) {
                matrix[layer][i] = flatten[k++];
            }
            for (int i = layer + 1; i <= rowsLimit - layer; i++) {
                matrix[i][columnsLimit - layer] = flatten[k++];
            }
            for (int i = columnsLimit - 1 - layer; i >= layer; i--) {
                matrix[rowsLimit - layer][i] = flatten[k++];
            }
            for (int i = rowsLimit - 1 - layer; i >= 1 + layer; i--) {
                matrix[i][layer] = flatten[k++];
            }
            layer+=1;
        }
        MatrixUtility.print2DMatrix(matrix);
    }

}
