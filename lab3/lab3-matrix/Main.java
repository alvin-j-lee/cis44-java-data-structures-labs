/*
    Main class for matrix lab.

    Performs the following demonstration of our matrix implementation:

    1. Create two 3x3 matrices and one 2x2 matrix to demonstrate exception handling.
    2. Add matrices and print the resulting matrix.
    3. Multiply matrices and print the resulting matrix

    To test the exception handling, please un-comment those areas.
 */


public class Main {
    public static void main(String[] args) {
        // Create two 3x3 matrices and one 2x2 matrix to demonstrate exceptions.
        Matrix matrix1 = new Matrix(3, 3);
        matrix1.populateRandom();

        Matrix matrix2 = new Matrix(3, 3);
        matrix2.populateRandom();

        Matrix matrix3 = new Matrix(2, 2);
        matrix3.populateRandom();


        System.out.println("Matrix 1:");
        System.out.println(matrix1);

        System.out.println("Matrix 2:");
        System.out.println(matrix2);

        /*
        System.out.println("Matrix 3:");
        System.out.println(matrix3);
        */

        // Adding matrices
        Matrix sum = matrix1.add(matrix2);
        System.out.println("Sum of Matrix 1 and Matrix 2:");
        System.out.println(sum);

        /* Add incompatible matrices
        Matrix sum_incompatible = matrix1.add(matrix3);
        System.out.println("Sum of Matrix 1 and Matrix 3:");
        System.out.println(sum);
        */

        // Multiplying matrices
        Matrix product = matrix1.multiply(matrix2);
        System.out.println("Product of Matrix 1 and Matrix 2:");
        System.out.println(product);

        /* Multiplying incompatible matrices
        Matrix product_incompatible = matrix1.multiply(matrix3);
        System.out.println("Product of Matrix 1 and Matrix 3:");
        System.out.println(product);
        */

    }
}