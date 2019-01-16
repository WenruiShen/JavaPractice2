package bookAlgorithms.examples;

public class Toutiao_shuiweixian extends AlgorithmModel {

    @Override
    public void excute() {
        System.out.println("Bubble Sort:");
        int[] array = {2, 6, 1, 7, 12, 32, 3233, 32, 44, 37, 44, 32, 32, 457, 32, 443, 32, 545, 32, 565, 32, 976, 3121};
        System.out.println("arrary:");
        printIntArray(array);

        //BubbleSortAsc(array, array.length);
        System.out.println("SortedArrary:");
        printIntArray(array);
    }
}
