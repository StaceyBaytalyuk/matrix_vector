import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    private Matrix matrix;
    private final double[][] array = new double[][] { {1, 2}, {3, 4}, {5, 6} };

    @BeforeEach
    void setUp() {
        matrix = new Matrix(array);
    }

    @Test
    void testTranspose() {
        Matrix expected = new Matrix(new double[][] { {1, 3, 5}, {2, 4, 6} });
        Matrix result = matrix.transpose();
        assertEquals(expected, result);
    }

    @Test
    void testAdd() {
        Matrix m = new Matrix(new double[][] { {-1, -1}, {-1, -1}, {-1, -1} });
        Matrix expected = new Matrix(new double[][] { {0, 1}, {2, 3}, {4, 5} });
        Matrix result = matrix.add(m);
        assertEquals(expected, result);
    }

    @Test
    void testScalarMultiply() {
        Matrix expected = new Matrix(new double[][] { {-1, -2}, {-3, -4}, {-5, -6} });
        Matrix result = matrix.multiply(-1);
        assertEquals(expected, result);
    }

    @Test
    void testVectorMultiply() {
        Vector v = new Vector("", new double[] { -1, -1 });
        Vector expected = new Vector("", new double[] {-3, -7, -11} );
        Vector result = matrix.multiply(v);
        assertEquals(expected, result);
    }

    @Test
    void testMatrixMultiply() {
        Matrix m = new Matrix(new double[][] { {-1, 0, 1}, {-1, 0, 1} });
        Matrix expected = new Matrix(new double[][] { {-3, 0, 3}, {-7, 0, 7}, {-11, 0, 11} });
        Matrix result = matrix.multiply(m);
        assertEquals(expected, result);
    }
}