package problems.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * LC: 1116
 * Tags: Design
 * https://leetcode.com/problems/print-zero-even-odd/
 * You have three threads that share a single ZeroEvenOdd instance. Thread A calls zero(),
 * thread B calls even(), and thread C calls odd(). Coordinate them so they together output
 * the interleaved sequence "010203...0n" — every number 1..n preceded by a zero.
 *
 * Constraints:
 * 1 <= n <= 1000
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: "0102"
 *
 * Example 2:
 *
 * Input: n = 5
 * Output: "0102030405"
 *
 * Approach: Three semaphores implement a zero→(odd|even)→zero hand-off cycle. Unlike a simple
 * two-thread ping-pong (see M_FoobarAlternate), the zero thread must make a routing decision
 * after each print: if the current iteration index is odd the next number to print is odd, so
 * the token goes to oddSem; if even, it goes to evenSem. The receiving thread prints its number
 * and unconditionally returns the token to zeroSem to start the next iteration. zeroSem starts
 * at 1 so the zero thread runs first; oddSem and evenSem start at 0 so those threads block
 * until explicitly woken by zero.
 */
public class M_ZeroEvenOdd {
    private int n;

    // zeroSem(1)  — zero thread holds the token at startup and runs first
    // oddSem(0)   — odd thread blocks until zero routes the token here (odd iteration)
    // evenSem(0)  — even thread blocks until zero routes the token here (even iteration)
    private Semaphore zeroSem = new Semaphore(1);
    private Semaphore oddSem  = new Semaphore(0);
    private Semaphore evenSem = new Semaphore(0);

    public M_ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++){
            zeroSem.acquire();          // wait for the token — first iteration is free (permit=1)
            printNumber.accept(0);
            // routing: iteration i means the next value to print is i
            // odd i  → wake the odd thread;  even i → wake the even thread
            if(i%2!=0){
                oddSem.release();
            } else {
                evenSem.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i+=2){
            evenSem.acquire();          // block until zero hands us the token for an even turn
            printNumber.accept(i);
            zeroSem.release();          // return the token to zero for the next iteration
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i+=2){
            oddSem.acquire();           // block until zero hands us the token for an odd turn
            printNumber.accept(i);
            zeroSem.release();          // return the token to zero for the next iteration
        }
    }
}
