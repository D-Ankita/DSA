package SetMatrixZero;

public class better {

    // Method to set the rows and columns to zero where necessary
    public static void setZeros(int[][] matrix) {
        // Number of rows
        int totalRows = matrix.length;
        // Number of columns
        int totalColumns = matrix[0].length;

        int rowMemory[] = new int[totalRows];
        int columnMemory[] = new int[totalColumns];

        // First pass: mark rows and columns to be zeroed
        for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < totalColumns; columnIndex++) {
                // If element at matrix[i][j] is 0, mark the entire row and column
                if (matrix[rowIndex][columnIndex] == 0) {
                    rowMemory[rowIndex] = 1;
                    columnMemory[columnIndex] = 1;
                }
            }
        }

        // Second pass: set marked elements to zero
        for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < totalColumns; columnIndex++) {
                if (rowMemory[rowIndex] == 1 || columnMemory[columnIndex] == 1) {
                    matrix[rowIndex][columnIndex] = 0;
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
