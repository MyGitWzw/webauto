package hwonline.testing;

import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/4/10 13:10
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            int n = sc.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = sc.nextLine();
            }

            for (int i = 0; i < n; i++) {
                String substr = strs[i];
                int len = substr.length();
                // 得到偏移数组
                long[] a = offset(len);

                String res = "";
                for (int j = 0; j < len; j++) {
                    long offsetchar = a[j];
                    long temp = (substr.charAt(j) - 'a' + offsetchar + 1);

                    if (temp > 26 && (substr.charAt(j)) + offsetchar > 'z') {
                        temp = temp % 26;
                        char translate = (char) ('a' - 1 + temp);
                        res += translate;
                    } else {
                        char translate = (char) (substr.charAt(j) + offsetchar);
                        res += translate;
                    }
                }
                System.out.println(res);
            }
        }
    }

    public static long[] offset(int len){

        long[] res = new long[len];


        if(len == 1){
            res[0] = 1;
        }else if(len == 2){
            res[0] = 1;res[1] = 2;
        }else if(len == 3){
            res[0] = 1;res[1] = 2; res[2] = 4;
        }else if(len >= 4){
            res[0] = 1;res[1] = 2; res[2] = 4;
            for(int i = 3;i<len;i++){
                res[i] = res[i-1]+res[i-2]+res[i-3];
            }
        }

        return res;
    }

}
