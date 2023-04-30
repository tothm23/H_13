package robotharc;

import robotharc.Felszereles.Fegyver;
import robotharc.Felszereles.Pancel;
import robotharc.Hiba.RobotHiba;

/**
 *
 * @author Tóth Milán
 *
 */
public class Ninja extends Robot {

    public Ninja(String nev, Szin szin, int eletero, boolean harcose, int sebzes, Fegyver fegyver, Pancel pancel) throws RobotHiba {
        super(nev, szin, eletero, harcose, sebzes, fegyver, pancel);
    }

    @Override
    public void Tamadas(Robot szenvedo) {
        int sebzes = this.sebzes();

        // 10% esélye lesz kitérni egy támadás elől
        int random = Robot.randomszam(10);  // 0-9

        if (random == 2) {
            sebzes = 0;
            System.out.println("⚠️ Kitérés!");
            System.out.print("🔥 " + this.szin.get() + this.getNev() + Szin.VISSZA.get() + " megtámadja " + szenvedo.getSzin().get() + szenvedo.getNev() + Szin.VISSZA.get() + " és nem okoz neki sebzést\n");
        } else {
            System.out.print("🔥 " + this.szin.get() + this.getNev() + Szin.VISSZA.get() + " megtámadja " + szenvedo.getSzin().get() + szenvedo.getNev() + Szin.VISSZA.get() + " és " + sebzes + " sebzést okoz");

            if (szenvedo.getEletero() >= 0) {
                // Nem a sebzés, hanem a sebzés - páncél értéket vonjuk ki
                szenvedo.setEletero(szenvedo.getEletero() - (sebzes - szenvedo.pancel.getVedelem())); // 30-4

                // A páncél tartosságából lejön a kivédett sebzés értéke
                szenvedo.pancel.setTartossag(szenvedo.pancel.getTartossag() - szenvedo.pancel.getVedelem());
            } else {
                return;
            }

            System.out.println(" " + szenvedo.getSzin().get() + szenvedo.getNev() + Szin.VISSZA.get() + " életereje " + szenvedo.getEletero() + " lett");
        }

    }
    /*
    @Override
    public void setEletero(int eletero) {
        int generated = randomszam(10); // 0- 9
        if (generated == 6) {
            System.out.println("Kitérés");
        } else {
            this.eletero = eletero;
        }
    }
     */

}
