package problems.concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * LC: 1117
 * Tags: Design
 * https://leetcode.com/problems/building-h2o/
 * There are two kinds of threads: hydrogen and oxygen. Your goal is to group these threads to
 * form water molecules. There is a barrier where each thread must wait until a complete molecule
 * (exactly 2 hydrogen + 1 oxygen) can be formed. Threads from one molecule must all bond before
 * any thread from the next molecule begins. The output within a molecule can be in any order
 * (e.g. "HHO", "HOH", "OHH" are all valid).
 *
 * Constraints:
 * The input string consists only of 'H' and 'O'.
 * There will be exactly (2 * n) hydrogen threads and n oxygen threads for some n >= 1.
 * 1 <= input.length <= 50
 *
 * Example 1:
 *
 * Input: water = "HOH"
 * Output: "HHO", "HOH", or "OHH"
 * Explanation: One molecule forms from the single H, O, H in any order.
 *
 * Example 2:
 *
 * Input: water = "OOHH"
 * Output: "HHOO", "HOHH", "OHHO", etc.
 * Explanation: Two complete molecules must form; output within each molecule can be in any order.
 *
 * Approach: Two semaphores cap the in-flight count for each atom type (hSem=2, oSem=1), ensuring
 * no molecule can have more than 2H or more than 1O. A CyclicBarrier(3) then forces all three
 * threads to rendezvous before any prints its atom — guaranteeing complete molecules. The barrier
 * auto-resets after each trip, so the same instance handles every successive molecule without
 * reinitialisation. barrier.await() is called BEFORE releaseXxx.run() so no atom is emitted
 * until the full molecule has assembled.
 *
 * Why CyclicBarrier over CountDownLatch: CountDownLatch is single-use and cannot reset;
 * CyclicBarrier resets automatically after every group of 3, composing cleanly over n molecules.
 */
public class M_BuildH2O {
    private Semaphore oSem;
    private Semaphore hSem;
    private CyclicBarrier barrier;

    public M_BuildH2O() {
        oSem = new Semaphore(1);  // at most 1 oxygen in-flight — prevents 2 O's joining one molecule
        hSem = new Semaphore(2);  // at most 2 hydrogens in-flight — prevents 3 H's crowding out an O
        barrier = new CyclicBarrier(3); // trips when 2H + 1O have all arrived; auto-resets for next molecule
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        hSem.acquire();
        try {
            barrier.await();           // wait until 2H + 1O are all ready; no H prints until O arrives
            releaseHydrogen.run();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            hSem.release();            // free the slot for the next molecule's hydrogen
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        oSem.acquire();
        try {
            barrier.await();           // wait until both H threads are also ready
            releaseOxygen.run();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            oSem.release();            // free the slot for the next molecule's oxygen
        }
    }
}
