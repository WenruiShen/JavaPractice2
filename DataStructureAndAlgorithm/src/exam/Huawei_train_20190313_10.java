package exam;

import java.util.Scanner;
import java.util.Stack;

/*
 * 华为：牛客网。
 * 计算后序表达式，输入后序表达式字符串，输出表达式计算的结果（其中A~F表示10~15）。例如：
 *
 * 案例       输入              输出
 * 案例一     32+5-    3+2-5     0
 * 案例二     A5-3+    10-5+3    4
 *
 * 解决方案：（采用栈）
 * 1. 读取输入结果字符串str
 * 2. 将输入字符串转换为字符数组char[]
 * 3. 判断每个字符
 *
 * 如果是数字，则直接入栈：arr[i] - ‘0’
 * 如果是大写字符，则转换之后入栈：arr[i] - ‘A’
 * 如果是运算符号：则弹出两个数值栈，然后根据符号计算结果后入栈
 *
 */
public class Huawei_train_20190313_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()){
            String line = input.nextLine();
            System.out.println(calculate(line));
        }
        input.close();
    }
    private static int calculate(String line){
        char[] charArray = line.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(Character ch : charArray){
            if(Character.isLetterOrDigit(ch)){
                stack.push(Integer.parseInt("" + ch, 16));
            }else {
                int num2= stack.pop();
                int num1= stack.pop();
                switch (ch){
                    case '+':
                        stack.push(num1+num2);
                        break;
                    case '-':
                        stack.push(num1-num2);
                        break;
                    case '*':
                        stack.push(num1*num2);
                        break;
                    case '/':
                        stack.push(num1/num2);
                        break;
                }
            }

        }
        return stack.pop();
    }
}
