package megoldas;

/**
 *
 * @author Tóth Milán
 */
public class Healer extends Robot {

    public Healer(String nev, String szin, int eletero, boolean harcose, int sebzes) {
        super(nev, szin, eletero, harcose, sebzes);
    }

    @Override
    public void Tamadas(Robot szenvedo) {
        int sebzes = this.sebzes();
        int random = Robot.randomszam(20);

        if (random == 2) {
            System.out.println("Extra gyógyulás");
            this.Gyogyulas(sebzes, 3);
        } else {
            this.Gyogyulas(sebzes, 2);
        }

        System.out.print("🔥 " + this.getNev() + " megtámadja " + szenvedo.getNev() + " és " + sebzes + " sebzést okoz");
        szenvedo.setEletero(szenvedo.getEletero() - sebzes); // 30-4

        System.out.println(" " + szenvedo.getNev() + " életereje " + szenvedo.getEletero() + " lett");

    }
}
