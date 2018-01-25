package matrix;

import java.util.Collections;
import java.util.LinkedList;


/**
 * This class implements several methods to process matrices
 * @param <T>
 *          the type of the matrix
 *
 * @author Eric Frodl, Katharina Wedler
 */

public class Matrix <T extends Comparable<T>> {
    private Arithmetic<T> arithmetic;
    private LinkedList<LinkedList<T>> data;
    private LinkedList<T> colList, tempList;
    private Matrix newMat;
    private int rows, columns;
    protected T tempNum, tempNum2;


    /**
     * The constructor creates a new matrix and fills it with zero. Which zero is used, depends
     * on the type of the matrix.
     * @param rows
     *          the amount of rows the matrix will have
     * @param columns
     *          this defines the amount of columns of the matrix
     * @param arithmetic
     *          sets the arithmetic to be used. The arithmetic depends on the type and is implemented
     *          in {@link FloatArithmetic} and {@link IntegerArithmetic}
     */
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

    /**
     * this function delivers the amount of rows the matrix has
     * @return the amount of rows
     */
    public int getRows(){
        return rows;
    }

    /**
     * columns represent the second dimension of the matrix
     * @return the amount of columns in that matrix
     */
    public int getColumns(){
        return columns;
    }

    /**
     * given the coordinates, this function returns the contend of a cell in a matrix.
     * @param row
     *          the value of the row of the matrix, where the content is stored
     * @param column
     *          the column, to navigate within the given row, in order to finally get the content of the cell
     * @return the content of  the cell after it is identified
     */
    public T getCell(int row, int column){
        return data.get(row).get(column);
    }
    public void setCell(int row, int column, T value){
        data.get(row).set(column,value);

    }

    /**
     * this is an addition method, which builds the sum of the given matrix and a passed one.
     * @param other
     *          the matrix, the given matrix should be added with
     * @return  a matrix, representing the sum of the two matrices
     */
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

    /**
     * this stands for a matrix-multiplication
     * @param other the matrix, which should be multiplied with the given one
     * @return the product matrix of the two matrices
     */
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

    /**
     * transposes the given matrix analog to the mathematical transpose of matrices
     * @return the transposed matrix
     */
    public Matrix<T> transpose(){

        newMat = new Matrix<T>(this.getColumns(),this.getRows(),arithmetic);
        for (int i = 0; i < newMat.getRows() ;i++){
            for (int j = 0; j < newMat.getColumns(); j++){
                newMat.setCell(i,j,this.getCell(j,i));

            }
        }return newMat;
    }

    /**
     * determines the minimum or the maximum value, stored in a matrix
     * @param min
     *          min represents the decision whether the minimum or the maximum value of the matrix
     *          should be returned
     * @return if min is true, it returns the minimum value, if false the maximum value of the matrix
     */
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

    /**
     * resize a matrix to be bigger or smaller, depending on the following parameters
     * @param rows
     *          represents how many rows should be added or removed. if the value is positive the rows will be added
     *          to the bottom of the matrix, if negative, the bottom rows will be removed for the given amount
     * @param columns
     *          analog to rows for the columns, if positive, the columns will be added, else the the columns will be deleted.
     * @return the resized matrix. if rows or columns were added, the values will be set to zero.
     */
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

    /**
     * compares all values of a matrix with the values of another matrix
     * @param matrix
     *          the matrix, which should be compared with the given one.
     * @return true, if the two matrices are equal, false if a value differs
     */
    public boolean compareMatrix(Matrix<T> matrix){
        if (this.getRows() == matrix.getRows() && this.getColumns() == matrix.getColumns()) {
            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0; j < this.getColumns(); j++) {

                    if (this.getCell(i, j).compareTo(matrix.getCell(i, j)) != 0) {
                        return false;
                    }

                }
            }
            return true;
        }else return false;
    }

    /**
     * for testing, this method fills a matrix with a value
     * @param temp
     *          the value, that should be filled into the matrix
     */
    public void fill(T temp){

        for (int i=0; i< this.getRows(); i++){
            for (int j = 0; j< this.getColumns();j++){
                this.setCell(i,j,temp);

            }
        }
    }


}
