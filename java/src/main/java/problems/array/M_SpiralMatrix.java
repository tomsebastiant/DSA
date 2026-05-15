package problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * LC: 54
 * Tags: Array
 * https://leetcode.com/problems/spiral-matrix/
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Approach: Maintain four boundary pointers (top, bottom, left, right). Each iteration traverses
 * the outermost ring in spiral order — left to right, top to bottom, right to left, bottom to top
 * — then shrinks the boundary inward, repeating until all elements are collected.
 */
public class M_SpiralMatrix {
        public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = matrix.length;
        int left = 0, right = matrix[0].length;

        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) res.add(matrix[top][i]);
            top++;

            for (int i = top; i < bottom; i++) res.add(matrix[i][right - 1]);
            right--;

            if (!(left < right && top < bottom)) break;

            for (int i = right - 1; i >= left; i--) res.add(matrix[bottom - 1][i]);
            bottom--;

            for (int i = bottom - 1; i >= top; i--) res.add(matrix[i][left]);
            left++;
        }
        return res;        
    }
}
