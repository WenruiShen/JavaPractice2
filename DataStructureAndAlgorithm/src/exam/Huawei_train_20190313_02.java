package exam;

import java.util.Scanner;

/*
 * 华为：牛客网。
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 * input: ABCDEF
 *        A
 * output: 1
 */
public class Huawei_train_20190313_02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine().toLowerCase();
        Character chr = input.nextLine().toLowerCase().charAt(0);
        int count = 0;
        for(Character ele : str.toCharArray()){
            if(ele == chr){
                count++;
            }
        }
        System.out.println(count);
    }
}
