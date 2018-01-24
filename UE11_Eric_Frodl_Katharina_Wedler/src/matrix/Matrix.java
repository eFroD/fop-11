package matrix;

import java.util.LinkedList;

public class Matrix <T extends Comparable<T>> {
    private Arithmetic<T> arithmetic;
    private LinkedList<LinkedList<T>> data;
    private int rows, columns;

    public Matrix(int rows, int columns, Arithmetic<T> arithmetic){
        this.rows = rows;
        this.columns = columns;
        this.arithmetic = arithmetic;
    }

    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }
    public T getCell(int row, int column){
        return data.get(row).get(column);
    }
    public void setCell(int row, int column, T value){
        data.get(row).set(column, value);
    }


    
    public Matrix<T> add(Matrix<T> other){
        if (other.getColumns() == columns && other.getRows() == rows){
            Matrix<T> tempMatrix =new Matrix<>(rows,columns,arithmetic);
            for(int i=0; i < rows; i++){
                for (int j=0; j < columns; j++){
                    tempMatrix.setCell(i, j, arithmetic.add(this.getCell(i,j), (other.getCell(i,j)));
                }
            }return tempMatrix;
        } else return null;
    }

    public Matrix<T> mul(Matrix<T> other){
        if (columns == other.getRows()){
            for(int x = 0; x < other.getRows(); x++){
                for(int y = 0; y < other.getColumns(); y++){

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
