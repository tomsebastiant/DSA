package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 https://leetcode.com/problems/pascals-triangle
 Given an integer numRows, return the first numRows of Pascal's triangle.

 In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

 Input: numRows = 5
 Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

 Approach: First row to added by hard coding. For subsequent rows, first and last element to be added
 by hard coding. Rest to added by traversing the previous row
 */

public class E_118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<>();
        if(numRows == 0){
            return out;
        }
        List<Integer> first_row=new ArrayList<>();
        first_row.add(1);
        out.add(first_row);
        for(int i=1;i<numRows;i++){
            List<Integer> prev_row = out.get(i-1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(prev_row.get(j-1)+prev_row.get(j));
            }
            row.add(1);
            out.add(row);
        }
        return out;

    }
}
