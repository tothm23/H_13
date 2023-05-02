package robotharc.Felszereles;

import robotharc.Hiba.CipoHiba;
import robotharc.Hiba.SisakHiba;

/**
 *
 * @author Tóth Milán
 */
public class Cipo {

    private String nev;
    private Integer eletero;
    private Integer vedelem;

    public Cipo(String nev, Integer eletero, Integer vedelem) throws CipoHiba {
        if (nev.equalsIgnoreCase("")) {
            throw new CipoHiba("A cipő neve nem lehet üres!");
        }
        if (eletero <= 0) {
            throw new CipoHiba("A cipő élet ereje nem lehet kisebb vagy egyenlő, mint 0!");
        }
        if (vedelem <= 0) {
            throw new CipoHiba("A cipő védelme nem lehet kisebb vagy egyenlő, mint 0!");
        }
        this.nev = nev;
        this.eletero = eletero;
        this.vedelem = vedelem;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) throws CipoHiba {
        if (nev.equalsIgnoreCase("")) {
            throw new CipoHiba("A sisak neve nem lehet üres!");
        }
        this.nev = nev;
    }

    public Integer getEletero() {
        return eletero;
    }

    public void setEletero(Integer eletero) throws CipoHiba {
        if (eletero <= 0) {
            throw new CipoHiba("A sisak élet ereje nem lehet kisebb vagy egyenlő, mint 0!");
        }
        this.eletero = eletero;
    }

    public Integer getVedelem() {
        return vedelem;
    }

    public void setVedelem(Integer vedelem) throws CipoHiba {
        if (vedelem <= 0) {
            throw new CipoHiba("A sisak védelme nem lehet kisebb vagy egyenlő, mint 0!");
        }
        this.vedelem = vedelem;
    }

}
