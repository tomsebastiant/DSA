package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class M_11_ContainerWithMostWaterTest {

    M_11_ContainerWithMostWater solution = new M_11_ContainerWithMostWater();

    @Test
    public void testExample1() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        assertEquals(49, solution.maxArea(height)); // between height[1] and height[8]
    }

    @Test
    public void testSimpleCase() {
        int[] height = {1, 1};
        assertEquals(1, solution.maxArea(height));
    }

    @Test
    public void testUniformHeights() {
        int[] height = {5, 5, 5, 5, 5};
        assertEquals(20, solution.maxArea(height)); // 5 * (length-1)
    }

    @Test
    public void testDecreasingHeights() {
        int[] height = {6, 5, 4, 3, 2, 1};
        assertEquals(9, solution.maxArea(height)); // 3 * 3 (height[0] and height[3])
    }

    @Test
    public void testIncreasingHeights() {
        int[] height = {1, 2, 3, 4, 5};
        assertEquals(6, solution.maxArea(height)); // height[0] and height[4] => 1 * 4, then height[1] and height[4] => 2*3, then 3*2, etc.
    }

    @Test
    public void testSingleElement() {
        int[] height = {5};
        assertEquals(0, solution.maxArea(height)); // Need at least 2 lines
    }

    @Test
    public void testEmptyArray() {
        int[] height = {};
        assertEquals(0, solution.maxArea(height));
    }

}