package robotharc;

/**
 *
 * @author Tóth Milán
 *
 */
// import java.util.ArrayList;
import robotharc.Felszereles.Fegyver;

/**
 *
 * @author Paksi Norbert
 */
public class Robotharc {

    public static void main(String[] args) {
       

        Fegyver kard = new Fegyver("kard", 4, 8, 2);
        Fegyver tor = new Fegyver("tőr", 5, 7, 3);

        Robot r1 = new Harcos("kecsketron", "fekete", 55, true, 2, kard);   // 6-12 között sebez, vagy a dupláját ha kritikus támadás
        Robot r2 = new Ninja("elektron", "fehér", 55, true, 2, tor);    // 8-12 között sebez

        Robot.Harc(r1, r2);
        /*
        // Robotbajnokság
        
         ArrayList<Robot> robotok = new ArrayList<>();
        
        robotok.add(new Harcos("Robi", "piros", 100, true, 10, kard));
        robotok.add(new Healer("Zsolti", "zöld", 80, true, 5, tor));
        robotok.add(new Ninja("Laci", "kék", 120, true, 15, kard));
        robotok.add(new Harcos("Anna", "fehér", 90, true, 7, tor));
        robotok.add(new Healer("Béla", "narancssárga", 110, true, 12, kard));
        robotok.add(new Ninja("Tibi", "fekete", 70, true, 3, tor));
        robotok.add(new Harcos("Judit", "lila", 95, true, 9, kard));
        robotok.add(new Healer("Gabi", "sárga", 130, true, 18, tor));

        Robot.Robotbajnoksag(robotok);
         */
    }

}
