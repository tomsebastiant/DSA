package leetcode.array;


/**
 Tags: Greedy
 https://leetcode.com/problems/can-place-flowers
 You have a long flowerbed in which some of the plots are planted,
 and some are not. However, flowers cannot be planted in adjacent plots.

 Given an integer array flowerbed containing 0's and 1's, where 0 means
 empty and 1 means not empty, and an integer n, return true if n new flowers
 can be planted in the flowerbed without violating the no-adjacent-flowers
 rule and false otherwise.



 Example 1:

 Input: flowerbed = [1,0,0,0,1], n = 1
 Output: true
 Example 2:

 Input: flowerbed = [1,0,0,0,1], n = 2
 Output: false


 Approach:
 Check the left and right of every empty plot to check if it is empty
 or a boundary. If both are empty then decrement n
 */

public class E_605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                boolean left = (i==0) || flowerbed[i-1] == 0;
                boolean right = (i==flowerbed.length-1) || flowerbed[i+1] == 0;
                if(left && right){
                    flowerbed[i]=1;
                    n--;
                }
            }
        }
        return n<=0;
    }

}
