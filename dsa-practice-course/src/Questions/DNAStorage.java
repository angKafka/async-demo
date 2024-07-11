/*
DNA Storage
===========
For encoding an even-length binary string into a sequence of A, T, C, and G,
we iterate from left to right and replace the characters as follows:
00 is replaced with A
01 is replaced with T
10 is replaced with C
11 is replaced with G
*/
package Questions;

import java.util.Scanner;

public class DNAStorage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            String encSequence = "";
            // Your code goes here
            for(int index=0; index<n; index+=2) {
                char curr = s.charAt(index);
                char next = s.charAt(index+1);
                String pair = "" + curr + next;
                switch (pair){
                    case "00":
                        encSequence += "A";
                        break;
                    case "01":
                        encSequence += "T";
                        break;
                    case "10":
                        encSequence += "C";
                        break;
                    case "11":
                        encSequence += "G";
                        break;
                    default:
                        System.out.println("Not a valid choice!");
                        break;

                }
            }
            System.out.println(encSequence);
        }
    }
}
