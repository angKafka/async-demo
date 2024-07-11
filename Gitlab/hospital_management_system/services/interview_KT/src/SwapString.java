public class SwapString {
    public static void main(String[] args) {
        char a = 'c';
        char b = 'b';
        System.out.println(a+" "+b);
        System.out.println("========");
        swapString(a,b);
    }

    public static void swapString(char a, char b) {
        a = (char) (a + b);
        b = (char) (a - b);
        a = (char) (a - b);
        System.out.println(a+" "+b);
    }
}
