package Vedio51CTOAlgorithms;

import bookAlgorithms.examples.Model.AlgorithmModel;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * Created by shenwenrui on 20190201.
 * Description: 斐波那契数列(Fibonacci Sequences);
 *              动态规划；
 *
 *              0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...
 *              F(n) = F(n-1) + F(n-2)
 *              计算F(n)
 *              输入 n=5, 输出5
 *
 *              51CTO视频-高频算法面试题:11;
 */
public class FibonacciSequences  extends AlgorithmModel {
    static int[] mem;

    // 备忘模型
    public int F1(int target){
        if(mem[target] == -1){
            return mem[target] = F1(target-1) + F1(target-2);
        }
        return mem[target];
    }

    //演绎模型
    public int F2(int target){
        for(int i=2; i<=target; i++){
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[target];
    }

    @Override
    public void excute() {
        int target = 13;
        mem = new int[target+1];
        Arrays.fill(mem, -1);
        mem[0] = 0;
        mem[1] = 1;
        int result = F2(target);
        System.out.println("result:" + result);
    }
}
