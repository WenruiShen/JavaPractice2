package exam;

import java.util.Scanner;

/*
 * 牛客网 放苹果，动态规划
 * 把 M 个同样的苹果放在 N 个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 * 注意：5、1、1 和 1、5、1 是同一种分法，即顺序无关。
 *
 * 输入描述:
 * 输入包含多组数据。
 * 每组数据包含两个正整数 m和n（1≤m, n≤20）。
 *
 * 输出描述:
 * 对应每组数据，输出一个整数k，表示有k种不同的分法。
 * 示例1
 * 输入: 7 3
 * 输出: 8
 *
 *
 * 分析：
 * 首先用递归的思想来思考这道题：
 * 1，递归出口：当只有一个盘子或者 含有 0 个 或 1 个苹果的时候只有一种方法
 * 2，当盘子数 n 大于苹果数 m 时，则必有 n - m 个空盘子，所以只需求 m 个盘子
 *  放 m 个苹果时的方法数即可，
 * 3，当盘子数 n 小于等于 苹果数 m 时，总方法数 = 当含有一个空盘子时的方法数
 *  + 不含空盘子时的方法数。
 * 原因：当在求只含有一个空盘子时的方法数时，已经包含了含有 2 ~ n - 1 个空盘子 的情况。
 * 不含空盘子的计算：先将每个盘子装一个苹果，则问题变成了求 n 个盘子放 m - n
 * 个苹果的方法数了。
 *
 * 其间，还可用记忆搜索优化（此处不再详讲）
 *
 * 然后用动态规划来优化代码：
 * 新建一个动态规划表 dp；dp[i][j] 表示 i 个盘子放 j 个苹果的方法数。
 * 则  当 i > j 时，dp[i][j] = dp[i - (i - j)][j] = dp[j][j](原因上面已经讲过）
 * 当 i <= j 时，dp[i][j] = dp[i - 1][j] + dp[i][j - i];
 * 最后dp[n][m] 就是所求。
 *
 * 最后，可用空间压缩的办法进一步优化代码：
 * 由于dp[i][j] 依赖其左边的 dp 与其的距离不太确定，所以就按行分割dp表啦*_*.
 * （其实也还是有一定规律的，就是当 i < j 时左边依赖的 dp 与其的距离为 i ，
 * 只需用一个更小的数组来记录其左边与其相距为 i 的几个值即可，
 * 这里代码实现就不写了，望君可写出）。
 *
 * 参考：https://www.nowcoder.com/profile/1869954/codeBookDetail?submissionId=36733020
 *
 */
public class NIuke_DP_20190314_01_fangpinguo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int m = input.nextInt();    // appleNum
            int n = input.nextInt();    // plateNum
            System.out.println(dp(m, n));
        }
        input.close();
    }
    public static int dp(int m, int n){
        if(m==0 || m==1 || n==0 || n==1){
            return 1;
        }

        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                dp[i][j] = 1;   // init
            }
        }

        for(int i=2; i<=n; i++){     // start from 2 plate.
            for(int j=2; j<=m; j++){ // start from 2 apple.
                if(i > j){
                    // i plate is more than j apple
                    dp[i][j] = dp[j][j];
                }else {
                    // j apple is more than i plate
                    dp[i][j] = dp[i-1][j] + dp[i][j-i];
                }
            }
        }
        return dp[n][m];
    }
}
