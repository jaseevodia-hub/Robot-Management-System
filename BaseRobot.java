public abstract class BaseRobot implements Robot
{

    private String id;
    private double batteryLevel;

    // Constructor
    public BaseRobot(String id, double batteryLevel)
    {
        if (batteryLevel < 0 || batteryLevel > 100)
        {
            throw new IllegalArgumentException(
                "Battery level must be between 0 and 100."
            );
        }

        this.id = id;
        this.batteryLevel = batteryLevel;
    }

    // Getters
    public String getId()
    {
        return id;
    }

    public double getBatteryLevel()
    {
        return batteryLevel;
    }

    // Check battery before performing an action
    protected void checkBattery()
    {
        if (batteryLevel < 10)
        {
            throw new IllegalStateException(
                "Low battery! Robot " + id + " cannot operate."
            );
        }
    }

    // Reduce battery when the robot performs an action
    protected void useBattery(double amount)
    {
        checkBattery();

        if (amount < 0 || amount > batteryLevel)
        {
            throw new IllegalArgumentException(
                "Invalid battery consumption amount."
            );
        }

        batteryLevel -= amount;
    }

    // Common method: overriding an interface method
    @Override
    public void start()
    {
        checkBattery();
        System.out.println(id + " has started.");
    }

    @Override
    public void stop()
    {
        System.out.println(id + " has stopped.");
    }

    // Method overloading: version 1
    public void move(double speed)
    {
        checkBattery();
        System.out.println(
            id + " is moving at " + speed + " km/h."
        );
    }

    // Method overloading: version 2
    public void move(double speed, String direction)
    {
        checkBattery();
        System.out.println(
            id + " is moving at " + speed
            + " km/h towards " + direction + "."
        );
    }

    // Every robot type must provide its own status
    @Override
    public abstract void status();
}