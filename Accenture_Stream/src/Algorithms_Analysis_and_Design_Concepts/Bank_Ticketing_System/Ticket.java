package Algorithms_Analysis_and_Design_Concepts.Bank_Ticketing_System;

/*
In the ticketing system of a Bank,
each customer takes a ticket and is served when their number is called.
Imagine there are five customers take a ticket from our ticketing system.
The first customer has a ticket displaying the number 1 and the fifth customer
has a ticket displaying the number 5. The customers who take the ticket should
maintain a queue and the customer with the first ticket should be served first.
When the first customer is served and that ticket is removed from the queue.
*/
import java.util.*;
public class Ticket
{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of customer takes the tickets:");
        int n=sc.nextInt();
        if(n>0)
        {
            int[] tickets=new int[n];

            System.out.println("The tickets in the system are:");
            for(int i=0; i<n; i++)
            {
                tickets[i]=i+1;
                System.out.print(tickets[i]+" ");
            }
            System.out.println();
            System.out.println("Enter the number of tickets served:");
            int served=sc.nextInt();

            if(served>0 && served<=n)
            {
                System.out.println("The served tickets are:");
                for(int i=0;i<served;i++)
                {
                    System.out.print(tickets[i]+" ");
                }
                System.out.println();

                if(served!=n)
                {
                    System.out.println("The unserved tickets are:");
                    for(int i=served;i<n;i++)
                    {
                        System.out.print(tickets[i]+" ");
                    }
                }
                else
                {
                    System.out.println("No more tickets to be served");
                }
            }

        }
        else
        {
            System.out.println("Invalid Number");
        }

    }
}
