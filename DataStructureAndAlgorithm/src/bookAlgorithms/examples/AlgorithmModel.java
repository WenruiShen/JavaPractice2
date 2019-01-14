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
}
