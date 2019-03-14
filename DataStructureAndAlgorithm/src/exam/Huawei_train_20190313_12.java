package exam;

import java.util.Scanner;

/*
 * 华为：牛客网
 * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
 * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。
 * 利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
 *
 * 示例：
 * I P 地址　 192.168.0.1
 * 子网掩码　 255.255.255.0
 * 转化为二进制进行运算：
 * I P 地址　11010000.10101000.00000000.00000001
 * 子网掩码　11111111.11111111.11111111.00000000
 * AND运算
 *          11000000.10101000.00000000.00000000
 * 转化为十进制后为：
 *          192.168.0.0
 *
 * I P 地址　 192.168.0.254
 * 子网掩码　 255.255.255.0
 * 转化为二进制进行运算：
 * I P 地址　11010000.10101000.00000000.11111110
 * 子网掩码　11111111.11111111.11111111.00000000
 * AND运算
 *          11000000.10101000.00000000.00000000
 * 转化为十进制后为：
 *          192.168.0.0
 *
 * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
 * 功能: 判断两台计算机IP地址是同一子网络。
 * 输入参数：    String Mask: 子网掩码，格式：“255.255.255.0”；
 *               String ip1: 计算机1的IP地址，格式：“192.168.0.254”；
 *               String ip2: 计算机2的IP地址，格式：“192.168.0.1”；
 *
 * 返回值：      0：IP1与IP2属于同一子网络；     1：IP地址或子网掩码格式非法；    2：IP1与IP2不属于同一子网络
 */
public class Huawei_train_20190313_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mask = input.next().trim();
        String ip1 = input.next().trim();
        String ip2 = input.next().trim();
        System.out.println(checkNetSegment(mask, ip1, ip2));
        input.close();
    }

    public static int checkNetSegment(String mask, String ip1, String ip2)
    {
        int maskInt = parseIpStr(mask);
        int ip1Int = parseIpStr(ip1);
        int ip2Int = parseIpStr(ip2);
        if(maskInt==0 || ip1Int==0 || ip2Int==0){
            // illegal mask or ip.
            return 1;
        }
        if((maskInt & ip1Int) == (maskInt & ip2Int)){
            // 同一网段
            return 0;
        }else {
            // 不同网段
            return 2;
        }

    }
    public static int parseIpStr(String ip){
        String[] ipStrArray = ip.split("\\.");
        if(ipStrArray.length != 4){
            return 0;
        }
        int[] ipNumArray = new int[4];
        int resultIp = 0;
        for(int i=0; i<ipStrArray.length; i++){
            ipNumArray[i] = Integer.valueOf(ipStrArray[i]);
            if(ipNumArray[i]<0 || ipNumArray[i]>255){
                return 0;
            }
            resultIp += ipNumArray[i] * Math.pow(256, 3-i);
        }
        return resultIp;
    }

}
