//Swap two numbers without using temp variable
package Questions;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        System.out.println(a+" "+b);
        System.out.println("\n");
        swap(a, b);
    }

    public static void swap(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a+" "+b);
    }
}
