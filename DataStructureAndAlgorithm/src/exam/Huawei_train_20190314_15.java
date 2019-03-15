package exam;

import java.util.Scanner;

/*
 * 华为：笔试题 麻将
 * 题目描述：
 * 清一色是麻将番种之一，指由一种花色的序数牌组成的和牌.
 * 数字1-9，每个数字最多有4张牌
 * 我们不考虑具体花色，我们只看数字组合。
 * 刻子：三张一样的牌；如: 111, 222, 333, …, 999
 * 顺子：三张连续的牌；如: 123, 234, 345, …, 789
 * 对子：两张相同的牌；如: 11, 22, 33, …, 99
 * 需要实现一个程序，判断给定牌，是否可以和牌（胡牌）。
 *
 * 和牌要求：
 *  1. 麻将牌张数只能是 2, 5, 8, 11, 14
 *  2. 给定牌可以组合成，除1个对子以外其他都是刻子或顺子
 *     举例： - “11” -> “11”, 1对子，可以和牌
 *           - “11122233” -> “111”+“222”+“33”, 2刻子，1对子，可以
 *           - “11223344567” -> “11”+“234”+“234”+“567”, 1对子，3顺子，可以
 *                           -> “123”+“123”+“44”+“567”, 另一种组合，也可以
 *
 * 输入描述:
 * 合法C字符串，只包含’1’-‘9’，且已经按从小到大顺序排好；字符串长度不超过15。同一个数字最多出现4次，与实际相符。
 * 输出描述:
 * C字符串，“yes"或者"no”
 *
 * 示例1
 * 输入: 2244
 * 输出: 24 //此处是试题原本模样,应该输出no
 *
 * 分析：
 * 可用递归的方式求解，在字符串中搜索刻子和顺子，找到之后再对去掉刻子或顺子之后的字符串进行递归搜索，直到字符串长度小于3为止，
 * 若最终剩余字符串长度为2且两个字符相同时则胡牌，否则不能胡牌。
 *
 * 参考：https://blog.csdn.net/sps900608/article/details/87278911
 *
 */
public class Huawei_train_20190314_15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String ss = input.nextLine();
            if(detect(ss)){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
        input.close();
    }
    public static boolean detect(String s){
        // 字符串长度不符合
        if (s.length()!=2 && s.length()!=5 && s.length()!=8 && s.length()!=11 && s.length()!=14)
            return false;

        // 剩下的2张牌为对子则和牌否则不能和牌
        if (s.length()==2){
            return s.charAt(0)==s.charAt(1);
        }

        boolean flag = false;
        int begin=0, end=s.length();
        while (end - begin > 2){
            // 判断是否有刻子
            if (s.charAt(begin) == s.charAt(begin+1) && s.charAt(begin) == s.charAt(begin+2))
            {
                // 去掉刻子后递归处理
                String tmp1 = s.substring(0, begin);
                String tmp2 = s.substring(begin + 3, end);
                flag |= detect(tmp1 + tmp2);
            }// 判断是否有顺子
            else if (s.charAt(begin)+1 == s.charAt(begin + 1)) {
                // 顺子中间的牌可能有多张相同的，遍历找到第一个不同的
                int midSameCount = 0;
                char mid = s.charAt(begin + 1);
                int iter = begin + 1;
                while (s.charAt(iter) == mid)
                {
                    midSameCount++;
                    // 如果递归到字符串末则标记后退出循环
                    if (++iter == end)
                    {
                        midSameCount = -1;
                        break;
                    }
                }
                // 处理有顺子的情况
                if (midSameCount > 0 && mid + 1 == s.charAt(iter)) {
                    // 去掉顺子后递归处理
                    StringBuilder tmp = new StringBuilder(s.substring(0, begin));
                    for(int i=0; i<midSameCount-1;i++){
                        tmp.append(mid);
                    }
                    tmp.append(s.substring(iter + 1, end));
                    flag |= detect(tmp.toString());
                }

            }
            ++begin;
        }
        return flag;
    }
}

