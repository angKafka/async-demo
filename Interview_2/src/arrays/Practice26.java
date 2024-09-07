package arrays;



/*26. Remove Duplicates from Sorted Array*/
public class Practice26 {
    public static int[] num = {1,1,2};

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 0;

        for (int i = 1; i < nums.length; i++) {
            if(nums[k] != nums[i]){
                k++;
                nums[i] = nums[k];
            }
        }
        return k+1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(num));
    }
}
