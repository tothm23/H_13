package robotharc;

import robotharc.Felszereles.Fegyver;
import robotharc.Felszereles.Pancel;
import robotharc.Felszereles.Sisak;
import robotharc.Hiba.RobotHiba;

/**
 *
 * @author Tóth Milán
 *
 */
public class Harcos extends Robot {

    public Harcos(String nev, Szin szin, Integer eletero, Boolean harcose, Integer sebzes, Integer vedelem, Fegyver fegyver, Pancel pance, Sisak sisak) throws RobotHiba {
        super(nev, szin, eletero, harcose, sebzes, vedelem, fegyver, pance, sisak);
    }

    @Override
    public void Tamadas(Robot szenvedo) {

        // A támadó robot
        int sebzes = this.sebzes(); //12
        int vedelem = szenvedo.getVedelem(); // 8

        // Ezt külön kell tárolni, mert a Gyógyuláshoz kell
        int tenylegesSebzes = sebzes - vedelem;

        // Nem engedjük, hogy -okat sebezzen
        if (tenylegesSebzes < 0) {
            tenylegesSebzes = 0;
        }

        // 0-9 -> 10%
        if (Robot.randomszam(10) == 2) {
            tenylegesSebzes += 2;
            System.out.println(Szin.PIROS.get() + "\n⚠" + Szin.VISSZA.get() + " Kritikus sebzés!\n");
        } else {
        }

        System.out.print(Szin.SARGA.get() + "🔥 " + Szin.VISSZA.get() + this.szin.get() + this.getNev() + Szin.VISSZA.get() + " megtámadja " + szenvedo.getSzin().get() + szenvedo.getNev() + Szin.VISSZA.get() + " és " + tenylegesSebzes + " sebzést okoz");

        if (szenvedo.getEletero() >= 0) {
            // Nem a sebzés, hanem a sebzés - páncél értéket vonjuk ki
            szenvedo.setEletero(szenvedo.getEletero() - (sebzes - szenvedo.pancel.getVedelem())); // 30-4

            // A páncél tartosságából lejön a kivédett sebzés értéke
            // szenvedo.pancel.setTartossag(szenvedo.pancel.getTartossag() - szenvedo.pancel.getVedelem());
        } else {
        }

        System.out.println(" " + szenvedo.getSzin().get() + szenvedo.getNev() + Szin.VISSZA.get() + " életereje " + szenvedo.getEletero() + " lett");

        // Minden támadás után gyógyulnak a robotok
        this.Gyogyulas(sebzes);

    }
}
