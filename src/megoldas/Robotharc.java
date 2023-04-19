package megoldas;

/**
 *
 * @author Paksi Norbert
 */
public class Robotharc {

    public static void main(String[] args) {
        Robot robot1 = new Robot("kecsketron", "fekete", 55, true, 5);
        Robot robot2 = new Robot("elektron", "fehér", 35, true, 15);

        Robot.Harc(robot1, robot2);
    }

}
