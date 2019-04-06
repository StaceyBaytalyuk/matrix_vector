import java.util.Scanner;

public class Main {
    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();
    }

    // Головна функція програми. Поки користувач не обере "Вихід", йому пропонують виконати дію
    private void run() {
        printMenu();
        int answer;
        while (true) {
            answer = menu();
            switch (answer) {
                case 0: System.exit(0);

                case 1: {
                    vectorMultiplyScalar();
                    break;
                }

                case 2: {
                    Vector[] vector = enterVectors();
                    System.out.println( "a+b" + vector[0].add(vector[1]) );
                    break;
                }

                case 3: {
                    Vector[] vector = enterVectors();
                    System.out.println( "a*b = " + vector[0].multiply(vector[1]) );
                    break;
                }

                case 4: {
                    vectorModule();
                    break;
                }

                case 5: {
                    Matrix A = enterMatrix("A", enterDimension("Кількість рядків: "), enterDimension("Кількість стовпців: "));
                    System.out.println("Транспонування матриці А:\n" + A.transpose());
                    break;
                }

                case 6: {
                    matrixMultiplyScalar();
                    break;
                }

                case 7: {
                    matrixMultiplyVector();
                    break;
                }

                case 8: {
                    addMatrices();
                    break;
                }

                case 9: {
                    multiplyMatrices();
                    break;
                }

                default: System.out.println("Немає такого пункту. Спробуйте ще раз");
            }
        }
    }

    // Знайти добуток двох матриць
    private void multiplyMatrices() {
        System.out.println("Для множення необхідні матриці A(m k) та B(k n)");
        int m = enterDimension("m: ");
        int k = enterDimension("k: ");
        int n = enterDimension("n: ");
        Matrix A = enterMatrix("A", m, k);
        Matrix B = enterMatrix("B", k, n);
        System.out.println("А*В\n" + A.multiply(B));
    }

    // Знайти суму двох матриць
    private void addMatrices() {
        System.out.println("Для додавання необхідні матриці A(m n) та B(m n)");
        int m = enterDimension("m: ");
        int n = enterDimension("n: ");
        Matrix A = enterMatrix("A", m, n);
        Matrix B = enterMatrix("B", m, n);
        System.out.println("А+B\n" + A.add(B));
    }

    // Знайти добуток матриці і вектора
    private void matrixMultiplyVector() {
        Matrix A = enterMatrix("A", enterDimension("Кількість рядків: "), enterDimension("Кількість стовпців: "));
        int n = A.getN();
        System.out.println("Введіть " + n + " чисел (кількість елементів вектора а = кількості стовпців А)");
        System.out.print("Вектор а = ");
        Vector a = new Vector( enterArray(n) );
        System.out.println("A*a" + A.multiply(a));
    }

    // Знайти добуток матриці і скаляра
    private void matrixMultiplyScalar() {
        Matrix A = enterMatrix("A", enterDimension("Кількість рядків: "), enterDimension("Кількість стовпців: "));
        System.out.print("Скаляр n = ");
        double n = in.nextInt();
        System.out.println("А*" + n + "\n" + A.multiply(n));
    }

    // Знайти модуль вектора
    private void vectorModule() {
        int size = enterDimension("Розмірність вектора а: ");
        System.out.print("Вектор а = ");
        Vector a = new Vector("a", enterArray(size));
        System.out.println("|a| = " + a.module());
    }

    // Знайти добуток вектора і скаляра
    private void vectorMultiplyScalar() {
        int size = enterDimension("Розмірність вектора а: ");
        System.out.print("Вектор а = ");
        Vector a = new Vector("a", enterArray(size));
        System.out.print("Скаляр n = ");
        double n = in.nextInt();
        System.out.println("a*" + n + a.multiply(n));
    }

    // Користувач вводить матрицю
    // Параметри: name - ім'я матриці, m та n - її розмір
    private Matrix enterMatrix(String name, int m, int n) {
        double[][] matrix = new double[m][n];
        System.out.println("Матриця " + name + "(" + m + ", " + n + "):");
        for (int i = 0; i < m; i++) {
            matrix[i] = enterArray(n);
        }
        return new Matrix(matrix);
    }

    // Повертає два вектори однакової розмірності
    private Vector[] enterVectors() {
        Vector[] vectors = new Vector[2];
        int size = enterDimension("Розмірність векторів а та b: ");
        System.out.print("Вектор а = ");
        vectors[0] = new Vector("a", enterArray(size));
        System.out.print("Вектор b = ");
        vectors[1] = new Vector("b", enterArray(size));
        return vectors;
    }

    // Користувач вводить масив
    // Параметр size - довжина масиву
    private double[] enterArray(int size) {
        if ( size > 0 ) {
            double[] array = new double[size];
            for (int i = 0; i < size; i++) {
                array[i] = in.nextInt();
            }
            return array;
        } else return null;
    }

    // Користувачу пропонується ввести розмірність, поки не буде введено додатне число
    // Параметр text - пояснення, що потрібно ввести (наприклад: "Кількість стовпців: ")
    private int enterDimension(String text) {
        int size;
        do {
            System.out.print(text);
            size = in.nextInt();
            if (size > 0) {
                break;
            } else {
                System.out.println("Розмірність має бути додатною");
            }
        } while (size <= 0);
        return size;
    }

    // Повертає значення: пункт меню, обраний користувачем
    private int menu() {
        System.out.println();
        System.out.print("Введіть пункт меню: ");
        return in.nextInt();
    }

    private void printMenu() {
        System.out.println("1) Добуток вектора і скаляра\n"+
                "2) Сума двох векторів\n"+
                "3) Скалярний добудок векторів\n"+
                "4) Модуль вектора\n"+
                "5) Транспонування матриці\n"+
                "6) Добуток матриці і скаляра\n"+
                "7) Добуток матриці і вектора\n"+
                "8) Сума двох матриць\n"+
                "9) Добуток двох матриць\n"+
                "0) Вихід");
    }
}