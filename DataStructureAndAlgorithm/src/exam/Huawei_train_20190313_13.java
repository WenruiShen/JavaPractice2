package exam;

import java.util.Scanner;

/*
 * 华为：牛客网
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 * 的每段可以看成是一个0-255的整数，需要对IP地址进行校验。
 *
 * 输入描述:
 * 输入
 *      1 输入IP地址
 *      2 输入10进制型的IP地址
 * 输出描述:
 * 输出
 *      1 输出转换成10进制的IP地址
 *      2 输出转换后的IP地址
 *
 * 示例1
 * 输入   10.0.3.193
 *       167969729
 * 输出   167773121
 *       10.3.3.193
 *
 */
public class Huawei_train_20190313_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()){
            String[] ip1StrArray = input.next().trim().split("\\.");
            Long ip2Int = Long.parseLong(input.next().trim());

            long ip1Int = 0;
            if(ip1StrArray.length == 4){
                for(int i=0; i< ip1StrArray.length; i++){
                    int temp = Integer.parseInt(ip1StrArray[i]);
                    if(temp<0 || temp >=256){
                        ip1Int=0;
                        break;
                    }
                    ip1Int += temp * Math.pow(256, 3-i);
                }
            }

            System.out.println(ip1Int);

            StringBuilder builder = new StringBuilder();
            for(int i=0; i<4;i++){
                if(i!=0){
                    builder.insert(0, ".");
                }
                builder.insert(0, ip2Int % 256);
                ip2Int = ip2Int/256;
            }
            if(ip2Int!=0){
                System.out.println(0);
            }
            System.out.println(builder);
        }
        input.close();
    }
}
