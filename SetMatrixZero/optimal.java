package SetMatrixZero;

public class optimal {
        // Method to set the rows and columns to zero where necessary
        public static void setZeros(int[][] matrix) {
            int totalRows = matrix.length;
            int totalColumns = matrix[0].length;
            boolean firstColZero = false;
    
            // Determine which rows and columns need to be zeroed
            for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
                if (matrix[rowIndex][0] == 0) firstColZero = true;
                for (int columnIndex = 1; columnIndex < totalColumns; columnIndex++) {
                    if (matrix[rowIndex][columnIndex] == 0) {
                        matrix[rowIndex][0] = 0;
                        matrix[0][columnIndex] = 0;
                    }
                }
            }
    
            // Use the markers to set elements to zero, except for the first row and column
            for (int rowIndex = 1; rowIndex < totalRows; rowIndex++) {
                for (int columnIndex = 1; columnIndex < totalColumns; columnIndex++) {
                    if (matrix[rowIndex][0] == 0 || matrix[0][columnIndex] == 0) {
                        matrix[rowIndex][columnIndex] = 0;
                    }
                }
            }
    
            // Handle the first row if needed
            if (matrix[0][0] == 0) {
                for (int columnIndex = 1; columnIndex < totalColumns; columnIndex++) {
                    matrix[0][columnIndex] = 0;
                }
            }
    
            // Handle the first column if needed
            if (firstColZero) {
                for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
                    matrix[rowIndex][0] = 0;
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
