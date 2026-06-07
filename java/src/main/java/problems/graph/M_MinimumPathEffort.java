package problems.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class M_MinimumPathEffort {
        public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;

        int[][] dp = new int[m][n];
        int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};

        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        dp[0][0]=0;
        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int i=curr[0];
            int j=curr[1];
            int dist=curr[2];
            dp[i][j]=Math.min(dp[i][j],dist);
            for(int[] dir:dirs){
                int ni=i+dir[0];
                int nj=j+dir[1];
                if(ni>=0 && ni<m && nj>=0 && nj<n){
                    int newDist=Math.max(dist,Math.abs(heights[i][j]-heights[ni][nj]));
                    if(newDist<dp[ni][nj]){
                        pq.offer(new int[]{ni,nj,newDist});
                    }
                }
            }
        }
        return dp[m-1][n-1];


    }
}
