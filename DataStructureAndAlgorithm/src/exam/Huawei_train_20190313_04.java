package exam;
import java.util.Scanner;

/*
 * 华为：牛客网。
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 *
 * input: 0xA
 * output: 10
 *
 */
public class Huawei_train_20190313_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String str = input.next().substring(2);
            System.out.println(Integer.parseInt(str,16));
        }
        input.close();
    }
}
