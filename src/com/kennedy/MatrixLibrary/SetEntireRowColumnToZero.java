package com.kennedy.MatrixLibrary;

/**
 * Created by adixith on 12/28/16.
 */
public class SetEntireRowColumnToZero {
    public static void main(String args[]) {
        int rows = 10;
        int columns = 10;
        int[][] matrix = MatrixUtility.sampleMatrix(rows,columns);
        MatrixUtility.print2DMatrix(matrix);
        for(int i =0; i < 11; i++) {
            int randomRow = (int)(Math.random()*rows);
            int randomColumn = (int)(Math.random()*rows);
            matrix[randomRow][randomColumn] = 0;
        }
        MatrixUtility.print2DMatrix(matrix);
        matrix = new SetEntireRowColumnToZero().setEntireRowColumnZero(matrix);
        MatrixUtility.print2DMatrix(matrix);
    }

    private int[][] setEntireRowColumnZero(int[][] matrix) {

        return matrix;
    }
}
