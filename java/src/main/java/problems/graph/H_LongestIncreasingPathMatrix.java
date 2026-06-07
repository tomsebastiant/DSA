package problems.graph;

public class H_LongestIncreasingPathMatrix {
    int[][] memo;
    int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new int[m][n];
        int result =0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result = Math.max(result,dfs(i,j,matrix));
            }
        }
        return result;
    }

    public int dfs(int i,int j,int[][] matrix){
        if(memo[i][j]!=0) return memo[i][j];
        int m = matrix.length;
        int n = matrix[0].length;

        int best=1;
        for(int[] dir:dirs){
            int ni=i+dir[0];
            int nj=j+dir[1];
            if(ni>=0 && ni<m && nj>=0 && nj<n && matrix[ni][nj]>matrix[i][j]){
                best = Math.max(best,1+dfs(ni,nj,matrix));
            }
        }
        memo[i][j]=best;
        return best;
    }
}
