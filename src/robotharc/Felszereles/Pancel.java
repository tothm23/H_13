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

    public void setEletero(Integer eletero) {
        this.eletero = eletero;
    }

    public Integer getVedelem() {
        return vedelem;
    }

    public void setVedelem(Integer vedelem) {
        this.vedelem = vedelem;
    }

}
