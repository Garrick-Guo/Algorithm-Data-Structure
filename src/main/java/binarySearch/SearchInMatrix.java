package binarySearch;

import java.util.Arrays;

/*
Given a 2D matrix that contains integers only, which each row is sorted in an ascending order.
The first element of next row is larger than (or equal to) the last element of previous row.
Given a target number, returning the position that the target locates within the matrix.
If the target number does not exist in the matrix, return {-1, -1}.

Assumptions:
The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.

Examples:
matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
target = 7, return {1, 2}
target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
 */
public class SearchInMatrix {
    public static void main(String[] args) {
        SearchInMatrix obj = new SearchInMatrix();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 7}, {8, 9, 10}};
        int target1 = 7;
        int target2 = 6;
        System.out.println(Arrays.toString(obj.search(matrix, target1)));
        System.out.println(Arrays.toString(obj.search(matrix, target2)));
    }
    private int[] search(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = row * column - 1;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            int rowIndex = middle / column;
            int colIndex = middle % column;
            if (matrix[rowIndex][colIndex] == target) {
                return new int[]{rowIndex, colIndex};
            } else if (matrix[rowIndex][colIndex] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
//TC: log(m * n)
//SC: 1
