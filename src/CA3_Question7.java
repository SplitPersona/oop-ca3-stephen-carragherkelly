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
    private static Map<String, Queue<Block>> sharesMap = new HashMap<>();

    public static void buy(String company, int quantity, double price)
    {
        sharesMap.putIfAbsent(company, new LinkedList<>());
        Queue<Block> sharesQueue = sharesMap.get(company);
        sharesQueue.add(new Block(quantity, price));
       // Block block = new Block(quantity, price);
       // shares.add(block);
    }

    public static void sell(String company, int quantity)
    {
        double totalgain = 0;
        Queue<Block> sharesQueue = sharesMap.get(company);
        if(sharesQueue != null)
        {
            while(quantity > 0 && !sharesQueue.isEmpty())
            {
                Block block = sharesQueue.poll();
                int blockquantity = block.quantity;

                if(blockquantity <= quantity)
                {
                    totalgain += (quantity - blockquantity) * block.price;
                    quantity -= blockquantity;
                }
                else
                {
                    totalgain += quantity * block.price;
                    block.quantity -= quantity;
                    sharesQueue.add(block);
                    quantity = 0;
                }

            }
            if(quantity > 0)
            {
                System.out.println("No shares in "+company+" to sell");
            }
            else
            {
                System.out.println("Total Gain for "+company+": "+totalgain);
            }
        }
        else
        {
            System.out.println("No shares for this company");
        }

    }


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
