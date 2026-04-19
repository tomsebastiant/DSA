class E_PascalsTriangle:
    """
    LC: 118
    https://leetcode.com/problems/pascals-triangle
    Given an integer numRows, return the first numRows of Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown.

    Approach: Build the first row manually, then construct each next row from the previous row.

    Tags: Array
    """

    def generate(self, num_rows):
        out = []
        if num_rows == 0:
            return out

        out.append([1])
        for i in range(1, num_rows):
            prev_row = out[i - 1]
            row = [1]
            for j in range(1, i):
                row.append(prev_row[j - 1] + prev_row[j])
            row.append(1)
            out.append(row)
        return out

