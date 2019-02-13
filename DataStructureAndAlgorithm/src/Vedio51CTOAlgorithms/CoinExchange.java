package Vedio51CTOAlgorithms;

import bookAlgorithms.examples.Model.AlgorithmModel;

import java.util.Arrays;

/*
 * Created by shenwenrui on 20190201.
 * Description: 换硬币;
 *              动态规划；
 *
 *              硬币很多种，价值各不同，拼成一个数，最少用几个？
 *              输入：coins = {1, 2, 3, 4}, target=10
 *              输出：3
 *              解释：最少使用的硬币数是3，包含两个4和一个2。
 *
 *              51CTO视频-高频算法面试题:13;
 */
public class CoinExchange extends AlgorithmModel {

    public int exchange(int[] coins, int target){
        int[] mem = new int[target];
        Arrays.fill(mem, -1);
        mem[0] = 1;
        mem[1] = 1;
        mem[2] = 1;
        mem[3] = 1;
        for(int i=5; i<=target; i++){
            for (int coin: coins){
                if(mem[i-coin-1]>0){
                    mem[i-1] = (mem[i-1]!=-1) ? Math.min(mem[i-1], 1+mem[i-coin-1]) : 1+mem[i-coin-1];
                }
            }
        }
        return mem[target-1];
    }

    @Override
    public void excute() {
        int[] coins = {1, 2, 3, 4};
        int target=10;
        int result = exchange(coins, target);
        System.out.println("result:" + result);
    }
}
