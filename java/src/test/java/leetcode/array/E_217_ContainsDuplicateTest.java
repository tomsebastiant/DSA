package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class E_217_ContainsDuplicateTest {

    E_217_ContainsDuplicate solution = new E_217_ContainsDuplicate();

    @Test
    void testWithDuplicates() {
        int[] input = {1,5,9,6,3,1};
        assertTrue(solution.containsDuplicate(input));
    }

    @Test
    void testWithoutDuplicates() {
        int[] input = {1,5,9,6,3,7};
        assertFalse(solution.containsDuplicate(input));
    }

    @Test
    void testWithEmpty() {
        int[] input = {};
        assertFalse(solution.containsDuplicate(input));
    }

}