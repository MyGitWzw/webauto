package DP;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/3/27 15:48
 */
public class CoinChange_669 {

    public int coinChangeSolutions(int[] A, int M){
        // where A coins, such as A = {2,5,7};
        // where M is the money need to coin changes

        int n = A.length;
        int[] f = new int[M+1]; // index should be in 0,...,M
        f[0] = 0;
        for (int i = 0;i<=M;i++){
            f[i] = Integer.MAX_VALUE;
            // 最后一枚硬币为2,5,7的情况, 取f[i - A[j]](0<=j<n)的最小值
            for (int j = 0; j < n ; j++) {
                if(i >= A[j] && f[i-A[j]]!=Integer.MAX_VALUE && f[i-A[j]] + 1 < f[i]){
                    f[i] = f[i-A[j]] + 1;
                }
            }
        }

        if(f[M] == Integer.MAX_VALUE){
            return -1;
        }else{
            return f[M];
        }

    }
}
