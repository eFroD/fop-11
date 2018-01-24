package matrix;

import java.util.LinkedList;

public class Matrix <T extends Comparable<T>> {
    private Arithmetic<T> arithmetic;
    private LinkedList<LinkedList<T>> data;
    private Matrix neueMat;
    private int rows, columns, tempNum;

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
        neueMat = new Matrix<T>(getRows(), other.getColumns(), arithmetic);
        if (columns == other.getRows()){
            for(int x = 0; x < getRows(); x++){
                for(int y = 0; y < other.getColumns(); y++){
                    tempNum = 0;
                    for (int z = 0; z < getColumns(); z++){
                        tempNum += mul((getCell(x,z), other.getCell(z,y));
                        neueMat.setCell(x ,y ,tempNum);
                    }
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
