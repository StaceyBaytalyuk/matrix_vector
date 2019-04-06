import java.util.Arrays;

public class Vector {
    private String name = "";
    private double[] array;

    public Vector(double[] arr) {
        array = arr;
    }

    public Vector(String name, double[] arr) {
        this.name = name;
        array = arr;
    }

    public Vector multiply(double scalar) {
        double[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < result.length; i++) {
            result[i] *= scalar;
        }
        return new Vector(result);
    }

    public Double multiply(Vector v) {
        if ( array.length == v.array.length ) {
            int size = array.length;
            double result = 0;
            for (int i = 0; i < size; i++) {
                result += array[i] * v.array[i];
            }
            return result;
        } else {
            return null;
        }
    }

    public Vector add(Vector v) {
        if ( array.length == v.array.length ) {
            int size = array.length;
            double[] result = new double[size];
            for (int i = 0; i < size; i++) {
                result[i] = array[i] + v.array[i];
            }
            return new Vector(result);
        } else {
            return null;
        }
    }

    public double module() {
        double result = 0;
        for (double element : array) {
            result += element*element;
        }
        return Math.sqrt(result);
    }

    public Double get(int index) {
        if ( index >= 0 && index < array.length ) {
            return array[index];
        }
        return null;
    }

    public int size() {
        return array.length;
    }

    @Override
    public String toString() {
        return name + " = " + Arrays.toString(array);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Arrays.equals(array, vector.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}