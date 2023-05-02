package robotharc;

/**
 *
 * @author Tóth Milán
 *
 */
// import java.util.ArrayList;
import robotharc.Felszereles.Fegyver;
import robotharc.Felszereles.Pancel;
import robotharc.Hiba.FegyverHiba;
import robotharc.Hiba.PancelHiba;
import robotharc.Hiba.RobotHiba;

/**
 *
 * @author Paksi Norbert
 */
public class Robotharc {

    public static void main(String[] args) {

        try {
            Fegyver kard = new Fegyver("kard", 4, 80, 2);
            Fegyver tor = new Fegyver("tőr", 5, 70, 3);

            Pancel vert = new Pancel("vért", 5, 10);

            Robot r1 = new Harcos("kecsketron", Szin.PIROS, 550, true, 2, 4, kard, vert); // 6-12 között sebez, vagy a dupláját ha kritikus támadás
            Robot r2 = new Ninja("elektron", Szin.KEK, 550, true, 2, 4, tor, vert); // 8-12 között sebez

            Robot.Harc(r1, r2);
        } catch (RobotHiba | FegyverHiba | PancelHiba h) {
            System.err.println(h.getMessage());
        }

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
