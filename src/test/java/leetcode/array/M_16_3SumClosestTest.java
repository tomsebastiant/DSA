package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class M_16_3SumClosestTest {
    M_16_3SumClosest solution = new M_16_3SumClosest();

    @Test
    public void testExample1() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        assertEquals(2, solution.threeSumClosest(nums, target));
    }

    @Test
    public void testAllZeros() {
        int[] nums = {0, 0, 0};
        int target = 1;
        assertEquals(0, solution.threeSumClosest(nums, target));
    }

    @Test
    public void testPositiveNumbers() {
        int[] nums = {1, 1, 1, 1};
        int target = 3;
        assertEquals(3, solution.threeSumClosest(nums, target));
    }

    @Test
    public void testNegativeNumbers() {
        int[] nums = {-3, -2, -5, -4};
        int target = -1;
        assertEquals(-9, solution.threeSumClosest(nums, target));
    }

    @Test
    public void testMixedNumbers() {
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        assertEquals(0, solution.threeSumClosest(nums, target));
    }

    @Test
    public void testLargeNumbers() {
        int[] nums = {1000, -1000, 0, 2, -2};
        int target = 3;
        assertEquals(2, solution.threeSumClosest(nums, target));
    }
}