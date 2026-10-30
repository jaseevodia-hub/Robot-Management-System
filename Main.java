public class Main
{

    public static void main(String[] args)
    {

        // Create objects using constructors
        FlyingRobot flyingRobot =
            new FlyingRobot("FR101", 80, 100);

        MovingRobot movingRobot =
            new MovingRobot("MR201", 70, "Rocky");

        WalkingRobot walkingRobot =
            new WalkingRobot("WR301", 60);

        // Create the controller
        RobotController controller = new RobotController();

        // Add robots to the controller
        controller.addRobot(flyingRobot);
        controller.addRobot(movingRobot);
        controller.addRobot(walkingRobot);

        System.out.println("=== STARTING ALL ROBOTS ===");
        controller.startAll();

        System.out.println("\n=== ROBOT BEHAVIORS ===");

        try
        {
            flyingRobot.fly();
            flyingRobot.changeAltitude(150);

            movingRobot.drive();
            movingRobot.changeTerrain("Gravel");

            walkingRobot.walk();
            walkingRobot.crossObstacle();

        } catch (IllegalStateException |
                 IllegalArgumentException e)
                 {
                    System.out.println("Robot error: " + e.getMessage());
                 }

        System.out.println("\n=== METHOD OVERLOADING ===");

        // Version 1: speed only
        flyingRobot.move(50);

        // Version 2: speed and direction
        movingRobot.move(30, "North");

        // Another example of the overloaded method
        walkingRobot.move(5, "Forward");

        System.out.println("\n=== ROBOT STATUSES ===");
        controller.showStatuses();

        System.out.println("\n=== STOPPING ALL ROBOTS ===");
        controller.stopAll();

        System.out.println("\n=== LOW BATTERY TEST ===");

        try
        {
            FlyingRobot lowBatteryRobot =
                new FlyingRobot("FR999", 5, 50);

            lowBatteryRobot.start();

        } catch (IllegalStateException e)
        {
            System.out.println(
                "Exception handled: " + e.getMessage()
            );
        }
    }
}