package problems.binarysearch;

/**
 * LC: 875
 * Tags: Array
 * Tags: BinarySearch
 * https://leetcode.com/problems/koko-eating-bananas/
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * Koko can eat at most k bananas per hour. Each hour she chooses a pile and eats k bananas from
 * it; if the pile has fewer than k bananas she eats them all and waits. Return the minimum integer
 * k such that she can eat all bananas within h hours.
 *
 * Example 1:
 *
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 *
 * Example 2:
 *
 * Input: piles = [30,11,23,5,19], h = 5
 * Output: 30
 *
 * Example 3:
 *
 * Input: piles = [30,11,23,5,19], h = 6
 * Output: 23
 *
 * Approach: Binary search on the answer in range [1, max(piles)]. For each candidate speed mid,
 * check if all piles can be finished in h hours using ceiling division (pile/k + remainder check).
 * Shrink right when feasible, push left otherwise. The minimum feasible speed converges at l==r.
 */
public class M_KokoCanEatBanana {
        public int minEatingSpeed(int[] piles, int h) {
        int max =0;
        for(int pile:piles){
            max=Math.max(max,pile);
        }

        int l=1;
        int r=max;
        while(l<r){
            int mid=l+(r-l)/2;
            if(canEat(piles,h,mid)){
                r=mid;
            } else {
                l=mid+1;
            }
        }
        return r;
    }

    public boolean canEat(int[] piles,int h,int k){
        int time=0;
        for(int i=0;i<piles.length;i++){
            time=time+piles[i]/k;
            if(piles[i]%k!=0) time++;
            if(time>h) return false;
        }
        return true;
    }
}
