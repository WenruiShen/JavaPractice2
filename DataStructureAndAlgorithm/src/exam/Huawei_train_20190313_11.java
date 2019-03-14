package exam;

import java.util.Scanner;

/*
 * 华为：牛客网 接啤酒
 * 酒馆里有m个龙头可供顾客们接啤酒，每个龙头每秒的出酒量相等，都是1。现有n名顾客准备接酒，他们初始的接酒顺序已经确定。
 * 将这些顾客按接酒顺序从1到n编号，i号顾客的接酒量为w_i。接酒开始时，1到m号顾客各占一个龙头，并同时打开龙头接酒。
 * 当其中某个顾客j完成其接酒量要求wj后，下一名排队等候接酒的顾客k马上接替j顾客的位置开始接酒。
 * 这个换人的过程是瞬间完成的，且没有任何酒的浪费。即j顾客第x秒结束时完成接酒，则k顾客第x+1秒立刻开始接酒。
 * 若当前接酒人数n不足m，则只有n个龙头供酒，其它m-n个龙头关闭。现在给出n名顾客的接酒量，按照上述规则，问所有顾客都接完酒需要多少秒？
 *
 * 输入描述:
 * 输入包括两行，第一行为以空格分割的两个数n和m, 分别表示接酒的人数和酒龙头个数，均为正整数。
 * 第二行n个整数w_i，(1 <= w_i <= 100)表示每个顾客接酒量
 *
 * 输出描述
 * 如果输入合法输出接酒所需总时间(秒)。
 *
 * 示例1
 * 输入:
 *      5 3
 *      4 4 1 2 1
 * 输出 4
 *
 * 提示: 1 ≤ n ≤ 10000，1 ≤ m ≤ 100 且 m ≤ n；1 ≤ w i ≤ 100。
 *
 */
public class Huawei_train_20190313_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int peopleNum = input.nextInt();
        int bucketNum = input.nextInt();

        int[] customerVolum = new int[peopleNum];
        for (int i=0; i<peopleNum; i++){
            customerVolum[i] = input.nextInt();
        }

        int[] bucketsCustomerId = new int[bucketNum];
        for (int i=0; i<bucketNum; i++){
            bucketsCustomerId[i] = i;
        }
        int waittingCustomerId = bucketNum;


        int totalTime = 0;
        while (waittingCustomerId <= peopleNum){
            int minVolum = Integer.MAX_VALUE;
            for(int id: bucketsCustomerId){
                if(id >= peopleNum){
                    continue;
                }
                minVolum = minVolum<customerVolum[id]? minVolum : customerVolum[id];
            }
            for(int i=0; i<bucketNum; i++){
                int id = bucketsCustomerId[i];
                if(id >= peopleNum){
                    continue;
                }
                customerVolum[id] -= minVolum;
                if(customerVolum[id]==0) {
                    bucketsCustomerId[i] = waittingCustomerId++;
                }
            }
            totalTime += minVolum;
        }
        System.out.println(totalTime);
        input.close();
    }
}
