package exam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * 华为：牛客网 背包问题，动态规划
 * 小偷来到了一个神秘的王宫，突然眼前一亮，发现5个宝贝，每个宝贝的价值都不一样，且重量也不一样，但是小偷的背包携带重量
 * 有限，所以他不得不在宝贝中做出选择，才能使偷到的财富最大，请你帮助小偷计算一下。
 *
 * 输入描述:
 * 宝贝价值：6,3,5,4,6
 * 宝贝重量：2,2,6,5,4
 * 小偷背包容量：10
 * 输出描述:
 * 偷到宝贝的总价值：15
 *
 * 示例1
 * 输入
 * 6,3,5,4,6
 * 2,2,6,5,4
 * 10
 * 输出   15
 *
 */
public class Huawei_train_20190313_14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] valueArray = parse(input.nextLine());
        int[] weightArray = parse(input.nextLine());
        int packVolum = Integer.valueOf(input.nextLine().trim());   //m
        int goodsNum = valueArray.length;   //n
        int result = BackPack_Solution(packVolum, goodsNum, weightArray, valueArray);
        System.out.println(result);
        input.close();
    }

    public static int BackPack_Solution(int m, int n, int[] w, int[] p) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n + 1][m + 1];
        for (int i=0; i<=n; i++){
            c[i][0] = 0;
        }
        for (int i=0; i<=m; i++){
            c[0][i] = 0;
        }

        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if(w[i-1]<=j){
                    //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                    //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                    //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                    if(c[i-1][j] < (c[i-1][j - w[i-1]] + p[i-1])){
                        c[i][j] = c[i-1][j - w[i-1]] + p[i-1];
                    }else {
                        c[i][j] = c[i-1][j];
                    }

                }else {
                    //当前商品单件重量已经大于背包总容量，不予考虑
                    c[i][j] = c[i-1][j];
                }
            }
        }
        return c[n][m];
    }

    private static int[] parse(String line){
        String[] ss = line.trim().split(",");
        int[] numArray = new int[ss.length];
        for (int i=0; i<ss.length; i++){
            numArray[i] = Integer.valueOf(ss[i]);
        }
        return numArray;
    }
}
