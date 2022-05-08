package DP;

import org.testng.annotations.Test;

import java.util.HashMap;


/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/3/12 14:47
 */
public class PaintHouse_515 {

    public int paintHouseSolutions(int[][] costs){
        int n = costs.length;// n 表示房子的数量
        if(n ==0) {return 0;}

        int[][] dp = new int[n+1][3];// 房子从 dp[0],...,dp[n]
        int i,j,k,res;
        dp[0][0]=dp[0][1]=dp[0][2]=0;

        for (i = 1; i <=n ; i++) {// 遍历，从前1栋房子 到 前n栋房子
            // j is the color of house i - 1
            for ( j = 0; j < 3; j++) {
                // k is the color of house i - 2
                for ( k = 0; k < 3 ; k++) {
                    dp[i][j] = Integer.MAX_VALUE;

                    if (j == k){ continue; }// 相邻两栋房子不能撞色

                    if(dp[i-1][k] + costs[i-1][j] < dp[i][j]){
                        // dp[i-1][k]表示 前 i-1栋房子且i-2栋颜色为k的最小话费
                        // costs[i-1][j]表示 第i-1栋房子涂油漆的花费
                        // dp[i][j] 表示前i 栋房子且 i-1栋颜色为j的最小话费
                        dp[i][j] = dp[i-1][k] + costs[i-1][j];

                    }

                }

            }

        }


        res = dp[n][0];
        if(dp[n][1] < res){
            res = dp[n][1];
        }
        if(dp[n][2] < res){
            res = dp[n][2];
        }

        return res;
    }

    public int helper1(int size,int[] number,int power){
        int n = number.length;
        int oneperson = 0,twoperson = 0;
        if(n == 0) return 0;
        if(size <= 0){
            return 0;
        }

        int max = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if(number[i] >= power){
                oneperson++;
                number[i]=max;
            }
        }


        for (int i = 0; i < n - 1 ; i++) {
                for (int j = i+1; j < n ; j++) {
                    if((number[i] + number[j]) >= power
                            && number[i] != max
                            && number[j] != max ){
                        twoperson++;
                        number[i] = max;
                        number[j] = max;
                    }
                }
            }

        return oneperson + twoperson;
    }

    @Test
    public void tstHelper1(){
        int size = 6;
        int[] number = {9,3,1,5,8,10};
        int power = 8;

        int i = helper1(size, number, power);
        System.out.println(i);

    }

    public int  helper2(int size,int[] number,int n){


        int len = number.length;

        int i=0,j=0,res = 0;
        if(n<=0) return -1;

        if(len<=n){
            return -1;
        }


        //排序
        for( i = 1;i < len; i++){

            int temp = number[i];

            for(j = i;number[j]<=number[j-1] && j > 0 ;j-- ){
                number[j] = number[j-1];
            }
            number[j] = temp;
        }


        int tempRes = 0;
        for(int k = 0;k < n;k++){
            tempRes += (number[len-k-1] + number[k]);
        }

        res = tempRes;

        for (int b = 0;b < n; b++){
            for(int s = 0; s < n; s++){
                if (number[len-b-1] == number[s]){
                    res = -1;
                    break;
                }
            }
        }

        return  res;
    }

    public void helper0215(String s){


        char[] chars = s.toCharArray();


        int len = chars.length;
        String res = null;

        for (int i = 0; i < len-1 ; i++) {
            //ggA,
            // removeTimes
//            int removeTimes = 0;
            if(chars[i] == chars[i+1] ){
                chars[i] ='0';
                chars[i+1] = '0';
//                removeTimes++;
            }else if(chars[i] == chars[len-1 -i]){
                chars[i] ='0';
                chars[len-1 -i] = '0';
//                removeTimes++;
            }

            if(i > 0 && i+2 < len){
                if(chars[i-1] == chars[i+2] ){
                    chars[i-1] ='0';
                    chars[i+2] = '0';
                }
            }


        }


    }

    public int deleteFromTarget(String source,String target){
        int pos = 0;

        int lenSour,lenTarget;
        lenSour = source.length();
        lenTarget = target.length();

        if( source == null || target == null || lenSour == 0 || lenTarget == 0){
            return -1;
        }

        char[] sourceChars = source.toCharArray();
        char[] targetChars = target.toCharArray();

        int[] containsSource = new int[sourceChars.length];
        int firstCharIndexInTarget=0;

        for (int i = 0; i < sourceChars.length; i++) {

            char c = sourceChars[i];
            char firstchar = sourceChars[0];
            for (int j = 0; j < targetChars.length; j++) {

                int l = j;
                if(targetChars[j] == c){
                    containsSource[i] = l++;
                    if(firstCharIndexInTarget == 0){
                        firstCharIndexInTarget = j+1;
                    }
                }


            }
        }

        for (int k = 0; k < lenSour; k++) {
            if(containsSource[k] == 0){
                pos = -1;
            }else if(firstCharIndexInTarget < containsSource[1]){
                pos = containsSource[0];
            }

        }



        return pos;
    }


}
