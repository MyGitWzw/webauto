package hwonline.testing;

import java.util.Scanner;

/**
 * @author m
 * @Description 整数与IP地址间的转换
 * 一。题目要求：
 * 输入：
 * 1.输入IP地址 —— 输出：整数
 * 2. 输入整数 —— 输出：IP地址
 *
 * 二、思路：（1）ip->整数
 * 1. 分割IP地址为4个整数
 * 2. 每个整数转化为各自的2进制，拼接起来
 *        不足8位的二进制，要在前面补0;[倒着遍历]
 * 3. 将2中的2进制字符串转化为10进制
 *
 * （2）逆过程：整数->ip
 * 1. 10进制整数转为2进制字符串
 * 2. 每8位进行分隔
 * 3. 对每8位的2进制字符串转为10进制整数
 * @creat 2021-07-19
 */
public class IP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            long res1 = encode(s1);
            System.out.println(res1);
            String res2 = decode(s2);
            System.out.println(res2);

        }
    }

    static long encode(String s){
        String[] str = s.trim().split("\\."); //坑1：split函数，以"."分隔时，要加转义字符"\\."
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length;i++){
            String s1 = Integer.toBinaryString(Integer.parseInt(str[i]));//十进制-2进制
            if(s1.length()<8){
                for(int j=0;j<8-s1.length();j++){//10进制转2进制时，不足8位的补0至8位
                    sb.append("0");//
                }
            }
            sb.append(s1);//补完0以后，再添加字符串
        }
        //2进制-10进制
        long res = Long.parseLong(sb.toString(),2);
        return res;
    }

    static String decode(String s){
        //1.10进制数-2进制字符串：
        String s22 = Long.toBinaryString(Long.parseLong(s));
        //不足32位的，要在前面补32-N个0；
        StringBuilder s2 = new StringBuilder();
        if(s22.length()<32){
            for(int j=0;j<32-s22.length();j++){
                s2.append("0");
            }
        }
        s2.append(s22);

        //2.每8位进行分隔
        String[] ss = new String[4];
        StringBuilder res = new StringBuilder();
        for(int i=0;i<ss.length;i++){
            ss[i] = s2.substring(8*i,8*(i+1));
            //3.对每8位的2进制字符串转为10进制整数
            int num = Integer.parseInt(ss[i],2);
            res.append(num).append(".");
        }

        res.deleteCharAt(res.length()-1);//删除最末尾多余的"."
        return res.toString();
    }
}
