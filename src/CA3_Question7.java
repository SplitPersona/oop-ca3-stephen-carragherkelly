import java.util.*;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
/**
 *  Name: Stephen Carragher Kelly
 *  Class Group: GD2A
 */

class Block2
{
    int quantity;
    double price;

    public Block2(int quantity, double price)
    {
        this.quantity = quantity;
        this.price = price;
    }
}

public class CA3_Question7
{

    

    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String command="";

        do
        {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to buy shares here
            }
            else if(command.equals("sell"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to sell shares and calculate profit here
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}
