import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 *  Name: Stephen Carragher Kelly
 *  Class Group: GD2A
 */
public class CA3_Question10
{

    public static void main(String[] args)
    {
        Map<String, TreeSet<DistanceTo>> connections = new HashMap<>();
        PriorityQueue<DistanceTo> pQueue = new PriorityQueue<>();
        Map<String, Integer> shortestDistance = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("citydistances.txt")))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] parts = line.split(" ");
                String city1 = parts[0];
                String city2 = parts[1];
                int distance = Integer.parseInt(parts[2]);

                connections.computeIfAbsent(city1, k -> new TreeSet<>()).add(new DistanceTo(city2, distance));
                connections.computeIfAbsent(city2, k -> new TreeSet<>()).add(new DistanceTo(city1, distance));

            }
            String startingpoint = connections.keySet().iterator().next();

            pQueue.add(new DistanceTo(startingpoint, 0));
            while(!pQueue.isEmpty())
            {
                DistanceTo currentcity = pQueue.poll();
                String currenttarget = currentcity.getTarget();
                int currentdistance = currentcity.getDistance();

                if(!shortestDistance.containsKey(currenttarget))
                {
                    shortestDistance.put(currenttarget, currentdistance);
                    for(DistanceTo nextcity: connections.getOrDefault(currenttarget, new TreeSet<>()))
                    {
                        pQueue.add(new DistanceTo(nextcity.getTarget(), currentdistance + nextcity.getDistance()));
                    }
                }
            }

            System.out.println("Shorest distance from "+startingpoint+":");
            for(Map.Entry<String, Integer> entry: shortestDistance.entrySet())
            {
                System.out.println(entry.getKey()+": "+entry.getValue());
            }

        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
