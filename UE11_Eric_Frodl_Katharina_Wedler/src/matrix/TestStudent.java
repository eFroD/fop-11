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
