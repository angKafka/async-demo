package permutationandcombination;

public class Question3 {
    public static void main(String[] args) {
        String[] s = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        Question3 q = new Question3();
        System.out.println(q.pairNonRepeatingSubsequences(s,4));
    }

    public int pairNonRepeatingSubsequences(String[] s, int k) {
        int n = s.length;
        int res = 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count++;
        }

        for(int i=1; i<=k; i++){
            res*=count;
            count--;
        }
        return res;
    }
}
