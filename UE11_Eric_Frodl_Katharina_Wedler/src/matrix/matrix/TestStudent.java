package matrix.matrix;
import static org.junit.Assert.*;

import matrix.IntegerArithmetic;
import matrix.Matrix;
import org.junit.Test;

/**
 * tests for the exercise
 * @author Eric Frodl, Katharina Wedler
 *
 */

public class TestStudent {

    IntegerArithmetic xint = new IntegerArithmetic;

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
        
        mat1.mul(mat2);
    }

    @Test
    public void testTranspose(){

    }

    @Test
    public void testGetMinMax(){

    }

    @Test
    public void testResize(){

    }


}
