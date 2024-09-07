package searchs.linear;

public class LSearch {
    private static int[] arr = {2, 4, 7, 10, 13, 19, 21};
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(arr, 13));
    }
}
