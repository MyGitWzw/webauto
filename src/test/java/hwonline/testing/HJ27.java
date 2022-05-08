package hwonline.testing;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/4/8 21:10
 */
public class HJ27 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] ss = str.split(" ");
        int n = Integer.parseInt(ss[0]);
        int k = Integer.parseInt(ss[ss.length - 1]);
        String x = ss[ss.length - 2];

        List<String> list = new ArrayList();

        for (int i = 0; i <= n; i++) {
            boolean flag = isBrother(x, ss[i]);
            if (flag) {
                list.add(ss[i]);
            }
        }
        int size = list.size();
        System.out.println(size);

        if(size>=k){
            Collections.sort(list);
            System.out.println(list.get(k-1));
        }

    }


    public static boolean isBrother(String x,String y){
        if (x.length()!=y.length()||y.equals(x)){
            return false;
        }
        char[] s = x.toCharArray();
        char[] j= y.toCharArray();
        Arrays.sort(s);
        Arrays.sort(j);
        return new String(s).equals(new String(j));


    }
    

}
