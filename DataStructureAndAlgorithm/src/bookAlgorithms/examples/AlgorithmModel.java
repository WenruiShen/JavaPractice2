package bookAlgorithms.examples;

public abstract class AlgorithmModel {

    public int[] scan(){
        int[] array = new int[10];
        return array;
    };

    public int max3(int a, int b, int c){
        int maxNum = a;

        if(b > maxNum){
            maxNum = b;
        }

        if(c > maxNum){
            maxNum = c;
        }
        return maxNum;
    }

    public abstract void excute();

    public void printIntArray(int[] array){
        //System.out.println("\n");
        for (Integer element : array){
            System.out.print(element);
            System.out.print(", ");
        }
        System.out.println("\n");
    }

    // 交换数组中的两个元素
    public void swap(int[] array, int i, int j){
        int temp = array[i]; array[i] = array[j]; array[j] = temp;
    }
}
