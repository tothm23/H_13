package robotharc.Felszereles;

import robotharc.Hiba.PancelHiba;

/**
 *
 * @author Tóth Milán
 */
public class Pancel {

    private String nev;
    private Integer eletero;
    private Integer vedelem;

    public Pancel(String nev, Integer eletero, Integer vedelem) throws PancelHiba {
        if (nev.equalsIgnoreCase("")) {
            throw new PancelHiba("A páncél neve nem lehet üres!");
        }
        if (eletero <= 0) {
            throw new PancelHiba("A páncél élet ereje nem lehet kisebb vagy egyenlő, mint 0!");
        }
        if (vedelem <= 0) {
            throw new PancelHiba("A páncél védelme nem lehet kisebb vagy egyenlő, mint 0!");
        }
        this.nev = nev;
        this.eletero = eletero;
        this.vedelem = vedelem;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) throws PancelHiba {
        if (nev.equalsIgnoreCase("")) {
            throw new PancelHiba("A páncél neve nem lehet üres!");
        }
        this.nev = nev;
    }

    public Integer getEletero() {
        return eletero;
    }

    public void setEletero(Integer eletero) throws PancelHiba {
        if (eletero <= 0) {
            throw new PancelHiba("A páncél élet ereje nem lehet kisebb vagy egyenlő, mint 0!");
        }
        this.eletero = eletero;
    }

    public Integer getVedelem() {
        return vedelem;
    }

    public void setVedelem(Integer vedelem) throws PancelHiba {
        if (vedelem <= 0) {
            throw new PancelHiba("A páncél védelme nem lehet kisebb vagy egyenlő, mint 0!");
        }
        this.vedelem = vedelem;
    }

}
