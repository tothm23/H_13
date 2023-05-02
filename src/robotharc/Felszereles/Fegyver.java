package robotharc.Felszereles;

import robotharc.Hiba.FegyverHiba;

/**
 *
 * @author Tóth Milán
 */
public class Fegyver {

    private String nev;
    private Integer minimumSebzes;  // minmum ennyit sebez + az erő
    private Integer maximumSebzes;  // maximum ennyit sebez + az erő

    private Integer ero;    // mindenképp hozzáadódik a sebzéshez

    public Fegyver(String nev, Integer minimumSebzes, Integer maximumSebzes, Integer ero) throws FegyverHiba {
        if (nev.equalsIgnoreCase("")) {
            throw new FegyverHiba("A fegyver neve nem lehet üres!");
        }
        if (minimumSebzes <= 0) {
            throw new FegyverHiba("A fegyver minimum sebzése nem lehet kisebb vagy egyenlő, mint 0!");
        }
        if (maximumSebzes <= 0) {
            throw new FegyverHiba("A fegyver maximum sebzése nem lehet kisebb vagy egyenlő, mint 0!");
        }
        if (minimumSebzes > maximumSebzes) {
            throw new FegyverHiba("A fegyver minimm sebzése nem lehet negyobb, mint a maximum sebzése!");
        }
        if (ero <= 0) {
            throw new FegyverHiba("A fegyver ereje nem lehet kisebb vagy egyenlő, mint 0!");
        }
        this.nev = nev;
        this.minimumSebzes = minimumSebzes;
        this.maximumSebzes = maximumSebzes;
        this.ero = ero;

        // HÁZI: ero, minimum, maximum sebzés validálása + 
        // maximum és minimum sebzés egymáshoz viszonyított validálása + 
    }

    public String getNev() {
        return nev;
    }

    public Integer getMinimumSebzes() {
        return minimumSebzes;
    }

    public Integer getMaximumSebzes() {
        return maximumSebzes;
    }

    public Integer getEro() {
        return ero;
    }

}
