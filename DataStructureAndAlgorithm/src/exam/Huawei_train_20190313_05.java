package exam;

import java.util.Scanner;

/*
 * 华为：牛客网。
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 *
 * input: 180
 * output: 2 2 3 3 5
 *
 */
public class Huawei_train_20190313_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long num = input.nextLong();
        String result = getResult(num);
        System.out.println(result);
        input.close();
    }

    public static String getResult(long num){
        long i = 2;
        String s = "";
        while(i <= num){
            if( num % i == 0){
                s = s + String.valueOf(i) + " ";
                num = num / i;
            }else {
                i++;
            }
        }
        return s;
    }
}
