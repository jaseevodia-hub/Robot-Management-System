public class MovingRobot extends BaseRobot
{

    private String terrain;

    public MovingRobot(String id, double batteryLevel,
                       String terrain)
    {
        super(id, batteryLevel);
        this.terrain = terrain;
    }

    public void drive()
    {
        useBattery(8);
        System.out.println(
            getId() + " is driving on " + terrain + " terrain."
        );
    }

    public void changeTerrain(String newTerrain)
    {
        if (newTerrain == null || newTerrain.trim().isEmpty())
        {
            throw new IllegalArgumentException(
                "Terrain cannot be empty."
            );
        }

        terrain = newTerrain;
        System.out.println(
            getId() + " is now navigating " + terrain + " terrain."
        );
    }

    @Override
    public void status()
    {
        System.out.println(
            "Moving Robot ID: " + getId()
            + ", Battery: " + getBatteryLevel()
            + "%, Terrain: " + terrain + "."
        );
    }
}