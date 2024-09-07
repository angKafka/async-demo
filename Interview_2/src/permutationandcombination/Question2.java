package permutationandcombination;

public class Question2 {
    public int pair(int[] nums, int k) {
        int n = nums.length;
        int res = 1;
        int count = 0;
        int evenCount = 0;
        for (int num : nums) {
            count++;
            if (num % 2 == 0) {
                evenCount++;
            }
        }

        for(int i=1; i<=k; i++){
                    if(nums[i] % 2 == 0) {
                        res *= count;
                    }
        }
        return res*evenCount;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        Question2 q = new Question2();
        System.out.println(q.pair(nums, 3));
    }
}
