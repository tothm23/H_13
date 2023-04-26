package megoldas;

import megoldas.Felszereles.Fegyver;

/**
 *
 * @author Tóth Milán
 *
 */
public class Ninja extends Robot {

    public Ninja(String nev, String szin, int eletero, boolean harcose, int sebzes, Fegyver fegyver) {
        super(nev, szin, eletero, harcose, sebzes, fegyver);
    }

    @Override
    public void Tamadas(Robot szenvedo) {
        int sebzes = this.sebzes();
        int random = Robot.randomszam(10);  // 0-9

        if (random == 2) {
            sebzes = 0;
            System.out.println("Dodge!");
            System.out.print("🔥 " + this.getNev() + " megtámadja " + szenvedo.getNev() + " és nem okoz neki sebzést\n");
        } else {
            System.out.print("🔥 " + this.getNev() + " megtámadja " + szenvedo.getNev() + " és " + sebzes + " sebzést okoz");
            szenvedo.setEletero(szenvedo.getEletero() - sebzes); // 30-4

            System.out.println(" " + szenvedo.getNev() + " életereje " + szenvedo.getEletero() + " lett");
        }

    }
}
