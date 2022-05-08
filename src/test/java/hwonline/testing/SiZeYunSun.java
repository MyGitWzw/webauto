package hwonline.testing;

import java.util.Scanner;
import java.util.Stack;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/4/5 17:23
 */
public class SiZeYunSun {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

//        String s = "3+2*{1+2*[-4/(8-6)+7]}";

//        s = s.replace("[","(");
//        s = s.replace("{","(");
//        s = s.replace("]",")");
//        s = s.replace("}",")");
        int res = slove(s);
        System.out.println(res);

    }

    public static int slove(String s){
        Stack<Integer> stack=new Stack<>();
        int len = s.length();
        char[] chars = s.toCharArray();

        char sign = '+';
        //记录数字
        int number = 0;
        for (int i = 0; i < len; i++) {

            char ch = chars[i];
            // 遇到空格，则跳过
            if(ch == ' ') continue;

            if(Character.isDigit(ch)){
                number = number * 10 + ch -'0';
            }

            //如果当前字符是小括号的左括号
            if(ch == '('){
                int j = i+1;
                // 统计括号的数量
                int count = 1;
                while(count > 0){
                    if(chars[j] == ')') count--; //遇到右括号，括号数-1
                    if(chars[j] == '(') count++; //遇到左括号，括号数+1
                    j++;
                }
                number = slove(s.substring(i + 1, j - 1));
                i = j - 1;
            }

            //遇到符号，将数字处理后放进栈
            if(!Character.isDigit(ch) || i == len-1){
                if(sign == '+'){
                    stack.push(number);
                }else if(sign == '-'){
                    stack.push(-1 * number);
                }else if(sign == '*'){
                    stack.push(stack.pop()*number);
                }else if(sign == '/'){
                    stack.push(stack.pop()/number);
                }
                // 更新符号
                sign = ch;

                // 刷新数字
                number = 0;
            }
        }

        //栈中数字求和得到结果
        int ans = 0;
        while(!stack.empty()){
            ans += stack.pop();
        }
        return ans;

    }

}
