package Vedio51CTOAlgorithms;

import bookAlgorithms.examples.Model.AlgorithmModel;

/*
 * Created by shenwenrui on 20190212.
 * Description: 寻找变化;
 *              一个数组前段是0，后段是1。
 *              你能否找到出现的第一个1。
 *              输入1：nums = {0, 0, 0, 1, 1, 1, 1}, 输出1：3;
 *              输入2：nums = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, 输出2：2;
 *
 *              51CTO视频-高频算法面试题:5;
 */
public class SearchChange extends AlgorithmModel {

    int search(int nums[], int left, int right){
        if(left==right){
            if((left>=nums.length-1 && nums[left]==0) || left==0){
                return -1;
            }else{
                return left;
            }
        }
        int mid = (left+right)/2;
        if(nums[mid] == 0){
            left = mid+1;
        }else {
            right = mid;
        }
        return search(nums, left, right);
    }

    int searc2(int nums[]){
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = (left+right)/2;
            if(nums[mid] == 0){
                left = mid+1;
            }else {
                right = mid;
            }
        }

        if((left>=nums.length-1 && nums[left]==0) || left==0){
            //没有找到
            return -1;
        }else{
            return left;
        }
    }

    @Override
    public void excute() {
        //int nums[] = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
        int nums[] = {1, 1, 1, 1};
        printIntArray(nums);
        //int result = search(nums, 0, nums.length-1);
        int result = searc2(nums);
        System.out.println("position:" + result);
    }
}
