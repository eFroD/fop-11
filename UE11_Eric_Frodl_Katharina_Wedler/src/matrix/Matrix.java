package matrix;

public class Matrix <T extends Comparable<T>> {
    private Arithmetic<T> arithmetic;
    private LikedList<LinkedList<T>> data;
    private int rows, columns;

    public Matrix(int rows, int columns, Arithmetic<T> arithmetic){
        rows = this.rows;
        columns = this.columns;
    }

    public int getRows() return rows;
    public int getColumns() return columns;
    public T getCell(int row, int column){}
    public void setCell(int row, int column, T value){}




    //ICh hab schon was geschreiebne
}
