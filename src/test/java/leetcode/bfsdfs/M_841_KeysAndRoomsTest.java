package leetcode.bfsdfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class M_841_KeysAndRoomsTest {
    M_841_KeysAndRooms solution = new M_841_KeysAndRooms();

    @Test
    public void testAllRoomsReachable() {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Collections.emptyList());

        assertTrue(solution.canVisitAllRooms(rooms));
    }

    @Test
    public void testNotAllRoomsReachable() {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        assertFalse(solution.canVisitAllRooms(rooms));
    }

    @Test
    public void testOnlyStartRoom() {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Collections.emptyList());

        assertTrue(solution.canVisitAllRooms(rooms));
    }

    @Test
    public void testCyclicRooms() {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(0));

        assertTrue(solution.canVisitAllRooms(rooms));
    }

    @Test
    public void testDisconnectedRooms() {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Collections.emptyList());
        rooms.add(Collections.emptyList());  // Room 2 is unreachable

        assertFalse(solution.canVisitAllRooms(rooms));
    }
}