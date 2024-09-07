package permutationandcombination;

public class RecursionExample {
    public static void main(String[] args) {
        int num = 4;
        System.out.println(factorial(num));
    }

    public static int factorial(int n) {
        if(n <= 1) return 1;
        return n * factorial(n-1);
    }
}
