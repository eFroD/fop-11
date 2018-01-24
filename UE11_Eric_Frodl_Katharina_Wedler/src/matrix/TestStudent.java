package matrix;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * tests for the exercise
 * @author Eric Frodl, Katharina Wedler
 *
 */

public class TestStudent {

    IntegerArithmetic xint = new IntegerArithmetic();
    FloatArithmetic xfloat = new FloatArithmetic();

    @Test
    public void testMatrix(){
        Matrix mat1 = new Matrix(2, 2, xint);
        assertEquals(2, mat1.getRows());
        assertEquals(2, mat1.getColumns());
    }

    @Test
    public void testGetCell(){
        Matrix mat1 = new Matrix(2, 2, xint);
        mat1.setCell(1,1,3);
        assertEquals(3, mat1.getCell(1,1));
    }

    @Test
    public void testSetCell(){
        Matrix mat1 = new Matrix(2, 2, xint);
        mat1.setCell(1,1,3);
        assertEquals(3, mat1.getCell(1,1));
        mat1.setCell(1,1,8);
        assertEquals(8, mat1.getCell(1,1));
    }

    @Test
    public void testAddMatrix(){
        Matrix matrix = new Matrix(5,5,xint);
        Matrix matrix2= new Matrix(5,5,xint);
        Matrix matrix3 = new Matrix(5,5,xint);
        matrix2.fillInt(2);
        matrix.fillInt(4);
        matrix3.fillInt(6);
        assertEquals(matrix3, matrix.add(matrix2));

    }

    @Test
    public void testMulMatrix(){
        Matrix mat1 = new Matrix(2, 3, xint);
        Matrix mat2 = new Matrix(3,2, xint);
        Matrix mat3 = new Matrix(2,2,xint);

        mat1.setCell(0,0,2);
        mat1.setCell(0,1,2);
        mat1.setCell(0,2,4);
        mat1.setCell(1,0,4);
        mat1.setCell(1,1,2);
        mat1.setCell(1,2,6);

        mat2.setCell(0,0,3);
        mat2.setCell(0,1,4);
        mat2.setCell(1,0,5);
        mat2.setCell(1,1,7);
        mat2.setCell(2,0,8);
        mat2.setCell(2,1,6);

        mat3.setCell(0,0,53);
        mat3.setCell(0,1,53);
        mat3.setCell(1,0,70);
        mat3.setCell(1,1,66);

        mat3.diplayMatrix();
        mat1.mul(mat2).diplayMatrix();
        //assertEquals(true, mat3.compareMatrix(mat1.mul(mat2)));

    }

    @Test
    public void testTranspose(){

    }

    @Test
    public void testGetMinMax(){
        Matrix mat = new Matrix(3,2,xfloat);

        mat.setCell(0,1,2.6);
        mat.setCell(0,2,24.3);
        mat.setCell(0,3,46.1);
        mat.setCell(1,1,42.3);
        mat.setCell(1,2,2.1);
        mat.setCell(1,3,6.0);

        assertEquals(mat.getMinMax(true), 2.1);
        assertEquals(mat.getMinMax(false),46.1);
    }

    @Test
    public void testResize(){

    }

    @Test
    public void testCompare(){
        Matrix matrix = new Matrix(5,5,xint);
        Matrix matrix2= new Matrix(5,5,xint);
        matrix2.fillInt(2);
        matrix.fillInt(1);

        matrix.diplayMatrix();
        assertEquals(false, matrix.compareMatrix(matrix2));
    }

}
