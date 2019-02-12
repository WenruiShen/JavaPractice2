package Vedio51CTOAlgorithms;

import bookAlgorithms.examples.Model.AlgorithmModel;

/*
 * Created by shenwenrui on 20190212.
 * Description: 合并数组;
 *              有两个排序的数组，nums1和nums2，将这两个数组合并成新的排序数组，并放入nums1中。
 *              输入：
 *              nums1 = {4, 5, 7, 10, 0, 0, 0}, length1 = 4;
 *              nums2 = {3, 6, 11}, length2 = 3;
 *              输出：
 *              {3, 4, 5, 6, 7, 10, 11}
 *
 *              51CTO视频-高频算法面试题:3;
 */
public class MergeArray extends AlgorithmModel {

    void mergeTwoArray(int nums1[], int length1, int nums2[], int length2){
        int pos1 = length1-1;
        int pos2 = length2-1;
        int last = nums1.length-1;

        while (last > -1){
            if(pos1==-1 || (pos2!=-1 && nums1[pos1]<nums2[pos2])){
                nums1[last--] = nums2[pos2--];
            }else {
                nums1[last--] = nums1[pos1--];
            }
        }
    }

    @Override
    public void excute() {
        int nums1[] = {4, 5, 7, 10, 0, 0, 0};
        int length1 = 4;
        int nums2[] = {3, 6, 11};
        int length2 = 3;

        System.out.println("nums1:");
        printIntArray(nums1);
        System.out.println("nums2:");
        printIntArray(nums2);

        mergeTwoArray(nums1, length1, nums2, length2);
        System.out.println("mergeTwoArray:");
        printIntArray(nums1);

    }
}
