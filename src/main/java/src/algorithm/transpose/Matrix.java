package src.algorithm.transpose;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

import java.util.Scanner;

public class Matrix {
    private final int rows;
    private final int columns;
    private int[][] data;

    public Matrix(int row, int column) {
        this.rows=row;
        this.columns=column;
        data=new int[rows][columns];
    }

    public Matrix(int[][] data) {
        this.data=data;
        this.rows=data.length;
        this.columns=data[0].length;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    /**
     * fills matrix from data entered by user in console * * @param rows * @param columns
     */
    public void read(Scanner s) {
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                data[i][j]=s.nextInt();
            }
        }
    }

    /**
     * This method will transpose this matrix * * @return
     */
    public void transpose() {
        int[][] temp=new int[columns][rows];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                temp[j][i]=data[i][j];
            }
        }
        data=temp;
    }

    /**
     * * @param matrix
     */
    public void print() {
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }
    }
}
