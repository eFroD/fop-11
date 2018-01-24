package matrix;

import java.util.LinkedList;

public class Matrix <T extends Comparable<T>> {
    private Arithmetic<T> arithmetic;
    private LinkedList<LinkedList<T>> data;
    private LinkedList<T> tempList;
    private Matrix neueMat;
    private int rows, columns;
    protected T tempNum;

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
        Matrix<T> neueMat = new Matrix<T>(rows, other.getColumns(), arithmetic);
        if (columns == other.getRows()){
            for(int x = 0; x < rows; x++){
                for(int y = 0; y < other.getColumns(); y++){
                    tempNum = arithmetic.zero();
                    for (int z = 0; z < columns; z++){
                        tempNum = arithmetic.add(tempNum, arithmetic.mul(this.getCell(x,z), (other.getCell(z,y))));
                        neueMat.setCell(x ,y ,tempNum);
                    }
                }
            } return neueMat;
        } else return null;
    }

    public Matrix<T> transpose(){

    }

    public T getMinMax(boolean min){
        for(int x = 0; x < rows; x++){
            for(int y = 0; y < getColumns(); y++) {
                tempList.add(this.getCell(x,y));
            }
        }

        if (min) {
            for(int i = 0; i < rows; i++){
                if(tempList.get(i).compareTo(tempNum) < 0){
                    tempNum = tempList.get(i);
                }
            }
            return tempNum;
        }

        else {
            for(int i = 0; i < rows; i++){
                if(tempList.get(i).compareTo(tempNum) > 0){
                    tempNum = tempList.get(i);
                }
            }
            return tempNum;
        }
    }

    public Matrix<T> resize(int rows, int columns){

    }
}
