package Algorithms_Analysis_and_Design_Concepts.Bank_Ticketing_System.raj;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicketingTool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of tickets you want to ticket: ");
        int customers = sc.nextInt();
        if(customers > 0){
            Map<Integer, Integer> tickets = new HashMap<>(customers);
            System.out.println("Customers assigned the tickets below: ");
            for (int i = 0; i < customers; i++) {
                tickets.put(i, i+1);
                System.out.printf("%d ", tickets.get(i));
            }

            System.out.println();
            System.out.println("Enter the number of tickets served:");
            int served = sc.nextInt();
            if(served > 0 && served < customers){
                System.out.println("Customers query served: ");
                for(int i = 0; i < served; i++){
                    System.out.printf("%d ", tickets.get(i));
                }
            }

            if(served != customers){
                System.out.println();
                System.out.println("Customers query un-served: ");
                for(int i = served; i < customers; i++){
                    System.out.printf("%d ", tickets.get(i));
                }
            }
        }
    }
}
