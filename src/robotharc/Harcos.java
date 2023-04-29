package robotharc;

import robotharc.Felszereles.Fegyver;

/**
 *
 * @author Tóth Milán
 *
 */
public class Harcos extends Robot {

    public Harcos(String nev, Szin szin, Integer eletero, Boolean harcos, Integer sebzes, Fegyver fegyver) {
        super(nev, szin, eletero, harcos, sebzes, fegyver);
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
        szenvedo.setEletero(szenvedo.getEletero() - sebzes); // 30-4

        System.out.println(" " + szenvedo.getSzin().get() + szenvedo.getNev() + Szin.VISSZA.get() + " életereje " + szenvedo.getEletero() + " lett");

        // Minden támadás után gyógyulnak a robotok
        this.Gyogyulas(sebzes);
    }
}
