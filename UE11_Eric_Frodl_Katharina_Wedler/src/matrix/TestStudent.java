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
        assertEquals(mat1.getRows(), 2);
        assertEquals(mat1.getColumns(), 2);
    }

    @Test
    public void testGetCell(){
        Matrix mat1 = new Matrix(2, 2, xint);
        mat1.setCell(1,1,3);
        assertEquals(mat1.getCell(1,1), 3);
    }

    @Test
    public void testSetCell(){
        Matrix mat1 = new Matrix(2, 2, xint);
        mat1.setCell(1,1,3);
        assertEquals(mat1.getCell(1,1), 3);
        mat1.setCell(1,1,8);
        assertEquals(mat1.getCell(1,1),8);
    }

    @Test
    public void testAddMatrix(){

    }

    @Test
    public void testMulMatrix(){
        Matrix mat1 = new Matrix(2, 3, xint);
        Matrix mat2 = new Matrix(3,2, xint);
        Matrix mat3 = new Matrix(2,2,xint);

        mat1.setCell(1,1,2);
        mat1.setCell(1,2,2);
        mat1.setCell(1,3,4);
        mat1.setCell(2,1,4);
        mat1.setCell(2,2,2);
        mat1.setCell(2,3,6);

        mat2.setCell(1,1,3);
        mat2.setCell(1,2,4);
        mat2.setCell(2,1,5);
        mat2.setCell(2,2,7);
        mat2.setCell(3,1,8);
        mat2.setCell(3,2,6);

        mat3.setCell(1,1,53);
        mat3.setCell(1,2,53);
        mat3.setCell(2,1,70);
        mat3.setCell(2,2,66);

        assertEquals(mat3.compareMatrix(mat1.mul(mat2)),true);

    }

    @Test
    public void testTranspose(){

    }

    @Test
    public void testGetMinMax(){
        Matrix mat = new Matrix(3,2,xfloat);

        mat.setCell(1,1,2.6);
        mat.setCell(1,2,24.3);
        mat.setCell(1,3,46.1);
        mat.setCell(2,1,42.3);
        mat.setCell(2,2,2.1);
        mat.setCell(2,3,6.0);

        assertEquals(mat.getMinMax(true), 2.1);
        assertEquals(mat.getMinMax(false),46.1);
    }

    @Test
    public void testResize(){

    }


}
