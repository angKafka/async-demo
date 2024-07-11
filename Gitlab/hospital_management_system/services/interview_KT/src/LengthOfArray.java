public class LengthOfArray
{

    public static void main(String[] args) {
        int[] arr= {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Length of array is: " + lengthOfArrayCheck(arr));
    }

    public static int lengthOfArrayCheck(int[] arr) {
        int count = 0;
        for(int i: arr){
            count ++;
        }
        return count;
    }
}
