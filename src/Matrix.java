import java.util.Arrays;

public class Matrix {
    private double[][] array;
    private int m;
    private int n;

    public Matrix(double[][] matrix) {
        array = matrix;
        m = array.length;
        if ( m > 0 ) {
            n = array[0].length;
        } else {
            n = 0;
        }
    }

    public Matrix transpose() {
        double[][] matrix = new double[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][i] = array[i][j];
            }
        }
        return new Matrix(matrix);
    }

    public Matrix add(Matrix matrix) {
        if ( m == matrix.m && n == matrix.n ) {
            double[][] result = new double[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result[i][j] = array[i][j] + matrix.array[i][j];
                }
            }
            return new Matrix(result);
        } else {
            return null;
        }
    }

    public Matrix multiply(double scalar) {
        double[][] result = new double[m][];
        for (int i = 0; i < m; i++) {
            result[i] = array[i].clone();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] *= scalar;
            }
        }
        return new Matrix(result);
    }

    public Vector multiply(Vector vector) {
        if ( n == vector.size() ) {
            double[] result = new double[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result[i] += array[i][j] * vector.get(j);
                }
            }
            return new Vector(result);
        } else {
            return null;
        }
    }

    public Matrix multiply(Matrix matrix) {
        if ( n == matrix.m ) {
            int n2 = matrix.n;
            int m2 = matrix.m;
            double[][] result = new double[m][n2];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n2; j++) {
                    for (int k = 0; k < m2; k++) {
                        result[i][j] += array[i][k] * matrix.array[k][j];
                    }
                }
            }
            return new Matrix(result);
        } else {
            return null;
        }
    }

    public int getN() {
        return n;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : array) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        boolean isEqual = true;
        for (int i = 0; i < array.length; i++) {
            if ( !( Arrays.equals(array[i], matrix.array[i]) ) ) {
                isEqual = false;
                break;
            }
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}