package hwonline.testing;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/4/3 22:10
 */
public class HJ52 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int lens1 = s1.length();
        int lens2 = s2.length();

        int len= lens1 > lens2 ? lens2 : lens1;

        HashMap<Integer,Character> map = new HashMap<Integer, Character>();

        // 以s1为基准串
        int i = 0;

        for (i = 0; i < len; i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                map.put(i,s2.charAt(i));
            }
        }
        int res = Math.abs(lens1-lens2);
        res += map.size();

        System.out.println(res);
        }
}
