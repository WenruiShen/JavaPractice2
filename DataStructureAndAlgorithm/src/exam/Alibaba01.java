package exam;

import java.util.LinkedList;
import java.util.List;

public class Alibaba01<E extends Comparable<? super E>>{
    // 交换
    private void swap(E[] obArray, int i, int j){
        // TODO:
        E temp = obArray[i];
        obArray[i] = obArray[j];
        obArray[i] = temp;
    }

    //升序
    private int adjustArray(E[] obArray, int left, int right, int st){
        int i=left, j=right;
        E stValue = obArray[st];

        //空出最左侧
        swap(obArray, left, st);
        while(i < j){
            //从右向左
            while(i<j && stValue.compareTo(obArray[j]) <= 0){
                j--;
            }

            //找到一个小于基准值的，进行交换
            if(i<j){
                obArray[i] = obArray[j];
            }

            //从左向右
            while(i<j && stValue.compareTo(obArray[j]) >= 0){
                i++;
            }
            //找到一个大于基准值的，进行交换
            if(i<j){
                obArray[j] = obArray[i];
            }
        }
        obArray[i] = stValue;
        return i;

    }

    private void doQuickSort(E[] obArray, int left, int right){
        if(left < right){
            int st = left; // 可选随机，待优化
            // TODO:进行调整
            adjustArray(obArray, left, right, st);
            doQuickSort(obArray, left, st-1);
            doQuickSort(obArray, st+1, right);
        }
    }

    public List<E> quickSort(List<E> inputList){
        E[] obArray = (E[])inputList.toArray();
        List<E> resultList = new LinkedList<>();
        doQuickSort(obArray, 0, obArray.length-1);
        for(E e: obArray){
            resultList.add(e);
        }
        return resultList;
    }
}

//原答
class ListQuickSort<E extends Comparable<? super E>>{
    // 交换
    private void swap(E[] obArray， int i, int j){
        // TODO:
        E temp = E[i];
        E[i] = E[j];
        E[i] = temp;
    }

    //升序
    private int adjustArray(E[] obArray, int left, int right, int st){
        int i=left, j=right;
        E stValue = obArray[st];

        //空出最左侧
        swap(obArray, left, st);
        while(i < j){
            //从右向左
            while(i<j && stValue.CompareTo(obArray[j]) <= 0){
                j--;
            }

            //找到一个小于基准值的，进行交换
            if(i<j){
                obArray[i] = obArray[j];
            }

            //从左向右
            while(i<j && stValue.CompareTo(obArray[j]) >= 0){
                i++;
            }
            //找到一个大于基准值的，进行交换
            if(i<j){
                obArray[j] = obArray[i];
            }
        }
        obArray[i] = stValue;
        return i;

    }

    private void doQuickSort(E[] obArray, int left, int right){
        if(left < right){
            int st = left; // 可选随机，待优化
            // TODO:进行调整
            adjustArray(obArray, left, right, st);
            doQuickSort(obArray, left, st-1);
            doQuickSort(obArray, st+1, right);
        }
    }

    public <E extends Comparable<? super E>> List<E> quickSort(List<E> inputList){
        List<E> resultList = new LinkedList<>();
        E[] obArray = (E[])inputList.toArray();
        doQuickSort(obArray, 0, obArray.length-1);
        for(E e: obArray){
            resultList.add(e);
        }
        return resultList;
    }
}