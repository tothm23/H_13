package robotharc;

import robotharc.Felszereles.Fegyver;
import robotharc.Felszereles.Pancel;
import robotharc.Hiba.RobotHiba;

/**
 *
 * @author Tóth Milán
 *
 */
public class Harcos extends Robot {

    public Harcos(String nev, Szin szin, Integer eletero, Boolean harcos, Integer sebzes, Fegyver fegyver, Pancel pancel) throws RobotHiba {
        super(nev, szin, eletero, harcos, sebzes, fegyver, pancel);
    }

    @Override
    public void Tamadas(Robot szenvedo) {

        int sebzes = this.sebzes();
        int random = Robot.randomszam(10);

        if (random == 2) {
            sebzes += 2;
            System.out.println("⚠️ Kritikus sebzés");
        } else {
        }

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

        // Minden támadás után gyógyulnak a robotok
        this.Gyogyulas(sebzes);

    }
}
