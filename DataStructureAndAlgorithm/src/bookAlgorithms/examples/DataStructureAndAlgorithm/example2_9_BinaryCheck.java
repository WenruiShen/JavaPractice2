package bookAlgorithms.examples.DataStructureAndAlgorithm;

import bookAlgorithms.examples.Model.AlgorithmModel;

/*
 * Created by shenwenrui on 20181219.
 * Description: Perform the standard binary search.
 *              @return index where item is found, or -1 if not found.
 *              折半查找。
 */
public class example2_9_BinaryCheck extends AlgorithmModel {

    public <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType[] a, AnyType x){
        int low = 0, high = a.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(a[mid].compareTo(x) < 0){
                low = mid + 1;
            }else if (a[mid].compareTo(x)>0){
                high = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public int run(Integer[] a, Integer x){
        return binarySearch(a, x);
    }

    @Override
    public void excute(){
        Integer[] arrary = new Integer[]{1, 2, 3, 4, 6, 7, 12, 32, 443, 545, 565, 976, 3121, 3233, 44556, 4557};
        //List<Integer> list = new ArrayList<Integer>(Arrays.asList(arrary));
        Integer target = 443;
        int index = run(arrary, target);
        if(index >= 0){
            System.out.println(String.format("Find target:'%d' at index:'%d'", target, index));
        }else {
            System.out.println("Does not find the number!");
        }

        System.out.println("example2_9_折半查找 excuted!");
    }
}
