package Vedio51CTOAlgorithms;

import bookAlgorithms.examples.Model.AlgorithmModel;

import java.util.Arrays;

/*
 * Created by shenwenrui on 20190201.
 * Description: 偷金子;
 *              动态规划；
 *              房间有金子，价值各不同，连偷会报警，如何赚大钱？
 *              输入： houses = {3, 5, 2, 10}
 *              解释：
 *               - 有四间屋子，金子的价值各是3、5、2、10
 *               - 偷的时候，不能偷连续的房间，比如：偷了3，就不能偷5；偷了5，就不能偷3和2。
 *               输出：15
 *
 *              51CTO视频-高频算法面试题:12;
 */
public class StealGold extends AlgorithmModel {
    private int getMem(int id, int[] houses, int[] mem){
        if(id>=mem.length){
            return 0;
        }
        if(mem[id] == -1){
            mem[id] = Math.max(houses[id]+getMem(id+2,houses,mem), getMem(id+1,houses,mem));
        }
        return mem[id];
    }

    /*
    mem[id] = max{houses[id]+mem[id+2], 0+mem[id+1]}
     */
    public int steal(int[] houses){
        int[] mem = new int[houses.length];
        Arrays.fill(mem, -1);
        return getMem(0, houses, mem);
    }

    public int steal2(int[] houses){
        int[] mem = new int[houses.length];
        Arrays.fill(mem, -1);
        mem[0]=houses[0];
        mem[1]= Math.max(houses[1],mem[0]);
        for (int id=2;id<houses.length;id++){
            mem[id] = Math.max(houses[id]+mem[id-2], mem[id-1]);
        }
        return mem[houses.length-1];
    }

    @Override
    public void excute() {
        int[] houses = new int[]{3, 5, 2, 10};
        //int[] houses = new int[]{3, 5, 2, 10, 6, 8, 1, 3, 5, 9};
        int result = steal2(houses);
        System.out.println("result:" + result);
    }
}
