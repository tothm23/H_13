package robotharc.Felszereles;

/**
 *
 * @author Tóth Milán
 */
public class Sisak {

    private String nev;
    private Integer eletero;
    private Integer vedelem;

    public Sisak(String nev, Integer eletero, Integer vedelem) {
        this.nev = nev;
        this.eletero = eletero;
        this.vedelem = vedelem;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
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
