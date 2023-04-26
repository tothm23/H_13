package robotharc.Felszereles;

/**
 *
 * @author Tóth Milán
 */
public class Fegyver {

    private String nev;
    private Integer minimumSebzes;  // minmum ennyit sebez + az erő
    private Integer maximumSebzes;  // maximum ennyit sebez + az erő
    
    private Integer ero;    // mindenképp hozzáadódik a sebzéshez

    public Fegyver(String nev, Integer minimumSebzes, Integer maximumSebzes, Integer ero) {
        this.nev = nev;
        this.minimumSebzes = minimumSebzes;
        this.maximumSebzes = maximumSebzes;
        this.ero = ero;

        // HÁZI: ero, minimum, maximum sebzés validálása
        // maximum és minimum sebzés egymáshoz viszonyított validálása
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
