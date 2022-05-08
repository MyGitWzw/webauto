package hwonline.testing;

import org.testng.annotations.Test;

import java.awt.*;
import java.util.Scanner;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/3/31 20:04
 */
public class od20220327 {


    @Test
    public void twoPointDistance(){



        int res = 2;

        String s = Integer.toBinaryString(11);
        System.out.println(s);

//        int[] p1 = {2,-1};
//        int[] p2 = {1,2};
//
//
//        res = getDistance(p1,p2);
//
//        System.out.println(res);

//        return res;
    }

    public int getDistance(int[] p1,int[] p2){
        int res = 0;
        double pow1 = Math.pow((int) (p1[0] - p2[0]), 2);
        double pow2 = Math.pow((int) (p1[1] - p2[1]), 2);
        res = (int)(pow1 + pow2);

        return res;
    }

    public void shaizi(){

        int[] shaizi = {1,2,3,4,5,6};
    }

}
