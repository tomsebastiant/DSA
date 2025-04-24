package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class M_167_TwoSum2Test {
    M_167_TwoSum2 solution = new M_167_TwoSum2();

    @Test
    public void testExample1() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(numbers, target));
    }

    @Test
    public void testExample2() {
        int[] numbers = {2, 3, 4};
        int target = 6;
        assertArrayEquals(new int[]{1, 3}, solution.twoSum(numbers, target));
    }

    @Test
    public void testNegativeNumbers() {
        int[] numbers = {-10, -3, 0, 5, 9};
        int target = -3;
        assertArrayEquals(new int[]{2, 3}, solution.twoSum(numbers, target));
    }

    @Test
    public void testLargeInput() {
        int[] numbers = {1, 2, 3, 4, 4, 9, 56, 90};
        int target = 8;
        assertArrayEquals(new int[]{4, 5}, solution.twoSum(numbers, target));
    }

    @Test
    public void testDuplicates() {
        int[] numbers = {1, 1, 3, 4};
        int target = 2;
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(numbers, target));
    }
}