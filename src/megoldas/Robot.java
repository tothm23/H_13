package megoldas;

/**
 *
 * @author Paksi Norbert
 */
import java.util.Random;

public class Robot {

    private String nev;
    private String szin;
    private Integer eletero;
    private int maxEletero;
    private boolean harcose;
    private Integer sebzes;

    public Robot(String nev, String szin, int eletero, boolean harcose, int sebzes) {
        this.nev = nev;
        this.szin = szin;
        this.eletero = eletero;
        this.maxEletero = eletero;
        this.harcose = harcose;
        this.sebzes = sebzes;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    public int getMaxEletero() {
        return maxEletero;
    }

    public void setMaxEletero(int maxEletero) {
        this.maxEletero = maxEletero;
    }

    public boolean isHarcose() {
        return harcose;
    }

    public void setHarcose(boolean harcose) {
        this.harcose = harcose;
    }

    public int getSebzes() {
        return sebzes;
    }

    public void setSebzes(int sebzes) {
        this.sebzes = sebzes;
    }

    public static boolean Harcosok(Robot robot1, Robot robot2) {
        return robot1.harcose && robot2.harcose;
    }

    public static Robot Kezdorobot(Robot robot1, Robot robot2) {
        /*
        Vizsgálatok száma
        if (robot1.eletero > robot2.eletero) { // 1. vizsgálat
            return "robot2";
        } else if (robot1.eletero < robot2.eletero) { // 2. vizsgálat
            return "robot1";
        } else {
            if (robot1.sebzes > robot2.sebzes) { // 3. vizsgálat
                return "robot1";
            } else if (robot1.sebzes < robot2.sebzes) { // 4. vizsgálat
                return "robot2";
            } else {
                int szam1 = randomszam();
                int szam2 = randomszam();
                if (szam1 > szam2) {
                    return "robot1"; // 5. vizsgálat
                } else {
                    return "robot2"; // 5. vizsgálat
                }

            }
        }
         */

        if ((robot2.eletero > robot1.eletero)
                || (robot1.eletero.equals(robot2.eletero)) && robot1.sebzes > robot2.sebzes
                || (robot1.eletero.equals(robot2.eletero)) && robot1.sebzes.equals(robot2.sebzes) && Robot.randomszam(2) == 0) {
            return robot1; // 1 vagy 3 vizsgálat
        } else {
            return robot2; // 1 vagy 3 vizsgálat
        }
    }

    public static int randomszam(int max) {
        Random random = new Random();
        int x = random.nextInt(max);
        return x;
    }

    public static int veletlenEgeszSzam(int tol, int ig) {
        return (int) Math.floor(Math.random() * (ig - tol + 1) + tol);
    }

    public int sebzes() {
        return randomszam(this.sebzes + 1);
    }

    public void Tamadas(Robot szenvedo) {

        // A támadó robot
        int damage = this.sebzes(); // 4

        System.out.print(this.nev + " megtámadja " + szenvedo.nev + " és " + damage + " sebzést okoz neki.");
        szenvedo.setEletero(szenvedo.getEletero() - damage); // 30-4

        System.out.println(" " + szenvedo.nev + " életerejee " + szenvedo.getEletero() + " let.");

        // Minden támadás után gyógyulnak a robotok
        this.Gyogyulas(damage);
    }

    public void Gyogyulas(int damage) {
        if (damage == this.sebzes) {
            this.setEletero(this.getEletero() + 2);  // Max 40, Aktuális 32

            System.out.println(this.nev + " maximálisat sebzett, ezért gyógyult. Új életereje: " + this.eletero);
            if (this.eletero > this.maxEletero) {
                this.eletero = this.maxEletero;
            }
        }

    }

    public static void Harc(Robot robot1, Robot robot2) {
        if (Harcosok(robot1, robot2)) {
            Robot kezdorobot = Kezdorobot(robot1, robot2);
            boolean jatek = true;
            while (jatek) {
                if (kezdorobot.equals(robot1)) {
                    robot1.Tamadas(robot2);
                    if (robot2.eletero <= 0) {
                        System.out.println("Gyöztes: " + robot1.nev);
                        jatek = false;
                    } else {
                        robot2.Tamadas(robot1);
                    }

                } else {
                    robot2.Tamadas(robot1);
                    if (robot1.eletero <= 0) {
                        System.out.println("Gyöztes: " + robot2.nev);
                        jatek = false;
                    } else {
                        robot1.Tamadas(robot2);
                    }

                }

            }

        } else {
            System.out.println("Az egyik robot nem harcos.");
        }

    }
}
