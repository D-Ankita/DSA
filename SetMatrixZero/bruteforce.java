package SetMatrixZero;

public class bruteforce {

    // Method to mark all non-zero elements in the specified row as -1
    public static void makeRows(int[][] matrix, int rowLength, int row) {
        for (int columnIndex = 0; columnIndex < rowLength; columnIndex++) {
            // If the element is not 0, mark it as -1
            if (matrix[row][columnIndex] != 0) {
                matrix[row][columnIndex] = -1;
            }
        }
    }

    // Method to mark all non-zero elements in the specified column as -1
    public static void makeColumns(int[][] matrix, int columnLength, int column) {
        for (int rowIndex = 0; rowIndex < columnLength; rowIndex++) {
            // If the element is not 0, mark it as -1
            if (matrix[rowIndex][column] != 0) {
                matrix[rowIndex][column] = -1;
            }
        }
    }

    // Method to set the rows and columns to zero where necessary
    public static void setZeros(int[][] matrix) {
        // Number of rows
        int rows = matrix.length;
        // Number of columns
        int columns = matrix[0].length;

        // First pass: mark rows and columns to be zeroed
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // If element at matrix[i][j] is 0, mark the entire row and column
                if (matrix[i][j] == 0) {
                    makeRows(matrix, columns, i);
                    makeColumns(matrix, rows, j);
                }
            }
        }

        // Second pass: set marked elements to zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Method to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    
    public static void test(int[][] matrix) {
        System.out.println("Original Matrix:");
        printMatrix(matrix);
        setZeros(matrix);
        System.out.println("After setting zeros:");
        printMatrix(matrix);
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        int[][] matrix1 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        test(matrix1);
        int matrix2[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        test(matrix2);
        int matrix5[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        test(matrix5);
    }
}
