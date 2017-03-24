package discussion.discussion05.parkingLot;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 51694 on 2017/3/24.
 */
public class ParkingLot
{
    private Spot[] regularSpots;
    private Spot[] compactSpots;
    private Spot[] handicappedSpots;
    private Map<String, Spot[]> spotClassMap = new HashMap<>();

    /** Create a parkinglot with some regular, compact and handicapped spot, the spots distance should be given by array*/
    ParkingLot(int[] regularDistances, int[] compactDistances,int[] handicappedDistances)
    {
        regularSpots = new Spot[regularDistances.length];
        for (int i = 0; i < regularDistances.length; i += 1)
        {
            regularSpots[i] = new Spot(regularDistances[i], "regular");
        }

        compactSpots = new Spot[compactDistances.length];
        for (int i = 0; i < compactDistances.length; i += 1)
        {
            compactSpots[i] = new Spot(compactDistances[i], "compact");
        }

        handicappedSpots = new Spot[handicappedDistances.length];
        for (int i = 0; i < handicappedDistances.length; i += 1)
        {
            handicappedSpots[i] = new Spot(handicappedDistances[i], "handicapped");
        }
        spotClassMap.put("regular", regularSpots);
        spotClassMap.put("compact", compactSpots);
        spotClassMap.put("handicapped", handicappedSpots);
    }

    /** Check if certain spots have an empty spot to park */
    private boolean HasEmptySpot(Spot[] spotClass)
    {
        for(Spot s : spotClass)
        {
            if (s.isEmpty())
            {
                return true;
            }
        }
        return false;
    }

    private Spot findClosestSpot(Spot[] spots)
    {
        Spot closestSpot = spots[0];
        for(Spot s : spots)
        {
            if (s.isEmpty())
            {
                closestSpot = s;
                break;
            }
        }
        for(Spot s : spots)
        {
            if (s.isEmpty() && s.getDistance() < closestSpot.getDistance())
            {
                closestSpot = s;
            }
        }
        return closestSpot;
    }

    /** Find the closest spot to park */
    public boolean findSpotAndPark(Car toParkCar)
    {
        Spot[] certainSpots = spotClassMap.get(toParkCar.getCarClass());
        if (HasEmptySpot(certainSpots))
        {
            Spot closestEmptySpot = findClosestSpot(certainSpots);
            closestEmptySpot.setSpotCar(toParkCar);
            toParkCar.setParkSpot(closestEmptySpot);
            return true;
        }
        else if (HasEmptySpot(regularSpots) && !toParkCar.getCarClass().equals("regular"))
        {
            Spot closestEmptySpot = findClosestSpot(regularSpots);
            closestEmptySpot.setSpotCar(toParkCar);
            toParkCar.setParkSpot(closestEmptySpot);
            return true;
        }
        else
        {
            return false;
        }
    }

    public void removeCarFromSpot(Car toRemoveCar)
    {
        Spot toClearSpot = toRemoveCar.getParkSpot();
        if (toClearSpot != null)
        {
            toRemoveCar.setParkSpot(null);
            toClearSpot.setSpotCar(null);
        }
    }

    public void printStatus()
    {
        for (Spot s: regularSpots)
        {
            System.out.print(s + " ");
        }
        System.out.println();
        for (Spot s: compactSpots)
        {
            System.out.print(s + " ");
        }
        System.out.println();
        for (Spot s: handicappedSpots)
        {
            System.out.print(s + " ");
        }
    }

}
