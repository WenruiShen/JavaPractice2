package exam;

import java.util.Scanner;

/*
 * 华为：牛客网。
 * 集五福
 * 题目：以0和1组成的长度为5的字符串代表每个人所得到的福卡，每一位代表一种福卡，1表示已经获得该福卡，单类型福卡不超过1张，
 * 随机抽取一个小于10人团队，求该团队最多可以集齐多少套五福？
 *
 * 输入描述:
 * 输入若干个"11010"、”00110"的由0、1组成的长度等于5位字符串,代表的指定团队中每个人福卡获得情况
 * 注意1：1人也可以是一个团队
 * 注意2：1人可以有0到5张福卡，但福卡不能重复
 *
 * 输出描述:
 * 输出该团队能凑齐多少套五福
 *
 * 示例1
 * 输入: 3
 *      11001
 *      10111
 *      01111
 * 输出: 2
 *
 *
 */
public class Huawei_train_20190313_09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int memberNum = Integer.valueOf(input.nextLine());
        int[] cardsSum = new int[5];
        for (int i=0; i<memberNum; i++){
            String oneMember = input.nextLine().trim();
            char[] cardArray = oneMember.toCharArray();
            for(int cardId=0; cardId<cardArray.length; cardId++){
                if(cardArray[cardId] == '1'){
                    cardsSum[cardId]++;
                }
            }
        }
        int min = memberNum;
        for (int num:cardsSum){
            if(num < min){
                min = num;
            }
        }
        System.out.println(min);
        input.close();
    }
}
