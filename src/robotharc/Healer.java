package robotharc;

import java.util.Random;
import robotharc.Felszereles.Fegyver;

/**
 *
 * @author Tóth Milán
 */
public class Healer extends Robot {

    public Healer(String nev, String szin, int eletero, boolean harcose, int sebzes, Fegyver fegyver) {
        super(nev, szin, eletero, harcose, sebzes, fegyver);
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
    public void Gyogyulas(int damage) {

        if (damage == this.ero) {

            this.setEletero(this.getEletero() + 2); // Max 40, Aktuális 48
            if (this.eletero > this.maxEletero) {
                this.eletero = this.maxEletero;
            }

            System.out.println("\n🖤 " + this.nev + " maximálisat sebzett, ezért gyógyult. Új életereje: " + this.eletero + "\n");
        }

        Random rand = new Random();
        int generated = rand.nextInt(20);
        if (generated == 4 && eletero != this.maxEletero) {
            eletero += 3;
            System.out.println("⚠️ Extra gyógyulás");
        }

    }
}
