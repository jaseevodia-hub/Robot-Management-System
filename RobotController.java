import java.util.ArrayList;
import java.util.List;

public class RobotController
{

    private List<Robot> robots;

    public RobotController()
    {
        robots = new ArrayList<>();
    }

    // Add any object that implements Robot
    public void addRobot(Robot robot)
    {
        robots.add(robot);
    }

    // Start all robots
    public void startAll()
    {
        for (Robot robot : robots)
        {
            try
            {
                robot.start();
            } catch (IllegalStateException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Display each robot's status
    public void showStatuses()
    {
        for (Robot robot : robots)
        {
            robot.status();
        }
    }

    // Stop all robots
    public void stopAll()
    {
        for (Robot robot : robots)
        {
            robot.stop();
        }
    }
}