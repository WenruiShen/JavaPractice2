package exam;

import java.util.Scanner;

/*
 * 华为：牛客网。
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * input: hello world
 * output: t
 */
public class Huawei_train_20190313 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String s = "";
        while(input.hasNextLine()){
            s = input.nextLine();
            //String[] split = s.split(" ");
            //System.out.println(split[split.length - 1].length());
            System.out.println(s.length() -1 - s.lastIndexOf(" "));
        }
    }
}
