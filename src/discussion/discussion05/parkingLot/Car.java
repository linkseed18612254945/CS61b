package discussion.discussion05.parkingLot;

/**
 * Created by 51694 on 2017/3/24.
 */
public class Car
{
    private String carClass;
    private Spot parkSpot;
    public String carName;

    Car(String cc, String name)
    {
        carClass = cc;
        parkSpot = null;
        carName = name;
    }

    public String getCarClass()
    {
        return carClass;
    }

    public void setParkSpot(Spot parkSpot)
    {
        this.parkSpot = parkSpot;
    }

    public Spot getParkSpot()
    {
        return parkSpot;
    }
}
