public class WalkingRobot extends BaseRobot
{

    private int obstaclesCrossed;

    public WalkingRobot(String id, double batteryLevel)
    {
        super(id, batteryLevel);
        this.obstaclesCrossed = 0;
    }

    public void walk()
    {
        useBattery(6);
        System.out.println(
            getId() + " is walking on two legs."
        );
    }

    public void crossObstacle()
    {
        useBattery(8);
        obstaclesCrossed++;

        System.out.println(
            getId() + " crossed an obstacle successfully."
        );
    }

    @Override
    public void status()
    {
        System.out.println(
            "Walking Robot ID: " + getId()
            + ", Battery: " + getBatteryLevel()
            + "%, Obstacles Crossed: " + obstaclesCrossed + "."
        );
    }
}