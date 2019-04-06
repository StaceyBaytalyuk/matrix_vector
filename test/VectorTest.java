import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VectorTest {
    private Vector vector;
    private static final double EPS = 0.00001;
    private final double[] array = new double[] {1, 2, 3};

    @BeforeEach
    void setUp() {
        vector = new Vector("", array);
    }

    @Test
    void testScalarMultiply() {
        Vector expected = new Vector("", new double[] {10, 20, 30});
        Vector result = vector.multiply(10);
        assertEquals(expected, result);
    }

    @Test
    void testVectorMultiply() {
        Vector v = new Vector("", new double[] {4, 5, 6});
        double expected = 32;
        double result = vector.multiply(v);
        assertEquals(expected, result, EPS);
    }

    @Test
    void testAdd() {
        Vector v = new Vector("", new double[] {4, 5, 6});
        Vector expected = new Vector("", new double[] {5, 7, 9});
        Vector result = vector.add(v);
        assertEquals(expected, result);
    }

    @Test
    void testModule() {
        double expected = 3.74165;
        double result = vector.module();
        assertEquals(expected, result, EPS);
    }
}