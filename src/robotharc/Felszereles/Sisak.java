package robotharc.Felszereles;

import robotharc.Hiba.SisakHiba;

/**
 *
 * @author Tóth Milán
 */
public class Sisak {

    private String nev;
    private Integer eletero;
    private Integer vedelem;

    public Sisak(String nev, Integer eletero, Integer vedelem) throws SisakHiba {
        if (nev.equalsIgnoreCase("")) {
            throw new SisakHiba("A sisak neve nem lehet üres!");
        }
        if (eletero <= 0) {
            throw new SisakHiba("A sisak élet ereje nem lehet kisebb vagy egyenlő, mint 0!");
        }
        if (vedelem <= 0) {
            throw new SisakHiba("A sisak védelme nem lehet kisebb vagy egyenlő, mint 0!");
        }
        this.nev = nev;
        this.eletero = eletero;
        this.vedelem = vedelem;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) throws SisakHiba {
        if (nev.equalsIgnoreCase("")) {
            throw new SisakHiba("A sisak neve nem lehet üres!");
        }
        this.nev = nev;
    }

    public Integer getEletero() {
        return eletero;
    }

    public void setEletero(Integer eletero) throws SisakHiba {
        if (eletero <= 0) {
            throw new SisakHiba("A sisak élet ereje nem lehet kisebb vagy egyenlő, mint 0!");
        }
        this.eletero = eletero;
    }

    public Integer getVedelem() {
        return vedelem;
    }

    public void setVedelem(Integer vedelem) throws SisakHiba {
        if (vedelem <= 0) {
            throw new SisakHiba("A sisak védelme nem lehet kisebb vagy egyenlő, mint 0!");
        }
        this.vedelem = vedelem;
    }

}
