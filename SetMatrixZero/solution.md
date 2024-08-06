# **Brute Force Approach**
**Complexity:**

Time complexity: `O((NM)(N + M)) + O(N*M)`
where N = no. of rows in the matrix and M = no. of columns in the matrix.

Space complexity: `O(1)`

**Code:**

```
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
    
}
```

# **Better Approach**
**Complexity:**

Time complexity : `O(2*(N*M))`
where N = no. of rows in the matrix and M = no. of columns in the matrix.

Space complexity : `O(N) + O(M)`

**Code:**
```
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

    
}
```

# **Optimal Approach**
**Complexity:**

Time complexity: ` O(N*M)`
where N = no. of rows in the matrix and M = no. of columns in the matrix.

Space complexity: `O(1)`

**Code:**
```
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
}
```
