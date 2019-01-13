package bookAlgorithms.examples;


import static java.lang.Math.random;

/*
 * Created by shenwenrui on 20181219.
 * 快排
 * 简介：O(N*logN)，不稳定
 * 基本思想是：
 *  1．先从数列中取出一个数作为基准数。
 *  2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 *  3．再对左右区间重复第二步，直到各区间只有一个数。
 * 参考：
 *  [1].https://blog.csdn.net/u011384489/article/details/78300712#9-%E4%BA%A4%E6%8D%A2%E6%8E%92%E5%BA%8F%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8Fquick-sort;
 *  [2].https://blog.csdn.net/morewindows/article/details/6684558;
 *
 */
public class Sort_Quick extends AlgorithmModel{

    // 交换数组中的两个元素
    void swap(int[] array, int i, int j){
        int temp = array[i]; array[i] = array[j]; array[j] = temp;
    }

    // 分区过程
    // 输入：int st: 选取的基准数坐标
    // 返回：调整后的基准数坐标
    public int AdjustArray(int[] array, int left, int right, int st){
        int i=left, j=right;
        int stValue = array[st]; //获得基准数

        // 交换基准数与第一个数，第一个位置空出
        swap(array, left, st);

        while (i < j){

            // 从右向左找小于基准数的数
            while (i<j && array[j]>=stValue){
                j--;
            }
            if(i<j){
                // 与i处的空位交换，并将j位空出
                array[i] = array[j];
            }

            // 从左向右找大于基准数的数
            while (i<j && array[i]<=stValue){
                i++;
            }
            if(i<j){
                // 与j处的空位交换，并将i位空出
                array[j] = array[i];
            }
        }
        //退出时，i等于j。将stValue填到这个坑中
        array[i] = stValue;
        return i;
    }

    // 第一种实现：递归，选取第一个元素为基准数
    public void QuickSort_1(int[] array, int left, int right){
        if(left < right){
            int st = left;  //选取最左边的数为基准数
            st = AdjustArray(array, left, right, st);
            QuickSort_1(array, left, st-1);   //递归调用
            QuickSort_1(array, st+1, right);
        }
    }

    // 取区间内随机数的函数
    int randSt(int low, int high)
    {
        int size = high - low + 1;
        return  low + (int) random()%size;
    }

    // 第二种实现：递归，随机选取一个元素为基准数
    public void QuickSort_2(int[] array, int left, int right){
        if(left < right){
            int st = randSt(left, right);  //随机选取一个元素为基准数
            st = AdjustArray(array, left, right, st);
            QuickSort_2(array, left, st-1);   //递归调用
            QuickSort_2(array, st+1, right);
        }
    }

    @Override
    public void excute() {
        System.out.println("Quick Sort:");
        int[] arrary = {2, 6, 1, 7, 12, 32, 3233, 32, 44, 37, 44, 32, 32, 457, 32, 443, 32, 545, 32, 565, 32, 976, 3121};
        System.out.println("arrary:");
        printIntArray(arrary);

        QuickSort_2(arrary, 0, arrary.length-1);
        System.out.println("\nSortedArrary:");
        printIntArray(arrary);
    }
}
