package com.kennedy.MatrixLibrary;

/**
 * Created by adixith on 12/28/16.
 */
public class RotateMatrixBy90 {

    /*
    1 2 3 4
    5 6 7 8
    9 10 11 12
    13 14 15 16

    to

    13 9 5 1
    14 10 6 2
    15 11 7 3
    16 12 8 4

    (0,1) -> (2,0)
    (2,0) -> (3,2)
    (3,2) -> (1,3)
     */
    public int[][] rotateby90AnotheWay(int[][] matrix) {
        MatrixUtility.print2DMatrix(matrix);
        for(int i=0; i < matrix.length/2; i++) {
            for(int j=0; j < matrix[0].length/2; j++) {
                // i = 0; j = 1; temp = 2, &2 = 9, &9  = 15, &15 = 8, &8 = 2
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;
            }
        }
        MatrixUtility.print2DMatrix(matrix);
        return matrix;
    }

    public int[][] rotateMatrix(int[][] matrix, int degrees) {
        MatrixUtility.print2DMatrix(matrix);
        matrix = MatrixUtility.transpose(matrix);
        MatrixUtility.print2DMatrix(matrix);
        return matrix;
    }

    public static void main(String args[]) {
        int matrix[][] = new int[4][4];
        int k=1;
        for(int i=0; i <matrix.length; i++) {
            for(int j=0; j < matrix[0].length; j++) {
                matrix[i][j] = k++;
            }
        }
        //MatrixUtility.print2DMatrix(matrix);
        //matrix = new RotateMatrixBy90().rotateMatrix(matrix, 90);
        matrix = new RotateMatrixBy90().rotateby90AnotheWay(matrix);
        //MatrixUtility.print2DMatrix(matrix);
    }
}
