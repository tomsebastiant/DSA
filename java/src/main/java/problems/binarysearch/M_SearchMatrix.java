package problems.binarysearch;

/**
 * LC: 74
 * Tags: Array
 * Tags: BinarySearch
 * https://leetcode.com/problems/search-a-2d-matrix/
 * You are given an m x n integer matrix with the following two properties: each row is sorted in
 * non-decreasing order, and the first integer of each row is greater than the last integer of the
 * previous row. Given an integer target, return true if target is in the matrix or false otherwise.
 *
 * Example 1:
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Example 2:
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 * Approach: Iterate rows in order; if the target is at most the last element of the current row
 * it could only be in that row, so binary search it and return the result. Because rows are
 * globally sorted and non-overlapping, at most one row is ever searched.
 * 
 * Approach 2: Treat the matrix as a virtual 1D sorted array of length m*n, 
 * binary search on indices 0 to m*n-1, and convert each mid back to 2D using 
 * matrix[mid/n][mid%n] â€” where mid/n gives the row and mid%n gives the column.
 * 
 */
public class M_SearchMatrix {
        public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int i=0;
        int j=0;
        while(i<m && j<n){
            if(target<=matrix[i][n-1]){
                int l=0;
                int r=n-1;
                while(l<=r){
                    int mid=(l+r)/2;
                    if(matrix[i][mid]==target){
                        return true;
                    } else if(matrix[i][mid]>target){
                        r=mid-1;
                    } else {
                        l=mid+1;
                    }
                }
            } 
                i++;
        }
        return false;
    }
}


