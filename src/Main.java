public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Vector a = new Vector("a", new double[] {1, 2, 3});
        Vector b = new Vector("b", new double[] {4, 5, 6});
        scalarMultiplyVectors(a, b);
        System.out.println("Сума векторів: a+b" + a.add(b));
        System.out.println("Добуток вектора і скаляра: a*10" + a.multiply(10));
        System.out.println("Модуль вектора а = " + a.module());

        //double[][] m = { {1, 2}, {3, 4}, {5, 6} };
        double[][] m1 = { {1, 2, 3}, {4, 5, 6} };
        Matrix A = new Matrix(m1);
        System.out.println("Матриця А:\n" + A);
        System.out.println("Транспонування матриці А:\n" + A.transpose());
        System.out.println("Добуток матриці і скаляра: А*2\n" + A.multiply(2));
        matrixMultiplyVector(A, a);
        double[][] m2 = { {1, 2}, {2, 1}, {1, 0} };
        double[][] m3 = { {3, 1}, {0, 4}, {0, 0} };
        Matrix B = new Matrix(m2);
        Matrix C = new Matrix(m3);
        System.out.println("Матриця В:\n" + B);
        System.out.println("Матриця С:\n" + C);
        multiplyMatrices(A, B);
        addMatrices(B, C);
    }

    private void scalarMultiplyVectors(Vector a, Vector b) {
        System.out.println(a);
        System.out.println(b);
        Double result = a.multiply(b);
        if ( result != null ) {
            System.out.println("Скалярний добуток векторів: a*b = " + result);
        } else {
            System.out.println("Неможливо знайти добуток: невідповідність розмірностей");
        }
    }

    private void matrixMultiplyVector(Matrix m, Vector v) {
        Vector result = m.multiply(v);
        if ( result != null ) {
            System.out.println("Добуток матриці і вектора: A*a" + result);
        } else {
            System.out.println("Неможливо знайти добуток: невідповідність розмірностей");
        }
    }

    private void multiplyMatrices(Matrix m1, Matrix m2) {
        Matrix result = m1.multiply(m2);
        if ( result != null ) {
            System.out.println("Добуток матриць: A*В\n" + result);
        } else {
            System.out.println("Неможливо знайти добуток: неузгоджені матриці");
        }
    }

    private void addMatrices(Matrix m1, Matrix m2) {
        Matrix result = m1.add(m2);
        if ( result != null ) {
            System.out.println("Сума матриць: B+C\n" + result);
        } else {
            System.out.println("Неможливо знайти суму: невідповідність розмірностей");
        }
    }
}