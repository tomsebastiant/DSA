package leetcode.array;

/**
 Tags: #TwoPointer #Greedy
 https://leetcode.com/problems/container-with-most-water
 You are given an integer array height of length n. There are n vertical lines drawn such
 that the two endpoints of the ith line are (i, 0) and (i, height[i]).

 Find two lines that together with the x-axis form a container, such that the container
 contains the most water.

 Return the maximum amount of water a container can store.

 Notice that you may not slant the container.

 Approach: The volume of water is constrained by the height of the lower edge. So we start from both far ends and
 move inwards from the shorter edge to see if we get more volume.
 */
public class M_11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int maxWater=0;
        while(l<r){
            if(height[l]<height[r]){
                maxWater= Math.max(maxWater,height[l]*(r-l));
                l++;
            } else {
                maxWater= Math.max(maxWater,height[r]*(r-l));
                r--;
            }
        }
        return maxWater;
    }
}
