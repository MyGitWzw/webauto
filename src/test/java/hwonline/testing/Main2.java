package hwonline.testing;

import java.util.HashMap;
import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
        String str = "10,5,9,4,6";
        String[] split = str.split(",");

        long[] looong = new long[split.length];
        for (int i = 0;i < split.length;i++){
            looong[i] = Long.parseLong(split[i]);
        }

        long res = 0;
        HashMap<Integer, Long> map = new HashMap<>();

        for (int i = 1; i < looong.length; i++) {
            map.put(i,i*looong[i]);

            for(int j = 1; j < i ; j++){
                if( looong[i] > looong[j]){
                    long tep = looong[j];
                    res = i * looong[j];
                }else{
                    res = i*looong[i];
                }
            }
        }

        System.out.println(res);


    }



}
