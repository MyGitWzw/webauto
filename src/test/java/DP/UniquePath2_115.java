package DP;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/3/12 14:10
 */
public class UniquePath2_115 {

    public int uniquePathWithObstacle(int[][] A){
        int m = A.length;// m is the row number of A
        if(m == 0) return 0;

        int n = A[0].length; // n is the column number of A
        if (n == 0) return 0;

        int[][] dp = new int[m][n];
        int i,j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {

                if(A[i][j] == 1){// 如果遇到障碍时
                    dp[i][j] = 0;
                }else{
                    if(i == 0 && j == 0){ // 左上角的那个格子
                        dp[i][j] = 1;
                    }else{// 左上角以外的格子
                        dp[i][j] = 0; // 由于dp[i-1][j]已经算过了，所以dp[i][j] = 0 没有关系的

                        if(i-1 >= 0 ){
                            dp[i][j] += dp[i-1][j];
                        }

                        if(j-1 >= 0){
                            dp[i][j] += dp[i][j-1];
                        }
                    }
                }

            }

        }

        return dp[m-1][n-1];
    }
}
