package DP;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/3/26 15:45
 */
public class HouseRobber_392 {

    public long houseRobberSolution(int[] A){

        int n = A.length;
        if(n == 0) return 0;

        long[] f = new long[A.length +1];
        f[0]=0;
        f[1] = A[0];
        for (int i = 0; i <=n ; i++) {
            f[i] = Math.max(f[i-1],f[i-2] + A[i-1]);
        }
        return f[n];
    }

}
