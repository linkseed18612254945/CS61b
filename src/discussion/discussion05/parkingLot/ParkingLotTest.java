package discussion.discussion05.parkingLot;

/**
 * Created by 51694 on 2017/3/24.
 */
public class ParkingLotTest
{
    public static void main(String[] args)
    {
        ParkingLot pl;
        Car a = new Car("regular", "emi");
        Car a1 = new Car("regular", "cme");
        Car a2 = new Car("regular", "dmi");
        Car a3 = new Car("regular", "qmi");

        Car b = new Car("compact", "luke");

        Car c = new Car("handicapped", "bob");
        Car c1 = new Car("handicapped", "rob");
        Car c2 = new Car("handicapped", "lop");

        int[] rePD = new int[]{1, 2, 3};
        int[] coPD = new int[]{3, 5, 2, 1};
        int[] haPD = new int[]{4, 2};
        pl = new ParkingLot(rePD, coPD, haPD);
        pl.findSpotAndPark(a);
        pl.findSpotAndPark(b);
        pl.findSpotAndPark(c);
        pl.findSpotAndPark(a1);
        pl.findSpotAndPark(c1);
        pl.findSpotAndPark(c2);
        pl.printStatus();
        System.out.println();
        System.out.println();
        pl.removeCarFromSpot(c2);
        pl.removeCarFromSpot(c2);
        pl.printStatus();
    }
}
