package bookAlgorithms.examples;

/*
 * Created by shenwenrui on 20181219.
 * 简单选择排序
 * 简介:
 *      第一趟，从n 个记录中找出关键码最小的记录与第一个记录交换；
 *      第二趟，从第二个记录开始的n-1 个记录中再选出关键码最小的记录与第二个记录交换；
 *      第i 趟，则从第i 个记录开始的n-i+1 个记录中选出关键码最小的记录与第i 个记录交换；
 *
 * 参考:
 *      [1].https://blog.csdn.net/u011384489/article/details/78300691;
 *
 */
public class Sort_Select extends AlgorithmModel {


    @Override
    public void excute() {
        System.out.println("Select Sort:");
        int[] array = {2, 6, 1, 7, 12, 32, 3233, 32, 44, 37, 44, 32, 32, 457, 32, 443, 32, 545, 32, 565, 32, 976, 3121};
        System.out.println("arrary:");
        printIntArray(array);

        //ShellSortAsc(array);
        System.out.println("SortedArrary:");
        printIntArray(array);
    }
}
