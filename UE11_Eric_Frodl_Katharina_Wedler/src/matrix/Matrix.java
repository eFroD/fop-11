package matrix;

import java.util.LinkedList;

public class Matrix <T extends Comparable<T>> {
    private Arithmetic<T> arithmetic;
    private LinkedList<LinkedList<T>> data;
    private int rows, columns;

    public Matrix(int rows, int columns, Arithmetic<T> arithmetic){
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() return rows;
    public int getColumns() return columns;
    public T getCell(int row, int column){}
    public void setCell(int row, int column, T value){}



























    public Matrix<T> add(Matrix<T> other){
        if (other.getColumns() == columns && other.getRows() == rows){

        } else return null;
    }

    public Matrix<T> mul(Matrix<T> other){
        if (columns == other.getRows()){
            for(int x = 1; x < getRows(); x++){
                for(int y = 1; y < other.getColumns(); y++){

                }
            }
        } else return null;
    }

    public Matrix<T> transpose(){

    }

    public T getMinMax(boolean min){

    }

    public Matrix<T> resize(int rows, int columns){

    }
}
