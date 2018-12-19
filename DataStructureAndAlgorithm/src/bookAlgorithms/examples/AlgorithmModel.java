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
}
