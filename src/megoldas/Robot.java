package megoldas;

/**
 *
 * @author Paksi Norbert
 */
import java.util.ArrayList;
import java.util.Random;
import megoldas.Felszereles.Fegyver;

public abstract class Robot {

    protected String nev;
    protected String szin;
    protected Integer eletero;
    protected int maxEletero;
    protected boolean harcose;
    protected Integer ero;

    // páncél/védelmi pont (nem muszály, leht 0))
    // tárgyak
    protected Fegyver fegyver;

    public Robot(String nev, String szin, int eletero, boolean harcose, int sebzes, Fegyver fegyver) {
        this.nev = nev;
        this.szin = szin;
        this.eletero = eletero; // bemenő paraméter + páncél által adott életerő
        this.maxEletero = eletero;
        this.harcose = harcose;
        this.ero = sebzes;
        this.fegyver = fegyver;
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

    public int getEro() {
        return ero;
    }

    public void setEro(int sebzes) {
        this.ero = sebzes;
    }

    /**
     * Megállapítja, hogy mindkét robot harcos-e
     *
     * @param robot1
     * @param robot2
     * @return
     */
    public static boolean Harcosok(Robot robot1, Robot robot2) {
        return robot1.harcose && robot2.harcose;
    }

    /**
     * Kisorsoljuk a kezdő robotot
     *
     * @param robot1
     * @param robot2
     * @return
     */
    public static Robot Kezdorobot(Robot robot1, Robot robot2) {
        /*
        Vizsgálatok száma
        if (robot1.eletero > robot2.eletero) { // 1. vizsgálat
            return "robot2";
        } else if (robot1.eletero < robot2.eletero) { // 2. vizsgálat
            return "robot1";
        } else {
            if (robot1.ero > robot2.ero) { // 3. vizsgálat
                return "robot1";
            } else if (robot1.ero < robot2.ero) { // 4. vizsgálat
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
                || (robot1.eletero.equals(robot2.eletero)) && robot1.ero > robot2.ero
                || (robot1.eletero.equals(robot2.eletero)) && robot1.ero.equals(robot2.ero) && Robot.randomszam(2) == 0) {
            return robot1; // 1 vagy 3 vizsgálat
        } else {
            return robot2; // 1 vagy 3 vizsgálat
        }
    }

    /**
     * Visszaad egy egész számot
     *
     * @param max
     * @return
     */
    public static int randomszam(int max) {
        Random random = new Random();
        int x = random.nextInt(max);
        return x;
    }

    /**
     * Visszaad egy egész számot a megadott tartomány szerint
     *
     * @param tol
     * @param ig
     * @return
     */
    public static int veletlenEgeszSzam(int tol, int ig) {
        return (int) Math.floor(Math.random() * (ig - tol + 1) + tol);
    }

    public int sebzes() {
        //return randomszam(this.ero + 1);

        // Fegyver miatt megváltoztatott verzió
        int sebzes = randomszam(this.ero + 1);  // 0 és karakter közötti random szám generálás
        sebzes += this.fegyver.getEro();    // A korábbi értékhez hozzáadjuk a fegyver erő tulajdonságát

        int max = this.fegyver.getMaximumSebzes();  // 18
        int min = this.fegyver.getMinimumSebzes();  // 12  
        int range = max - min;  // 6

        int fegyverSebzes = randomszam(range + 1);  // 0-5
        fegyverSebzes += min;   // 0-6 + 12 -> 12 - 18

        sebzes += fegyverSebzes;   // Az erő értékekből számolt fix sebzéshez hozzáadjuk a fegyverből generált random sebzést
        // System.out.println("Min: " + min + " MAx: " + max + " fegyver sebzése: " + fegyversebzes + " Teljes sebzés: " + sebzes);

        return sebzes;
    }

    public void Tamadas(Robot szenvedo) {

        // A támadó robot
        int damage = this.sebzes(); // 4

        // Védekező robot páncél/ védelmi pont értékének kiszámolása (páncél tulajdonság + )
        System.out.print("🔥 " + this.nev + " megtámadja " + szenvedo.nev + " és " + damage + " sebzést okoz");

        if (szenvedo.getEletero() - damage >= 0) {
            // Nem a sebzés, hanem a sebzés - páncél értéket vonjuk ki
            szenvedo.setEletero(szenvedo.getEletero() - damage); // 30-4
        } else {
            return;
        }

        System.out.println(" " + szenvedo.nev + " életereje " + szenvedo.getEletero() + " lett");

        // Minden támadás után gyógyulnak a robotok
        Gyogyulas(damage);
    }

    public void Gyogyulas(int damage) {
        if (damage == this.ero) {
            // aktuális élet leht több, mint a max élet, ezért a maxélet + 
            this.setEletero(this.getEletero() + 2);  // Max 40, Aktuális 32

            System.out.println("\n🖤 " + this.nev + " maximálisat sebzett, ezért gyógyult. Új életereje: " + this.eletero + "\n");
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
            System.exit(0);
        }
    }

    /**
     * Megállapítja a jelenlegi fordulő győztesét
     *
     * @param robot1
     * @param robot2
     * @return
     */
    public static Robot Gyoztes(Robot robot1, Robot robot2) {

        if (Harcosok(robot1, robot2)) {

            Robot kezdorobot = Kezdorobot(robot1, robot2);
            boolean jatek = true;

            while (jatek) {
                if (kezdorobot.equals(robot1)) {
                    robot1.Tamadas(robot2);

                    if (robot2.getEletero() <= 0) {
                        jatek = false;
                        return robot1;
                    } else {
                        robot2.Tamadas(robot1);
                    }

                } else {
                    robot2.Tamadas(robot1);

                    if (robot1.getEletero() <= 0) {
                        jatek = false;
                        return robot2;
                    } else {
                        robot1.Tamadas(robot2);
                    }

                }

            }

        } else {
            System.out.println("Az egyik robot nem harcos.");
            System.exit(0);
        }

        return null;

    }

    public static void Robotbajnoksag(ArrayList<Robot> robotok) {

        boolean bajnoksag = true;

        for (Robot robot : robotok) {

            // Ha van akár 1 olyan robot, amelyik nem harcos
            if (!robot.isHarcose()) {

                // Akkor nem lesz bajnokság
                bajnoksag = false;
            }
        }
        // CSak akkor lehet bajnokság, ha minden robot harcos
        if (bajnoksag) {
            // A robotok akik bejutottak al elődöntőbe 5 életet kapnak
            Robot elodontosA = Gyoztes(robotok.get(0), robotok.get(1));
            elodontosA.setEletero(elodontosA.getEletero() + 5);
            System.out.println("\n🏆  Az 1. elődöntős " + elodontosA.getNev() + ", aki kap 5 életerőt, így életereje " + elodontosA.getEletero() + " lett\n");

            Robot elodontosB = Gyoztes(robotok.get(2), robotok.get(3));
            elodontosB.setEletero(elodontosB.getEletero() + 5);
            System.out.println("\n🏆 A 2. elődöntős " + elodontosB.getNev() + ", aki kap 5 életerőt, így életereje " + elodontosB.getEletero() + " lett\n");

            Robot elodontosC = Gyoztes(robotok.get(4), robotok.get(5));
            elodontosC.setEletero(elodontosC.getEletero() + 5);
            System.out.println("\n🏆 A 3. elődöntős " + elodontosC.getNev() + ", aki kap 5 életerőt, így életereje " + elodontosC.getEletero() + " lett\n");

            Robot elodontosD = Gyoztes(robotok.get(6), robotok.get(7));
            elodontosD.setEletero(elodontosD.getEletero() + 5);
            System.out.println("\n🏆 A 4. elődöntős " + elodontosD.getNev() + ", aki kap 5 életerőt, így életereje " + elodontosD.getEletero() + " lett\n");

            // A robotok akik bejutottak al döntőbe 5 életet kapnak
            Robot dontosA = Gyoztes(elodontosA, elodontosB);
            dontosA.setEletero(dontosA.getEletero() + 5);
            System.out.println("\n🏆 Az 1. döntős " + dontosA.getNev() + ", aki kap 5 életerőt, így életereje " + dontosA.getEletero() + " lett\n");

            Robot dontosB = Gyoztes(elodontosC, elodontosD);
            dontosB.setEletero(dontosB.getEletero() + 5);
            System.out.println("\n🏆 A 2. döntős " + dontosB.getNev() + ", aki kap 5 életerőt, így életereje " + dontosB.getEletero() + " lett\n");

            Robot gyoztes = Gyoztes(dontosA, dontosB);

            System.out.println("\n🏆🏆🏆🏆🏆 🏆🏆🏆🏆🏆 🏆🏆🏆🏆🏆 🏆🏆🏆🏆🏆");
            System.out.println("🏆  A bajnok nem más, mint " + gyoztes.getNev() + " !  🏆");
            System.out.println("🏆🏆🏆🏆🏆 🏆🏆🏆🏆🏆 🏆🏆🏆🏆🏆 🏆🏆🏆🏆🏆\n");
        }

    }

}
