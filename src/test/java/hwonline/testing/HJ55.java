package hwonline.testing;

import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ55 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer count= 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                Character key = entry.getKey();
                break;
            }
        }

        int sevenTime = sevenTimes(n);
        int containTime = containSeven(n);
        System.out.println(sevenTime + containTime);
    }

    public static int sevenTimes(int n){
        int times = 0;

        for(int i = 0; i < 7; i++){
            if( (n-i)%7 == 0 && (n-i) > 0){
                times = (n-i)/7;
            }
        }
        return times;
    }

    public static int containSeven(int n){
        int containTimes = 0;

        for(int i = 0; i < 7; i++){
            while((n-i)>10 && (n-i)% 10 == 7 && (n-i)%7 != 0){
                containTimes++;
                n = n-10;
            }
        }

        return containTimes;
    }

    @Test
    public void testTimes(){
        int n = 41;
        int sevenTime = sevenTimes(n);

        int containTime = containSeven(n);

        System.out.println(sevenTime);
        System.out.println(containTime);
    }

}
