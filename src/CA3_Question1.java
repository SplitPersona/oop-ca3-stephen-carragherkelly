import java.util.Stack;

/**
 *  Name: Stephen Carragher Kelly
 *  Class Group: GD2A
 */

public class CA3_Question1
{
    private static Stack<Integer> driveway = new Stack<>();
    private static Stack<Integer> street = new Stack<>();


    public static void runSimulation()
    {
        todriveway(1);
        todriveway(2);
        todriveway(3);

        System.out.println();
        System.out.println("Added cars 1,2,3, to driveway");
        System.out.println("Driveway: " + driveway);
        System.out.println("Street: " + street);
        System.out.println();

        takefromdriveway(2);

        System.out.println();
        System.out.println("taken car 2 from driveway");
        System.out.println("Driveway: " + driveway);
        System.out.println("Street: " + street);
        System.out.println();

        todriveway(4);

        System.out.println();
        System.out.println("Added car 4 to driveway");
        System.out.println("Driveway: " + driveway);
        System.out.println("Street: " + street);
        System.out.println();

    }

    private static void todriveway(int carnum)
    {
        driveway.push(carnum);
        System.out.println(carnum + " is in the driveway");
    }

    private static void takefromdriveway(int carnum)
    {
        while(!driveway.isEmpty() && driveway.peek() != carnum)
        {
            int moveCar = driveway.pop();
            street.push(moveCar);
            System.out.println(moveCar + " has been moved to the street");
        }
        if(!driveway.isEmpty())
        {
            int getCar = driveway.pop();
            System.out.println(getCar+ " has been gotton from the driveway");
        }
        else
        {
            System.out.println(carnum + " does not exist");
        }
    }

    public static void main(String[] args)
    {
        runSimulation();
    }
}
