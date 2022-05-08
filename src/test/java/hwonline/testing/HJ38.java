package hwonline.testing;

import java.util.Scanner;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/4/3 20:42
 */
public class HJ38 {
    private static int N = 5;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double height = sc.nextDouble();

        double sum = height;
        double heightOfN = 0;

        for(int i = 0;i < N;i++){
            height = height/2;

            //第五次落下实际只反弹了四次，所以最后的sum要减去 2*height
            sum += 2*height;

        }
        //最后的sum要减去 2*height
        sum = sum-2*height;
        System.out.println(sum);
        System.out.println(height);

    }

}
