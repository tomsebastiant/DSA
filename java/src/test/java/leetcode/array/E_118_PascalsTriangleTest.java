package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E_118_E_118_PascalsTriangleTest {
    E_118_PascalsTriangle solution = new E_118_PascalsTriangle();

    @Test
    public void testFiveRows() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 2, 1),
                Arrays.asList(1, 3, 3, 1),
                Arrays.asList(1, 4, 6, 4, 1)
        );
        assertEquals(expected, solution.generate(5));
    }

    @Test
    public void testOneRow() {
        List<List<Integer>> expected = Collections.singletonList(
                Collections.singletonList(1)
        );
        assertEquals(expected, solution.generate(1));
    }

    @Test
    public void testZeroRows() {
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, solution.generate(0));
    }

    @Test
    public void testTwoRows() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1, 1)
        );
        assertEquals(expected, solution.generate(2));
    }
}