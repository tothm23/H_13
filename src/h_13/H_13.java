package h_13;

/**
 *
 * @author Tóth Milán
 */
public class H_13 {

    public static void main(String[] args) {
        Robot r1 = new Robot("R1", "fekete", 100, Boolean.TRUE, 30);
        Robot r2 = new Robot("R2", "fehér", 100, Boolean.TRUE, 35);

        Robot.statisztika(r1);
        Robot.statisztika(r2);
        while (true) {
            Robot.harc(r1, r2);
            if (r1.getEletero() < 0 || r2.getEletero() < 0) {
                break;
            }
        }
    }

}
