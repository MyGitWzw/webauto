package hwonline.testing;

import org.testng.annotations.Test;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/3/30 21:53
 */
public class od20220221 {

    public int stringIntSum(String str){
        // such as String = "-xyz-125-90A37-8BA-";
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '-' && i+1 < str.length()
                        && (str.charAt(i+1) - '0') >= 0 && (str.charAt(i+1) - '9') <= 0 ){

                    res += -(str.charAt(i+1) - '0');
                    i = i+1;
                }else if(str.charAt(i) - '0' >= 0 && str.charAt(i) - '9' <= 0){
                    res += (str.charAt(i) - '0');
                }
        }

        return res;
    }


    @Test
    public void teststringIntSum(){
        String s= "-xyz-125-90A37-8BA-";

        int i = stringIntSum(s);
        System.out.println(i);
    }

    public void xiaoxiaole(String s){
         // case#1: ggA -> A
        // case#2 : abccbe -> ae

        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len; i++) {



        }


    }


}
