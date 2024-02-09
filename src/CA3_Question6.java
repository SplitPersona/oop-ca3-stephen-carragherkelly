import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

/**
 *  Name: Stephen Carragher Kelly
 *  Class Group: GD2A
 */

class Block
{
    int quantity;
    double price;

    public Block(int quantity, double price)
    {
        this.quantity = quantity;
        this.price = price;
    }
}

public class CA3_Question6
{

    private static Queue<Block> shares = new LinkedList<>();

    public static void buy(int quantity, double price)
    {
        Block block = new Block(quantity, price);
        shares.add(block);
    }

    public static void sell(int quantity)
    {
        double totalgain = 0;
        while(quantity > 0 && !shares.isEmpty())
        {
            Block block = shares.poll();
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
                shares.add(block);
                quantity = 0;
            }

        }
        if(quantity > 0)
        {
            System.out.println("No shares to sell");
        }
        else
        {
            System.out.println("Total Gain: "+totalgain);
        }

    }

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
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
                int qty = in.nextInt();
                double price = in.nextDouble();
                buy(qty,price);

            }
            else if(command.equals("sell"))
            {
                int qty = in.nextInt();
                //double price = in.nextDouble();
                sell(qty);

            }
        }
        while(!command.equalsIgnoreCase("quit"));
    }
}