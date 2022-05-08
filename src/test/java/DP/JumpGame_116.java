package DP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/3/27 17:04
 */
public class JumpGame_116 {

    public boolean jumpGameSolutions(Integer[] A){
        int n = A.length;

        Arrays.sort(A ,new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return 0;
            }

        });


        if(A == null || n == 0){
            return false;
        }
        boolean[] f = new boolean[n];
        f[0] = true;//初始条件
        for (int j = 1; j < n ; j++) {
            f[j] = false; //f[j]表示能不能跳到石头j

            //遍历石头j 前面的各个石头i,
            // 如果可以跳到石头i(即f[i]=true), 并且A[i] >= j-i,
            // 那么它一定可以跳到石头j,即f[j]= true
            for (int i = 0; i < j ; j++) {
                if(f[i] && A[i] >= j-i){ //
                    f[j] = true;
                    break;
                }
            }
        }
        return f[n-1];
    }

}
