package problems.design;

/**
 * LC: 641
 * Tags: Design
 * Tags: Array
 * Tags: Deque
 * https://leetcode.com/problems/design-circular-deque/
 * Design your implementation of the circular double-ended queue (deque). A deque supports
 * insertion and deletion at both ends. Implement MyCircularDeque(k), insertFront(value),
 * insertLast(value), deleteFront(), deleteLast(), getFront(), getRear(), isEmpty(), isFull().
 * insertFront/insertLast return true on success, false if full. getFront/getRear return -1 if empty.
 *
 * Constraints:
 * 1 <= k <= 1000
 * 0 <= value <= 1000
 * At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast,
 * getFront, getRear, isEmpty, and isFull.
 *
 * Example 1:
 *
 * Input:  ["MyCircularDeque","insertLast","insertLast","insertFront","insertFront",
 *          "getRear","isFull","deleteLast","insertFront","getFront"]
 *         [[3],[1],[2],[3],[4],[],[],[],[4],[]]
 * Output: [null, true, true, true, false, 2, true, true, true, 4]
 * Explanation:
 * MyCircularDeque deque = new MyCircularDeque(3);
 * deque.insertLast(1);  // deque: [1],     return true
 * deque.insertLast(2);  // deque: [1,2],   return true
 * deque.insertFront(3); // deque: [3,1,2], return true
 * deque.insertFront(4); // full,           return false
 * deque.getRear();      // return 2
 * deque.isFull();       // return true
 * deque.deleteLast();   // deque: [3,1],   return true
 * deque.insertFront(4); // deque: [4,3,1], return true
 * deque.getFront();     // return 4
 *
 * Approach: Fixed-size array circular buffer with head, tail, and size. insertFront steps head
 * backward (mod capacity) before writing; insertLast writes at tail then steps it forward. All
 * pointer moves use modulo arithmetic for wraparound — every operation is O(1).
 *
 */
public class M_CircularDeque {
    int[] arr;
    int head;
    int tail;
    int size;
    int capacity;

    public M_CircularDeque(int k) {
        arr = new int[k];
        capacity = k;
        head=0;
        tail=0;
        size=0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;

        head = (head-1+capacity)%capacity;
        arr[head]=value;
        size++;
        return true;

    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;

        arr[tail]=value;
        tail = (tail+1)%capacity;
        
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;

        head=(head+1)%capacity;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;

        tail=(tail-1+capacity)%capacity;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return arr[head];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return arr[(tail-1+capacity)%capacity];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}
