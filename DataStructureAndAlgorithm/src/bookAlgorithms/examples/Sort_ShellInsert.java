package bookAlgorithms.examples;

/*
 * Created by shenwenrui on 20190115.
 * 希尔插入排序
 *
 * 原理简介：
 *      1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 *      2.按增量序列个数k，对序列进行k 趟排序；
 *      3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 *        仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * 参考：
 *  [1].https://blog.csdn.net/u011384489/article/details/78289576;
 *
 */
public class Sort_ShellInsert extends AlgorithmModel {

    // 直接插入排序，升序
    public void ShellInsertSortAsc(int[] array, int gap){
        for (int i=gap; i<array.length; i++){
            int temp = array[i];
            int j =i;
            for(; j>=gap && temp<array[j-gap]; j-=gap){
                array[j] = array[j-gap];    //元素后移
            }
            array[j] = temp;    // 基准数插入正确位置
        }
    }

    // 希尔插入排序，由小到大
    public void ShellSortAsc(int[] array){
        // 先按增量d（n/2,n为要排序数的个数进行希尔排序)
        int n = array.length;
        int dk = n / 2;
        for(;dk>=1;dk/=2){
            ShellInsertSortAsc(array, dk);
        }


    }

    @Override
    public void excute() {
        System.out.println("Shell Insert Sort:");
        int[] array = {2, 6, 1, 7, 12, 32, 3233, 32, 44, 37, 44, 32, 32, 457, 32, 443, 32, 545, 32, 565, 32, 976, 3121};
        System.out.println("arrary:");
        printIntArray(array);

        ShellSortAsc(array);
        System.out.println("SortedArrary:");
        printIntArray(array);
    }
}
