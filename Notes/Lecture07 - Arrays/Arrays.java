
public class Arrays {

    public static void main(String args[]) {
        // Construct array
        // new double[10];

        // Store in variable of type double
        // double[] data = new double[10];
        // Accessing an element
        // data[2] = 29.95;
        // Exercise
        // double[] a = new double[10];
        // System.out.println(a[0]);
        // double[] b = new double[10];
        // System.out.println(b[10]); // Error detected at run-time
        // double[] c;
        // System.out.println(c[0]); // Error detected at compile-time
        // Two-dimensional array
        final int ROWS = 3;
        final int COLUMNS = 3;
        String[][] board = new String[ROWS][COLUMNS];
        // Accessing the elements
        board[0][2] = "x";

        // It's common to use two nested loops when filling or searching
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = " ";
            }
        }

        // declaring a 4x4 array of integers
        int[][] arr = new int[4][4];
        
    }
}
