package enhanced_for_loops;

public class Matrix {
    private double[][] matrix;

    // Constructor with 2D double array parameter
    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    // Constructor with row and column parameters
    public Matrix(int rows, int columns) {
        this.matrix = new double[rows][columns];
    }

    // Getter for number of columns
    public int getColumns() {
        return matrix[0].length;
    }

    // Getter for number of rows
    public int getRows() {
        return matrix.length;
    }

    // Getter for element at specified row and column
    public double getElement(int row, int column) {
        return matrix[row][column];
    }

    // Setter for element at specified row and column
    public void setElement(int row, int column, double value) {
        matrix[row][column] = value;
    }

    // Method to add two matrices together
    public static Matrix addMatrices(Matrix matrix1, Matrix matrix2) {
        int rows = matrix1.getRows();
        int columns = matrix1.getColumns();
        Matrix result = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double sum = matrix1.getElement(i, j) + matrix2.getElement(i, j);
                result.setElement(i, j, sum);
            }
        }

        return result;
    }

    // Method to multiply two matrices
    public static Matrix multiplyMatrices(Matrix matrix1, Matrix matrix2) {
        int rows1 = matrix1.getRows();
        int columns1 = matrix1.getColumns();
        int columns2 = matrix2.getColumns();
        Matrix result = new Matrix(rows1, columns2);

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                double sum = 0.0;
                for (int k = 0; k < columns1; k++) {
                    sum += matrix1.getElement(i, k) * matrix2.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }

        return result;
    }
}
