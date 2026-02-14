/*
    This is the Matrix class, implemented by using 2D arrays.

    The methods available are as follows:
    1. 2 constructor methods; one for initializing a matrix with given dimensions,
       and one for initializing a matrix with a pre-existing 2D array
    2. populateRandom() fills the matrix with random integer values between 1 and 10
    3. add() this matrix to another matrix and returns a new Matrix object.
       Argument is a matrix to add.
       Throws an exception if matrix addition is not feasible.
    4. multiply() this matrix by another matrix and returns a new Matrix object.
       Argument is a matrix to add.
       Throws an exception if matrix multiplication is not feasible.
    5. toString() makes a string representation of a matrix.
 */


// Used for populating matrices with random values
import java.util.Random;

// Helps create the representation of the matrix
import java.lang.StringBuilder;

public class Matrix {

    // Private instance variable to store the matrix data
    private int[][] data;

    // Constructor that initializes the matrix with given dimensions (rows and columns)
    public Matrix(int rows, int cols) {
        data = new int[rows][cols];
    }

    // Constructor that initializes the matrix with a pre-existing 2D array
    public Matrix(int[][] data) {
        // Deep copy of the input array to prevent external modifications
        this.data = new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    // populateRandom() fills the matrix with random integer values between 1 and 10
    public void populateRandom() {
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = rand.nextInt(10) + 1;  // Random number between 1 and 10
            }
        }
    }

    // Adds this matrix to another matrix and returns a new Matrix object
    public Matrix add(Matrix other) {

        // Catch incorrect conditions for matrix addition. Throws an exception.
        if (this.data.length != other.data.length || this.data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Matrices dimensions must match!");
        }

        Matrix result = new Matrix(this.data.length, this.data[0].length);
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }

        return result;
    }

    // Multiplies this matrix by another matrix and returns a new Matrix object
    public Matrix multiply(Matrix other) {

        // Catch incorrect conditions for matrix multiplication. Throws an exception.
        if (this.data[0].length != other.data.length) {
            throw new IllegalArgumentException("Invalid: the columns of matrix 1 must equal rows of matrix 2.");
        }

        // Compute the product of the matrices if applicable
        Matrix result = new Matrix(this.data.length, other.data[0].length);
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < other.data[0].length; j++) {
                for (int k = 0; k < this.data[0].length; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }

        return result;
    }

    // Returns a string representation of the matrix
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sb.append(data[i][j]);
                if (j < data[i].length - 1) {
                    sb.append("\t");  // Tab space between elements in a row
                }
            }
            sb.append("\n");  // Newline after each row
        }
        return sb.toString();
    }
}
