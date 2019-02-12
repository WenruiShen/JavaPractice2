package Vedio51CTOAlgorithms;

import bookAlgorithms.examples.Model.AlgorithmModel;

import java.util.HashSet;
import java.util.Set;

/*
 * Created by shenwenrui on 20190212.
 * Description: 两数之和;
 *              有一个整数数组nums,能否从中取出两个数,使他们的和为target;
 *              输入1： nums = [4, 5, 7, 10], target=12, 输出1: true;
 *              输入2： nums = [4, 5, 7, 10], target=8,  输出2: false;
 *
 *              思路：采用逐个hash填充，达到O(n)复杂度。
 *
 *              51CTO视频-高频算法面试题:2;
 */
public class AddTwoNumbers extends AlgorithmModel {
    public boolean findTwoNumbers(int[] nums, int target){
        System.out.println("arrary:");
        printIntArray(nums);

        boolean result = false;
        Set<Integer> appeared = new HashSet<Integer>();
        for(int num : nums){
            if(appeared.contains(target-num)){
                return true;
            }
            appeared.add(num);
        }
        return result;
    }

    @Override
    public void excute() {
        int target =0;
        boolean result = false;

        target = 12;
        result = findTwoNumbers(new int[]{4, 5, 7, 10}, target);
        System.out.println("findTwoNumbers:target:" + target + "\tresult:"+ result);

        target = 8;
        result = findTwoNumbers(new int[]{4, 5, 7, 10}, target);
        System.out.println("findTwoNumbers:target:" + target + "\tresult:"+ result);
    }
}
