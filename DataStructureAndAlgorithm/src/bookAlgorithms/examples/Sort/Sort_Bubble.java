package bookAlgorithms.examples.Sort;

/*
 * Created by shenwenrui on 20190116.
 * 冒泡排序
 * 简介:
 *      1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 *      2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 *      3.针对所有的元素重复以上的步骤，除了最后一个。
 *      4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * 参考:
 *      [1].https://blog.csdn.net/u011384489/article/details/78300691;
 *
 */

import bookAlgorithms.examples.AlgorithmModel;

public class Sort_Bubble extends AlgorithmModel {

    // 沉底
    public void BubbleSortAsc(int[] array, int len){
        for(int i=len-1; i>1;i--){
            for(int j=0; j<i; j++){
                if(array[j]>array[j+1]){
                    swap(array, j, j+1);
                }
            }
        }
    }

    @Override
    public void excute() {
        System.out.println("Bubble Sort:");
        int[] array = {2, 6, 1, 7, 12, 32, 3233, 32, 44, 37, 44, 32, 32, 457, 32, 443, 32, 545, 32, 565, 32, 976, 3121};
        System.out.println("arrary:");
        printIntArray(array);

        BubbleSortAsc(array, array.length);
        System.out.println("SortedArrary:");
        printIntArray(array);
    }
}
