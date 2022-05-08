package DP;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/3/27 14:52
 */
public class PerfectSquares_513 {

    public int numSquares(int[] A){

        int n = A.length;
        if (A == null || n == 0) return 0;

        int[] f = new int[n];
        int i = 0,j = 0;
        for ( i = 1; i <= n ; i++) {
            f[i] = Integer.MAX_VALUE;
            for (j = 1;j <= i; j++){
                if(f[i - j*j] + 1 < f[i]){
                   f[i] = f[i - j*j] + 1;
                }
            }
        }
        return f[n];
    }
}
