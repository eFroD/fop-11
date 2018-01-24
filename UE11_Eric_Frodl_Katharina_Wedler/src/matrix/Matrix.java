package matrix;

import java.util.Collections;
import java.util.LinkedList;

public class Matrix <T extends Comparable<T>> {
    private Arithmetic<T> arithmetic;
    private LinkedList<LinkedList<T>> data;
    private LinkedList<T> colList, tempList;
    private Matrix newMat;
    private int rows, columns;
    protected T tempNum, tempNum2;

    public Matrix(int rows, int columns, Arithmetic<T> arithmetic){
        this.rows = rows;
        this.columns = columns;
        this.arithmetic = arithmetic;
        data = new LinkedList<>();

        for (int i=0; i < rows; i++){
            colList = new LinkedList<>();
            for (int j=0; j <columns; j++){
                colList.add(j, arithmetic.zero());
            }data.add(i,colList);
        }
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
        data.get(row).set(column,value);

    }

    public Matrix<T> add(Matrix<T> other){
        if (other.getColumns() == columns && other.getRows() == rows){
            newMat =new Matrix<>(rows,columns,arithmetic);
            for(int i=0; i < getRows(); i++){
                for (int j=0; j < getColumns(); j++){
                    newMat.setCell(i, j, arithmetic.add(this.getCell(i,j), (other.getCell(i,j))));
                }
            }return newMat;
        } else return null;
    }

    public Matrix<T> mul(Matrix<T> other){
        Matrix<T> newMat = new Matrix<T>(rows, other.getColumns(), arithmetic);
        if (columns == other.getRows()){
            for(int x = 0; x < rows; x++){
                for(int y = 0; y < other.getColumns(); y++){
                    tempNum = arithmetic.zero();
                    for (int z = 0; z < columns; z++){
                        tempNum = arithmetic.add(tempNum, arithmetic.mul(this.getCell(x,z), (other.getCell(z,y))));
                        newMat.setCell(x ,y ,tempNum);
                    }
                }
            } return newMat;
        } else return null;
    }

    public Matrix<T> transpose(){

        newMat = new Matrix<T>(this.getColumns(),this.getRows(),arithmetic);
        for (int i = 0; i < newMat.getRows() ;i++){
            for (int j = 0; j < newMat.getColumns(); j++){
                newMat.setCell(i,j,this.getCell(j,i));

            }
        }return newMat;
    }

    public T getMinMax(boolean min){
        tempList = new LinkedList<>();
        for(int x = 0; x < getRows(); x++){
            for(int y = 0; y < getColumns(); y++) {
                tempList.add(this.getCell(x,y));
            }
        }
        Collections.sort(tempList);
        if (min){
            return tempList.getFirst();
        }else return tempList.getLast();


    }

    public Matrix<T> resize(int rows, int columns){
        newMat = new Matrix<T>(this.getRows() + rows, this.getColumns() + columns, arithmetic);

            for (int i= 0; i<newMat.getRows();i++){
                for (int j = 0; j < newMat.getColumns(); j++){
                    if (i >= this.getRows() || j >=this.getColumns()){
                        newMat.setCell(i,j,arithmetic.zero());}
                    else newMat.setCell(i,j,this.getCell(i,j));
                }
            }return newMat;
    }

    public boolean compareMatrix(Matrix<T> matrix){
        for (int i=0; i <this.getRows(); i++){
            for (int j = 0; j < this.getColumns();j++){
                if (this.getCell(i,j).compareTo(matrix.getCell(i,j)) !=0){
                    return false;
                }
            }
        }return true;
    }

    public void fillInt(T temp){

        for (int i=0; i< this.getRows(); i++){
            for (int j = 0; j< this.getColumns();j++){
                this.setCell(i,j,temp);
                arithmetic.add(temp,temp);
            }
        }
    }
   
}
