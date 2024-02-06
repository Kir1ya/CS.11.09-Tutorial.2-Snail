public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        int columnLength = array2d[0].length;
        int rowLength = array2d.length;
        int[] output = new int[columnLength * rowLength];
        int maxLayer = Math.min(columnLength, rowLength) / 2;
        int index = 0;

        for (int layer = 0; layer < maxLayer; layer++) {
            for (int i = layer; i < columnLength - layer; i++) {
                output[index++] = array2d[layer][i];
            }
            for (int i = layer + 1; i < rowLength - layer; i++) {
                output[index++] = array2d[i][columnLength - 1 - layer];
            }
            for (int i = columnLength - 2 - layer; i >= layer; i--) {
                output[index++] = array2d[rowLength - 1 - layer][i];
            }
            for (int i = rowLength - 2 - layer; i > layer; i--) {
                output[index++] = array2d[i][layer];
            }
        }

        if (!isEven2d(array2d)) {
            int center = columnLength / 2;
            output[index] = array2d[center][center];
        }

        return output;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if (array1d == null){
            return new int[0][0];
        }
        int length = array1d.length;
        int sqrtLength = (int) Math.sqrt(length);
        if (!isPerfectSquare(array1d)) {
            return new int[0][0];
        }

        int[][] output = new int[sqrtLength][sqrtLength];
        int index = 0;

        for (int layer = 0; layer < sqrtLength / 2; layer++) {
            for (int i = layer; i < sqrtLength - layer; i++) {
                output[layer][i] = array1d[index++];
            }
            for (int i = layer + 1; i < sqrtLength - layer; i++) {
                output[i][sqrtLength - 1 - layer] = array1d[index++];
            }
            for (int i = sqrtLength - 2 - layer; i >= layer; i--) {
                output[sqrtLength - 1 - layer][i] = array1d[index++];
            }
            for (int i = sqrtLength - 2 - layer; i > layer; i--) {
                output[i][layer] = array1d[index++];
            }
        }
        if (!isEven1d(array1d)) {
            int center = sqrtLength / 2;
            output[center][center] = array1d[index];
        }
        return output;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int row : array1d) {
            System.out.println(row);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int[] row : array2d) {
            for (int element : row) {
                System.out.println(element);
            }
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        int rooted = (int) Math.sqrt(array1d.length);
        if (rooted * rooted == array1d.length) {
            return true;
        }
        return false;
    }

    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        int rowCount = array2d.length;
        int columnCount = array2d[0].length;
        if (rowCount == columnCount) {
            return true;
            }
        return false;
    }

    private static boolean isEven2d(int[][] array2d) {
        int length = array2d[0].length;
        if (length % 2 == 0) {
            return true;
        }
        return false;
    }
    private static boolean isEven1d(int[] array1d) {
        int length = array1d.length;
        if (length % 2 == 0) {
            return true;
        }
        return false;
    }
}