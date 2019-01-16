package bookAlgorithms.examples.Sort;

import bookAlgorithms.examples.AlgorithmModel;

/*
 * Created by shenwenrui on 20181219.
 * 归并排序
 * 简介：O(N*logN)，稳定
 * 参考链接：https://blog.csdn.net/morewindows/article/details/6678165
 */
public class Sort_Merge  extends AlgorithmModel {
    //将有二个有序数列a[left...mid]和a[mid+1...right]合并。
    public void mergeArray(int[] array, int left, int mid, int right, int[] temp){
        int i = left, j = mid + 1;
        int m = mid, n = right;
        int k = 0;

        while (i<=m && j<=n){
            if(array[i]<=array[j]){
                temp[k++] = array[i++];
            }else {
                temp[k++] = array[j++];
            }
        }

        while (i<=m){
            temp[k++] = array[i++];
        }

        while (j<=n){
            temp[k++] = array[j++];
        }
        for (i=0; i<k; i++){
            array[left+i] = temp[i];
        }

    }

    public int[] mergeSort(int[] array, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, temp);           // 左边有序
            mergeSort(array, mid+1, right, temp);   // 右边有序
            mergeArray(array, left, mid, right, temp);
        }
        return array;
    }

    public int[] StartMergeSort(int[] array, int len){
        int[] temp = new int[len];
        if(null == temp || temp.length<=0){
            return temp;
        }
        mergeSort(array, 0, len-1, temp);
        return array;
    }

    @Override
    public void excute() {
        System.out.println("Merge Sort:");
        int[] arrary = {2, 6, 1, 7, 12, 32, 3233, 44, 37, 4, 457, 443, 545, 565, 976, 3121};
        System.out.println("arrary:");
        printIntArray(arrary);

        int[] sortedArray = StartMergeSort(arrary, arrary.length);
        System.out.println("\nsortedArray:");
        printIntArray(sortedArray);

    }
}
