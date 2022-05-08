package DP;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/3/27 16:37
 */
public class UniquePaths_114 {

    /**
     * positive integer (1<=n,m<=100)
     *
     * @param m
     * @param n
     */
    public int uniquePathsSolutions(int m,int n){

        int[][] f = new int[m][n];

        int i = 0,j = 0;
        // row
        for (i = 0; i < m ; i++) {
            // column
            for ( j = 0; j < n ; j++) {

                if(i==0 || j==0){
                    f[i][j] = 1; //corner case
                }else{
                                // up       left
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }

        return f[m][n];
    }
}
