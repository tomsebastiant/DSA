package leetcode.bfsdfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class M_200_M_200_NumberOfIslandsTest {

    @Test
    public void testExample1() {
        M_200_NumberOfIslands solution = new M_200_NumberOfIslands();
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    public void testExample2() {
        M_200_NumberOfIslands solution = new M_200_NumberOfIslands();
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void testEmptyGrid() {
        M_200_NumberOfIslands solution = new M_200_NumberOfIslands();
        char[][] grid = new char[0][0];
        assertEquals(0, solution.numIslands(grid));
    }

    @Test
    public void testAllWater() {
        M_200_NumberOfIslands solution = new M_200_NumberOfIslands();
        char[][] grid = {
                {'0','0','0'},
                {'0','0','0'}
        };
        assertEquals(0, solution.numIslands(grid));
    }

}