package robotharc.Felszereles;

import robotharc.Hiba.PancelHiba;

/**
 *
 * @author Tóth Milán
 */
public class Pancel {

    // páncél/védelmi pont (min, max érték is lehet)
    // életerő
    // neve
    private String nev;
    private Integer vedelem;
    private Integer tartossag;

    public Pancel(String nev, Integer vedelem, Integer tartossag) throws PancelHiba {
        if (nev.equalsIgnoreCase("")) {
            throw new PancelHiba("A páncél neve nem lehet üres!");
        }
        if (vedelem <= 0) {
            throw new PancelHiba("A páncél védelme  nem lehet kisebb vagy egyenlő, mint 0!");
        }
        if (tartossag <= 0) {
            throw new PancelHiba("A páncél tartóssága  nem lehet kisebb vagy egyenlő, mint 0!");
        }
        this.nev = nev;
        this.vedelem = vedelem;
        this.tartossag = tartossag;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getVedelem() {
        return vedelem;
    }

    public void setVedelem(Integer vedelem) {
        this.vedelem = vedelem;
    }

    public Integer getTartossag() {
        return tartossag;
    }

    public void setTartossag(Integer tartossag) {
        this.tartossag = tartossag;
    }

}
