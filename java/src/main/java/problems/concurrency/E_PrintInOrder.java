package problems.concurrency;

import java.util.concurrent.Semaphore;

/**
 * LC: 1114
 * Tags: Design
 * https://leetcode.com/problems/print-in-order/
 * The same Foo instance is shared by three threads. Thread A calls first(), thread B calls
 * second(), and thread C calls third(). Design a mechanism to ensure that second() always
 * executes after first(), and third() always executes after second(), regardless of the order
 * in which the OS schedules the threads.
 *
 * Constraints:
 * Exactly 3 threads call first(), second(), and third() exactly once each.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]  (thread A first, B second, C third)
 * Output: "firstsecondthird"
 *
 * Example 2:
 *
 * Input: nums = [1,3,2]  (thread A first, C second, B third)
 * Output: "firstsecondthird"
 * Explanation: Despite C being scheduled before B, synchronization ensures correct order.
 *
 * Approach: Three semaphores form a linear hand-off chain. firstSem starts at 1 so the first
 * thread proceeds immediately; secondSem and thirdSem start at 0 so those threads block until
 * their predecessor releases the next permit. third() releases firstSem to restore the initial
 * state, making the object reusable. No busy-waiting — blocked threads sleep in the OS scheduler.
 */
public class E_PrintInOrder {
        private Semaphore firstSem = new Semaphore(1);
    private Semaphore secondSem = new Semaphore(0);
    private Semaphore thirdSem = new Semaphore(0);

    public E_PrintInOrder() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        firstSem.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondSem.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondSem.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdSem.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdSem.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        firstSem.release();
    }
}
