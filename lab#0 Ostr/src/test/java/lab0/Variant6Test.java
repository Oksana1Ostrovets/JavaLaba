package lab0;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class Variant6Test {

    @Test(dataProvider = "inputOutputProvider")
    public void testInputOutputTask(double a, double b, double expectedHypotenuse, double expectedPerimeter) {
        assertEquals(new Variant6().inputOutputTask(a, b), new double[] {expectedHypotenuse, expectedPerimeter});
    }

    @DataProvider(name = "inputOutputProvider")
    public Object[][] triangleData() {
        return new Object[][] {
                {3.0, 4.0, 5.0, 12.0},
                {5.0, 12.0, 13.0, 30.0},
                {6.0, 8.0, 10.0, 24.0}
        };
    }

    @Test(dataProvider = "integerProvider")
    public void testIntegerTask(int input, int expected) {
        assertEquals(new Variant6().integerNumbersTask(input), expected);
    }

    @DataProvider(name = "integerProvider")
    public Object[][] testData() {
        return new Object[][] {
                {12, 32},
                {46, 54},
                {79, 87}
        };
    }


    @Test(dataProvider = "testBooleanTask1")
    public void testBooleanTask1(int a, int b, int c) {
        assertTrue(new Variant6().booleanTask(a, b, c));
    }

    @DataProvider(name = "testBooleanTask1")
    public Object[][] TestBooleanNumbers1() {
        return new Object[][] {
                { 1, 2, 3 },
                { 9, 24, 3 }
        };
    }
    @Test(dataProvider = "testBooleanTask2")
    public void testBooleanTask2(int a, int b, int c) {
        assertFalse(new Variant6().booleanTask(a, b, c));
    }
    @DataProvider(name = "testBooleanTask2")
    public Object[][] TestBooleanNumbers2() {
        return new Object[][] {
                { 6, 2, 3 },
                { 1, 124, 3 },
                {2, 5, 7}
        };
    }


    @Test(dataProvider = "testIfTask")
    public void testIfTask(int a, int b) {
        assertEquals(new Variant6().ifTask(a, b), Math.max(Math.max(a,b),b));
    }

    @DataProvider(name = "testIfTask")
    public Object[][] testIf() {
        return new Object[][] {
                { 1, 2 },
                { 5, 3},
                { -1, -3 },
                { 0, 0}
        };
    }


    @Test(dataProvider = "switchProvider")
    public void testSwitchTask(int unitNumber, double lengthValue) {
        double result = new Variant6().switchTask(unitNumber, lengthValue);

        switch (unitNumber) {
            case 1 -> assertEquals(result, lengthValue / 10.0);
            case 2 -> assertEquals(result, lengthValue * 1000.0);
            case 3 -> assertEquals(result, lengthValue);
            case 4 -> assertEquals(result, lengthValue / 1000.0);
            case 5 -> assertEquals(result, lengthValue / 100.0);
            default -> fail("Enter correct number.");
        }
    }

    @DataProvider(name = "switchProvider")
    public Object[][] switchTest() {
        return new Object[][] {
                { 1, 5.0 },
                { 2, 10.0 },
                { 3, 31.4 },
                { 4, 78.5 }
        };
    }

    @Test(dataProvider = "forProvider")
    public void testForProvider(int candyPrice, double expectedCost) {
        assertEquals(new Variant6().forTask(candyPrice), expectedCost, 0.0001);
    }

    @DataProvider(name = "forProvider")
    public Object[][] inputData() {
        return new Object[][] {
                { 1, 1.2 },
                { 5, 6.0 },
                { 10, 12.0 }
        };
    }


    @Test(dataProvider = "whileProvider")
    public void testWhileTaskDouble(int n, double expected) {
        assertEquals(new Variant6().whileTask(n), expected);
    }

    @DataProvider(name = "whileProvider")
    public Object[][] testWhileTaskDouble() {
        return new Object[][] {
                { 4, 24.0 },
                { 5, 120.0 },
                { 6, 720.0 }
        };
    }

    @Test(dataProvider = "arrayProvider")
    public void testArrayTask(int n, int a, int b, int[] expectedOutput) {
        assertEquals(new Variant6().arrayTask(n, a, b), expectedOutput);
    }

    @DataProvider(name = "arrayProvider")
    public Object[][] arrayProvider() {
        return new Object[][]{
                {6, 1, 2, new int[]{1, 2, 3, 5, 8, 13}},
                {4, 10, 20, new int[]{10, 20, 30, 50}}
        };
    }

    @Test(dataProvider = "matrixProvider")
    public void testNewMatrix( int N, int M, int Q, int[] numbers, double[] expectedOutput) {
        assertEquals(new Variant6().newMatrix(M, N, Q, numbers), expectedOutput);
    }

    @DataProvider(name = "matrixProvider")
    public Object[][] matrixData() {
        {
            int M = 3;
            int N = 4;
            int Q = 2;
            int[] numbers = {1, 2, 3, 4};

            int[][] expectedOutput = {
                    {1, 2, 3, 4},
                    {2, 4, 6, 8},
                    {4, 8, 12, 16}
            };

            assertEquals(expectedOutput, newMatrix(M, N, Q, numbers));
        }
    }
}

