package megoldas;

/**
 *
 * @author Tóth Milán
 *
 */
import java.util.ArrayList;

/**
 *
 * @author Paksi Norbert
 */
public class Robotharc {

    public static void main(String[] args) {
        ArrayList<Robot> robotok = new ArrayList<>();

        robotok.add(new Harcos("Robi", "piros", 100, true, 10));
        robotok.add(new Healer("Zsolti", "zöld", 80, true, 5));
        robotok.add(new Ninja("Laci", "kék", 120, true, 15));
        robotok.add(new Harcos("Anna", "fehér", 90, true, 7));
        robotok.add(new Healer("Béla", "narancssárga", 110, true, 12));
        robotok.add(new Ninja("Tibi", "fekete", 70, true, 3));
        robotok.add(new Harcos("Judit", "lila", 95, true, 9));
        robotok.add(new Healer("Gabi", "sárga", 130, true, 18));

        Robot.Robotbajnoksag(robotok);
    }

}
