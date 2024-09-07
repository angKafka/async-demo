package permutationandcombination;

public class Question1 {

    /*Time Complexity = O(N)*/
    public int pair(int[] arr, int size, int k){
        int resultPairCount = 1;

        if(arr.length == 0 || size == 0){
            return resultPairCount;
        }

        int count = 0;
        //O(N)
        for(int i = 0; i < size; i++){
            count ++;
        }

        //O(K)
        for(int i = 1; i <= k; i++){
            resultPairCount *= count;
        }
        return resultPairCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int pairToBe = 3;
        Question1 question1 = new Question1();
        System.out.println(question1.pair(arr, arr.length, pairToBe));
    }
}
