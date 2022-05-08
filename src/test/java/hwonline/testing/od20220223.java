package hwonline.testing;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 *作者：caicai、
 链接：https://www.nowcoder.com/discuss/845216
 来源：牛客网

 题目： 用数组代表每个人的权重，现在要进行组队权重大于等于N，每个队可以由1人或2人组队，
 且1个人只能参加1个队，计算可以派出最多的符合要求的团队
 输入三行
 第一行：代表数组长度
 第二行：数组的元素
 第三行：最小权重

 示例：
 5
 3 1 5 7 9
 8
 输出：3 解释：[ 3 5 ] [ 1 7 ] [ 9 ]

 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/3/30 20:56
 */
public class od20220223 {

    /**
     *
     * @param size : 代表数组长度
     * @param numbers : 数组的元素
     * @param power : 最小权重
     */
    public int helper(int size,int[] numbers,int power){
        int res = 0;

        if(size <= 1){
            return -1;
        }

        int maxValue = Integer.MAX_VALUE;

        for (int i = 0; i < size ; i++) {
            if(numbers[i] >= power){
                res++;
                numbers[i] = maxValue;
            }
        }

        for (int i = 0; i < size-1 ; i++) {

            for (int j = i+1; j < size; j++) {
                if(numbers[i] != maxValue && numbers[j] != maxValue &&
                        numbers[i] + numbers[j] >=power ){
                    res++;
                    numbers[i] = maxValue;
                    numbers[j] = maxValue;
                }
            }
        }
        return res;
    }

    @Test
    public void testHelper(){
        int size = 5;
        int[] numbers = {3,1,5,7,9};
        int power = 8;

        int res = helper(size,numbers,power);
        System.out.println(res);

    }


    /**
     * 作者：caicai、
     链接：https://www.nowcoder.com/discuss/845216
     来源：牛客网

     第二题 ：给你一个数组，让你找出数组里面 最大 N 个数和最小 N 个数相加的合，
     如果 最大 N 个数和最小 N 个数有重复，返回-1， 其他不符合条件返回-1
     （比如 N比数组长度还大，其他的不符合条件我想不到了）
     * @param size :第一行：代表数组大小
     * @param numbers : 第二行：数组元素
     * @param n : 第三行：代表N
    示例1：
    5
    3 1 5 7 9
    2
    输出：20 解释：最大两个是7和9，最小的两个是1和3 相加等于20
     *
     *
    示例2：
    5
    5 1 5 5 9
    2
    输出：-1 解释：最大两个是5和9，最小的两个是1和5 存在相同的数返回-1
     */
    public int helper2(int size,int[] numbers,int n){
        int minRes = 0,maxRes = 0;

        if(size <= 1 || n <= 0 || n >= size ){
            return -1;
        }

        int[] maxN = new int[n];
        int[] minN = new int[n];
        Arrays.sort(numbers);
        for (int i = 0; i <size; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println();

        for(int i = 0;i < n; i++){
            minN[i] = numbers[i];
            minRes += numbers[i];

            maxN[i] = numbers[size-1-i];
            maxRes += numbers[size-1-i];
        }

        for (int j = 0; j < n ; j++) {
            for (int k = 0; k < n; k++) {
                if(maxN[j]== minN[k]){
                    return -1;
                }
            }
        }
        return  maxRes + minRes;

    }

    @Test
    public void testHelper2(){
        int size = 5;
        int[] numbers = {5,1,5,5,9};
        int n = 2;

        int i = helper2(size, numbers, n);
        System.out.println("i = " +i);
    }





}
