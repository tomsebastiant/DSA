package problems.design;

/**
 * LC: 362
 * Tags: Array
 * Tags: Design
 * https://leetcode.com/problems/design-hit-counter/
 * Design a hit counter which counts the number of hits received in the past 5 minutes
 * (i.e., the past 300 seconds). The timestamp is in seconds and calls are made in
 * chronological order with monotonically increasing timestamps. Multiple hits may arrive
 * at the same timestamp.
 *
 * Constraints:
 * 1 <= timestamp <= 2 * 10^9
 * All calls to hit and getHits are made in chronological order (non-decreasing timestamp)
 * At most 300 calls will be made to hit and getHits
 *
 * Example:
 *
 * Input:  hit(1), hit(2), hit(3), getHits(4), hit(300), getHits(300), getHits(301)
 * Output: [null, null, null, 3, null, 4, 3]
 * Explanation: getHits(4) sees hits at 1,2,3 — all within [4-299,4]. getHits(301) no longer
 *              counts the hit at timestamp 1 because 301-1 = 300 >= 300 (outside the window).
 *
 * Approach: Circular buffer over exactly 300 slots — one per second in the sliding window.
 * Each slot stores the last timestamp written to it and the hit count for that timestamp.
 * Slot index = timestamp % 300 (pigeonhole: any two timestamps 300 apart share a slot but
 * can never both be live at the same time). On hit, detect a stale slot by comparing the
 * stored timestamp; if stale, reset to 1, otherwise increment. On getHits, sum all slots
 * whose stored timestamp falls within the past 300 seconds. Both operations are O(1) / O(300).
 *
 * Follow-up (high hit volume): this design already handles bursts at the same timestamp
 * because hits are aggregated per-second in a single counter, not stored individually.
 */
public class M_HitCounter {
    private int[] times;  // times[i] = the timestamp that last claimed slot i
    private int[] hits;   // hits[i]  = number of hits recorded for that timestamp

    // NOTE: constructor name should be M_HitCounter() to match the class — currently HitCounter()
    public M_HitCounter() {
        // 300 slots = one per second across the 5-minute sliding window
        times = new int[300];
        hits = new int[300];
    }

    public void hit(int timestamp) {
        int idx = timestamp % 300;  // map any timestamp into [0, 299] cyclically
        if (times[idx] != timestamp) {
            // slot belongs to a timestamp from a previous cycle — claim it for this second
            times[idx] = timestamp;
            hits[idx] = 1;
        } else {
            // slot already belongs to this exact second — accumulate the hit
            hits[idx]++;
        }
    }

    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            // a slot is within the window if its timestamp is less than 300 seconds ago;
            // using strict < 300 matches the "past 5 minutes" definition (301 - 1 = 300 is OUT)
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }
}
