package problems.design;

/**
 * LC: 1603
 * Tags: Design
 * Tags: Array
 * https://leetcode.com/problems/design-parking-system/
 * Design a parking system for a lot with three types of parking spaces: big, medium, and small,
 * each with a fixed number of slots. Implement ParkingSystem(big, medium, small) and
 * addCar(carType) which returns true if a space of the given type is available and parks the car,
 * or false if no space is available. carType is 1 for big, 2 for medium, 3 for small.
 *
 * Constraints:
 * 0 <= big, medium, small <= 1000
 * carType is 1, 2, or 3
 * At most 1000 calls will be made to addCar
 *
 * Example 1:
 *
 * Input:  ["ParkingSystem","addCar","addCar","addCar","addCar"]
 *         [[1,1,0],[1],[2],[3],[1]]
 * Output: [null, true, true, false, false]
 * Explanation:
 * ParkingSystem ps = new ParkingSystem(1, 1, 0);
 * ps.addCar(1); // 1 big slot available    → true,  big slots: 0
 * ps.addCar(2); // 1 medium slot available → true,  medium slots: 0
 * ps.addCar(3); // 0 small slots           → false
 * ps.addCar(1); // 0 big slots remaining   → false
 *
 * Approach: Store the three slot counts in a size-3 array indexed by carType-1. addCar checks
 * and decrements the relevant count in O(1) — no iteration needed.
 */
public class E_ParkingSystem {
        private int[] spaces;

    public E_ParkingSystem(int big, int medium, int small) {
        spaces = new int[]{big,medium,small};
    }
    
    public boolean addCar(int carType) {
        if(spaces[carType-1]>0){
            spaces[carType-1]--;
            return true;
        }
        return false;
    }
}
