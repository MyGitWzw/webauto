package DP;

import java.util.Arrays;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/3/9 21:28
 */
public class LIS {

    public int lis(int[] a) {
//        int[] a = {10,9,2,5,3,7,109,18};

        int[] dp = new int[a.length];
        Arrays.fill(dp,1);

        int res = 0;

        if(a.length==0){
            res = 0;
            return  res;
        }else if(a.length ==1){
            res = 1;
            return res;
        }

        for(int i = 0; i<a.length;i++){

            for (int j = 0; j < i; j++) {
                if(a[j] < a[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }

            }

        }




        return res;

    }
}
