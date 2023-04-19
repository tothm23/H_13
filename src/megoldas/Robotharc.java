package megoldas;

import java.util.ArrayList;

/**
 *
 * @author Paksi Norbert
 */
public class Robotharc {

    public static void main(String[] args) {
        ArrayList<Robot> robotok = new ArrayList<>();
        
        robotok.add(new Robot("Robi", "piros", 100, true, 10));
        robotok.add(new Robot("Zsolti", "zöld", 80, true, 5));
        robotok.add(new Robot("Laci", "kék", 120, true, 15));
        robotok.add(new Robot("Anna", "fehér", 90, true, 7));
        robotok.add(new Robot("Béla", "narancssárga", 110, true, 12));
        robotok.add(new Robot("Tibi", "fekete", 70, true, 3));
        robotok.add(new Robot("Judit", "lila", 95, true, 9));
        robotok.add(new Robot("Gabi", "sárga", 130, true, 18));

        Robot.Robotbajnoksag(robotok);
    }

}
