package hwonline.testing;

import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/4/6 21:04
 */

/*
* 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，
* 从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
输入：
合法坐标为A(或者D或者W或者S) + 数字（两位以内）
坐标之间以;分隔。
非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
下面是一个简单的例子 如：
A10;S20;W10;D30;X;A1A;B10A11;;A10;
处理过程：
起点（0,0）
+   A10   =  （-10,0）
+   S20   =  (-10,-20)
+   W10  =  (-10,-10)
+   D30  =  (20,-10)
+   x    =  无效
+  A1A   =  无效
+   B10A11   =  无
+  一个空 不影响
+   A10  =  (10,-10)
结果 （10， -10）
* ***/

public class HJ17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(";");

        int x = 0;
        int y = 0;

        for (String str:strs) {
            // 不满足题目给定坐标规则
            if(!str.matches("[WASD][0-9]{1,2}")){
                continue;
            }
            String valStr = str.substring(1);
            int val = Integer.valueOf(valStr);
            switch (str.charAt(0)){
                case 'W':
                    y += val;
                    break;
                case 'S':
                    y -= val;
                    break;
                case 'A':
                    x -= val;
                    break;
                case 'D':
                    x += val;
                    break;
            }

        }
        System.out.println(x+","+y);

    }

    @Test
    public void test11(){
        String str = "A10;S20;W10;D30;X;A1;B10A11;;A10;";
        String[] split = str.split(";");

    }

}
