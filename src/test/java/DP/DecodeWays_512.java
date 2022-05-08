package DP;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/3/12 16:09
 */
public class DecodeWays_512 {

    public int solutions(String ss){
        char[] chars = ss.toCharArray();
        int n = chars.length;
        if(n == 0){
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n ; i++) {

            dp[i] = 0;
            int t = chars[i] -'0';
            if(t >= 1 & t <= 9){
                dp[i] += dp[i+1];
            }

            if(i >= 2){
                t = (chars[i-2]-'0')*10 + (chars[i-1] - '0');

                if(t >= 10 && t <= 26){
                    dp[i] += dp[i+2];
                }
            }

        }

        return dp[n];
    }
}
