package hwonline.testing;

import java.util.Scanner;

/**最长公共子串
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/4/9 21:41
 */
public class HJ65 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

    }

    public static void longStr(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();

        String shortStr = len1 > len2?str2:str1;
        String longStr  = len1 > len2?str1:str2;

        int maxLen = 0, start = 0;
        for (int i = 0; i < shortStr.length(); i++) {
            // 剪枝，子串长度已经不可能超过maxLen，退出循环
            if(shortStr.length() - i + 1 <= maxLen ){
                break;
            }

            int j,k;
            // j 表示左指针，k表示右指针，右指针逐渐向左指针靠近
            for(j =i,k=shortStr.length();k > j; k--){
                String subStr = shortStr.substring(j, k);

                if(longStr.contains(subStr) && maxLen < subStr.length()){
                    maxLen = subStr.length();
                    start = j;
                    break;
                }
            }
        }
        System.out.println(shortStr.substring(start, start + maxLen));
    }

}
