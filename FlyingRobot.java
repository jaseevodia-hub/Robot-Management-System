public class FlyingRobot extends BaseRobot
{

    private double altitude;

    public FlyingRobot(String id, double batteryLevel,
                       double altitude)
    {
        super(id, batteryLevel);
        this.altitude = altitude;
    }

    public void fly()
    {
        useBattery(10);
        System.out.println(
            getId() + " is flying at " + altitude + " metres."
        );
    }

    public void changeAltitude(double newAltitude)
    {
        if (newAltitude < 0)
        {
            throw new IllegalArgumentException(
                "Altitude cannot be negative."
            );
        }

        useBattery(5);
        altitude = newAltitude;

        System.out.println(
            getId() + " changed altitude to "
            + altitude + " metres."
        );
    }

    @Override
    public void status()
    {
        System.out.println(
            "Flying Robot ID: " + getId()
            + ", Battery: " + getBatteryLevel()
            + "%, Altitude: " + altitude + " metres."
        );
    }
}