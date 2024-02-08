import java.util.LinkedList;
import java.util.Queue;

/**
 *  Name: Stephen Carragher Kelly
 *  Class Group: GD2A
 */

public class CA3_Question5
{
    private static Queue<String> takeoff = new LinkedList<>();
    private static Queue<String> landing = new LinkedList<>();

    public static void takeoffM(String flightSymbol)
    {
        takeoff.add(flightSymbol);
        System.out.println("takeoff( \"" + flightSymbol + "\"); // is queued");
    }

    public static void landingM(String flightSymbol)
    {
        landing.add(flightSymbol);
        System.out.println("land( \"" + flightSymbol + "\"); // is queued");
    }

    public static void next()
    {
        if(!landing.isEmpty())
        {
            String planeLanding = landing.poll();
            System.out.println("Landing: " + planeLanding);
        }
        else if (!takeoff.isEmpty())
        {
            String planeTakeoff = takeoff.poll();
            System.out.println("Takeoff: " + planeTakeoff);
        }
        else
        {
            System.out.println("No flights in queue");
        }
    }

    public static void main(String[] args)
    {
        takeoffM("flight-90");
        takeoffM("flight-156");
        landingM("flight-331");
        next();
    }
}
