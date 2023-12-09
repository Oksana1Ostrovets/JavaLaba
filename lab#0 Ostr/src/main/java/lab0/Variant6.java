package lab0;

import java.util.Arrays;

public class Variant6 {

    /**
     *
     * @param a is leg of triangle
     * @param b is other leg of triangle
     * @return triangle hypothesis and perimeter
     */
    public double[] inputOutputTask(double a, double b) {
        double c = Math.sqrt(a * a + b * b);
        double P = a + b + c;
        return new double[] {c, P};
    }

    /**
     *
     * @param number is given number
     * @return Print first its left digit (tens), and then its right digit (units)
     */

    public int[] integerNumbersTask(int number) {
        int tens = number / 10;
        int units = number % 10;
        int[] result = {tens, units};
        return result;
    }

    /**
     *
     * @param a is number
     * @param b is number
     * @param c is number
     * @return true, if Double inequality is true
     */
    public boolean booleanTask(int a, int b, int c) {
        return a < b && b < c;
    }


    /**
     *  @param a is number
     * @param b is number
     * @return max number
     */
    public int ifTask(int a, int b) {
        int max = a;

        if (b > max) {
            max = b;
        }

        return max;
    }


    /**
     *
     * @param unitNumber is 1 - decimeter, 2 - kilometer, 3 - meter, 4 - millimeter, 5 - centimeter.
     * @param lengthValue - value of element
     * @return the length of the segment in meters
     */
    public double switchTask(int unitNumber, double lengthValue) {
        double result = 0.0;

        switch (unitNumber) {
            case 1:
                result = lengthValue / 10.0; // Convert decimeter to meter
                break;
            case 2:
                result = lengthValue * 1000.0; // Convert kilometer to meter
                break;
            case 3:
                result = lengthValue; // Length is already in meters
                break;
            case 4:
                result = lengthValue / 1000.0; // Convert millimeter to meter
                break;
            case 5:
                result = lengthValue / 100.0; // Convert centimeter to meter
                break;
            default:
                System.out.println("Incorrect unit number");
                break;
        }

        return result;
    }


    /**
     *
     * @param candyPrice is real number
     * @return cost 1.2, 1.4, …, 2
     */
    public double forTask(int candyPrice) {
        double cost = 0;
        for (double weight = 1.2; weight <= 2.0; weight += 0.2) {
            cost = candyPrice * weight;
        }

        return cost;
    }

    /**
     *
     * @param n is integer number
     * @return Find double factorial N
     */
    public double whileTask(int n) {
        assert (n > 0): "Argument should be more than zero";
        double result = 1;

        if (n % 2 == 0) {
            for (int i = n; i >= 2; i -= 2) {
                result *= i;
            }
        } else {
            for (int i = n; i >= 1; i -= 2) {
                result *= i;
            }
        }

        return result;
    }


    /**
     *
     * @return an integer array of size N, the first element of which is A, the second is B, and each subsequent element is equal to the sum of all previous ones
     */
    public int[] arrayTask(int n, int a, int b) {
        int[] array = new int[n];
        array[0] = a;
        array[1] = b;

        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array;
    }

    /**
     * Generate a matrix of size M ґ N, in which the first row coincides with the original
     * set of numbers, and the elements of each next row are equal to the corresponding element of the previous row, multiplied by Q
     *
     * @param matrix The input 2D matrix to be transformed.
     * @return matrix.
     */
    public int[][] newMatrix(int M, int N, int Q, int[] numbers) {
        int[][] matrix = new int[M][N];

        for (int i = 0; i < N; i++) {
            matrix[0][i] = numbers[i];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = matrix[i-1][j] * Q;
            }
        }

        return matrix;
    }

    public static void main(String... strings) {
        Variant6 variant6 = new Variant6();

        double[] inputOutputResult = variant6.inputOutputTask(5.0, 4.0);
        System.out.println("Hypotenuse c: " + inputOutputResult[0]);
        System.out.println("Perimeter P: " + inputOutputResult[1]);

        int[] resultArray = variant6.integerNumbersTask(56);
        System.out.println("Tens: " + resultArray[0]);
        System.out.println("Units: " + resultArray[1]);


        boolean inequality = variant6.booleanTask(5, 10, 15);
        System.out.println("Double inequality is true: " + inequality);

        int maxNumber = variant6.ifTask(5, 3);
        System.out.println("Max number: " + maxNumber);

        double switchResult = variant6.switchTask(1, 50.0);
        System.out.println("Length in meters: " + switchResult);

        double forResult = variant6.forTask(10);
            System.out.println("The cost of candy is: " + forResult);

        double whileResult = variant6.whileTask(10);
        System.out.println("Result of the while loop: " + whileResult);

        int[] arrayResult = variant6.arrayTask(10,1,2);
        System.out.println("Resulting array: " + Arrays.toString(arrayResult));

        int M = 3; // Number of rows
        int N = 4; // Number of columns
        int Q = 2; // Common ratio
        int[] numbers = {1, 2, 3, 4}; // Initial numbers

        int[][] matrixResult = variant6.newMatrix(M, N, Q, numbers);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrixResult[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Done!!!");

    }

}

