package robotharc;

import robotharc.Felszereles.Fegyver;
import robotharc.Felszereles.Pancel;
import robotharc.Hiba.RobotHiba;

/**
 *
 * @author Tóth Milán
 */
public class Gyogyito extends Robot {

    public Gyogyito(String nev, Szin szin, int eletero, boolean harcose, int sebzes, Fegyver fegyver, Pancel pancel) throws RobotHiba {
        super(nev, szin, eletero, harcose, sebzes, fegyver, pancel);
    }

    /*
        @Override
    public void setEletero(int eletero) {
        Random rand = new Random();
        int generated = rand.nextInt(20);

        if(generated == 4 && eletero != this.maxEletero){
            eletero += 3;
            System.err.println("KAPTÁL 3 ÉLETERŐT");
        }else{
            this.eletero = eletero;
        }
    }
     */
 /*
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
     */
    @Override
    public void Gyogyulas(int serules) {

        if (serules == this.ero) {

            // Aktuális élet lehet több mint a max élet, ezéret a maxélet + páncél életereje értékkel kell dolgozni
            this.setEletero(this.getEletero() + 2 + this.pancel.getVedelem()); // Max 40, Aktuális 48

            if (this.eletero > this.maxEletero + this.pancel.getVedelem()) {
                this.eletero = this.maxEletero;
            }

            System.out.println("\n🖤 " + this.szin.get() + this.nev + Szin.VISSZA.get() + " maximálisat sebzett, ezért gyógyult. Új életereje: " + this.eletero + "\n");
        }

        int generated = Robot.randomszam(20);
        if (generated == 4 && eletero != this.maxEletero) {
            eletero += 3;
            System.out.println("⚠️ Extra gyógyulás");
        }

    }
}
