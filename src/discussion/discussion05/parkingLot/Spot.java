package discussion.discussion05.parkingLot;

/**
 * Created by 51694 on 2017/3/24.
 */
public class Spot
{
    private int distance;
    private String spotClass;
    private Car spotCar;

    Spot(int d, String s)
    {
        distance = d;
        spotClass = s;
        spotCar = null;
    }

    public boolean isEmpty()
    {
       return spotCar == null;
    }


    public int getDistance()
    {
        return distance;
    }

    public void setSpotCar(Car spotCar)
    {
        this.spotCar = spotCar;
    }

    public String toString()
    {
        String returnString = "empty";
        if (spotCar != null)
        {
            returnString = spotCar.carName;
        }
        return returnString;
    }
}
