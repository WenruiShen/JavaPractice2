package exam;

import java.util.*;

/*
 * 华为：牛客网。
 * 功能:编写一个程序，将输入字符串中的字符按如下规则排序。
 *      规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *      如，输入： Type   输出： epTy
 *      规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *      如，输入： BabA   输出： aABb
 *      规则 3 ：非英文字母的其它字符保持原来的位置。
 *      如，输入： By?e   输出： Be?y
 *
 *      样例：
 *      输入：A Famous Saying: Much Ado About Nothing(2012/8).
 *      输出：A  aaAAbc   dFgghh :  iimM   nNn   oooos   Sttuuuy  (2012/8).
 *
 */
public class Huawei_train_20190313_08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()){
            char[] oriCharArray = input.nextLine().toCharArray();
            List<Character> letterList = new ArrayList<>();
            for(Character ele: oriCharArray){
                if(Character.isLetter(ele)){
                    letterList.add(ele);
                }
            }
            Collections.sort(letterList, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return Character.toLowerCase(o1) - Character.toLowerCase(o2);
                }
            });
            StringBuilder builder = new StringBuilder();
            for(Character c: letterList){
                builder.append(c);
            }

            for(int i=0; i< oriCharArray.length; i++){
                if(!Character.isLetter(oriCharArray[i])){
                    builder.insert(i, oriCharArray[i]);
                }
            }
            System.out.println(builder.toString());
        }
        input.close();
    }
}
