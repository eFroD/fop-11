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

    /**
     * tests generating a matrix
     */

    @Test
    public void testMatrix(){
        Matrix mat1 = new Matrix(2, 2, xint);
        assertEquals(2, mat1.getRows());
        assertEquals(2, mat1.getColumns());
    }

    /**
     * tests getting the index of a cell
     */

    @Test
    public void testGetCell(){
        Matrix mat1 = new Matrix(2, 2, xint);
        mat1.setCell(1,1,3);
        assertEquals(3, mat1.getCell(1,1));
    }

    /**
     * tests setting the index of a cell
     */

    @Test
    public void testSetCell(){
        Matrix mat1 = new Matrix(2, 2, xint);
        mat1.setCell(1,1,3);
        assertEquals(3, mat1.getCell(1,1));
        mat1.setCell(1,1,8);
        assertEquals(8, mat1.getCell(1,1));
    }

    /**
     * tests adding two matrices
     */

    @Test
    public void testAddMatrix(){
        Matrix matrix = new Matrix(5,5,xint);
        Matrix matrix2= new Matrix(5,5,xint);
        Matrix matrix3 = new Matrix(5,5,xint);
        matrix2.fillInt(2);
        matrix.fillInt(4);
        matrix.setCell(3,2, 7);
        matrix3.fillInt(6);
        matrix3.setCell(3,2,9);

        assertEquals(true, matrix3.compareMatrix(matrix.add(matrix2)));

    }

    /**
     * tests multiplying two matrices
     */

    @Test
    public void testMulMatrix(){
        Matrix mat1 = new Matrix(2, 3, xint);
        Matrix mat2 = new Matrix(3,2, xint);
        Matrix mat3 = new Matrix(2,2,xint);


        mat1.setCell(0,0,2);
        mat1.setCell(0,1,3);
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

        assertEquals(true, mat3.compareMatrix(mat1.mul(mat2)));

    }

    /**
     * tests transposing a matrix
     */

    @Test
    public void testTranspose(){
        Matrix matrix = new Matrix(2,4, xfloat);
        matrix.setCell(0,0,4);
        matrix.setCell(0,1,5);
        matrix.setCell(0,2,9);
        matrix.setCell(0,3,3);
        matrix.setCell(1,0,2);
        matrix.setCell(1,1,5.3);
        matrix.setCell(1,2,3.1);
        matrix.setCell(1,3,9.7);
        matrix.diplayMatrix();
        Matrix matrix2 = new Matrix(4,2,xfloat);
        matrix2.setCell(0,0,4);
        matrix2.setCell(0,1,2);
        matrix2.setCell(1,0,5);
        matrix2.setCell(1,1,5.3);
        matrix2.setCell(2,0,9);
        matrix2.setCell(2,1,3.1);
        matrix2.setCell(3,0,3);
        matrix2.setCell(3,1,9.7);
        matrix2.diplayMatrix();

        assertEquals(true, matrix2.compareMatrix(matrix.transpose()));

    }

    /**
     * tests getting the minimum/maximum index of a matrix
     */

    @Test
    public void testGetMinMax(){
        Matrix mat = new Matrix(3,2,xfloat);

        mat.setCell(0,0,2.6);
        mat.setCell(0,1,24.3);
        mat.setCell(1,0,46.1);
        mat.setCell(1,1,42.3);
        mat.setCell(2,0,2.1);
        mat.setCell(2,1,6.0);

        mat.diplayMatrix();

        assertEquals(2.1, mat.getMinMax(true));
        assertEquals(46.1, mat.getMinMax(false));
    }

    /**
     * tests resizing a matrix
     */

    @Test
    public void testResize(){
        Matrix mat = new Matrix(4,4,xfloat);

        mat.setCell(0,0,2.4);
        mat.setCell(0,1,24.3);
        mat.setCell(0,2,3.46);
        mat.setCell(0,3,5.36);

        mat.setCell(1,0,21.2);
        mat.setCell(1,1,7.63);
        mat.setCell(1,2,34.66);
        mat.setCell(1,3,3.87);

        mat.setCell(2,0,46.1);
        mat.setCell(2,1,42.3);
        mat.setCell(2,2,22.1);
        mat.setCell(2,3,6.07);

        mat.setCell(3,0,53.1);
        mat.setCell(3,1,12.3);
        mat.setCell(3,2,221.0);
        mat.setCell(3,3,62.027);

        Matrix mat2 = new Matrix(2,2,xfloat);

        mat2.setCell(0,0,2.4);
        mat2.setCell(0,1,24.3);

        mat2.setCell(1,0,21.2);
        mat2.setCell(1,1,7.63);

        assertEquals(true, mat.resize(-2,-2).compareMatrix(mat2));
    }

    /**
     * tests comparing two matrices
     */

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
