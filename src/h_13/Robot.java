package h_13;

import java.util.Random;

/**
 *
 * @author Tóth Milán
 */
public class Robot {

    private String nev;
    private String szin;
    private Integer eletero;
    private Boolean harcos;
    private Integer sebzes;

    public Robot() {
    }

    public Robot(String nev, Integer eletero, Boolean harcos) {
        this.nev = nev;
        this.eletero = eletero;
        this.harcos = harcos;
    }

    public Robot(String nev, String szin, Integer eletero, Boolean harcos, Integer sebzes) {
        this.nev = nev;
        this.szin = szin;
        this.eletero = eletero;
        this.harcos = harcos;
        this.sebzes = sebzes;
    }

    // Getterek és setterek
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public Integer getEletero() {
        return eletero;
    }

    public void setEletero(Integer eletero) {
        this.eletero = eletero;
    }

    public Boolean getHarcos() {
        return harcos;
    }

    public void setHarcos(Boolean harcos) {
        this.harcos = harcos;
    }

    public Integer getSebzes() {
        return sebzes;
    }

    public void setSebzes(Integer sebzes) {
        this.sebzes = sebzes;
    }

    // Saját függvények
    public static void statisztika(Robot a) {
        System.out.println("A robot neve: " + a.getNev());
        System.out.println("A robot színe: " + a.getSzin());
        System.out.println("A robot életereje: " + a.getEletero());
        System.out.println("Harcos? " + a.getHarcos());
        System.out.println("A robot sebzése: " + a.getSebzes() + "\n");
    }

    public static Boolean harcosok(Robot a, Robot b) {
        return a.getHarcos().equals(b.getHarcos());
    }

    public static Robot kezdorobot(Robot a, Robot b) {
        /*
         if (a.getEletero() < b.getEletero()) {
            if (a.getEletero().equals(b.getEletero())) {
                if (a.getSebzes().equals(b.getSebzes())) {
                    // 0 - a
                    // 1 - b
                    int veletelen = new Random().nextInt(1);

                    if (veletelen == 0) {
                        return a;
                    } else {
                        return b;
                    }
                } else if (a.getSebzes() > b.getSebzes()) {
                    return a;
                } else {
                    return b;
                }
            }
            return a;
        } else {
            return b;
        }
         */
        Robot kezdorobot = b;
        if (a.getEletero() < b.getEletero()) {
            if (a.getEletero().equals(b.getEletero())) {
                if (a.getSebzes().equals(b.getSebzes())) {
                    // 0 - a
                    // 1 - b
                    int veletelen = new Random().nextInt(1);

                    if (veletelen == 0) {
                        kezdorobot = a;
                    } else {
                        kezdorobot = b;
                    }
                } else if (a.getSebzes() > b.getSebzes()) {
                    kezdorobot = a;
                } else {
                    kezdorobot = b;
                }
            }
            kezdorobot = a;
        }
        return b;

    }

    public Integer sebzes(Robot a) {
        return new Random().nextInt(a.getSebzes());
    }

    public void tamadas(Robot a, Integer sebzes) {
        a.setEletero(a.getEletero() - a.sebzes(a));
    }

    public void gyogyulas(Robot tamado, Robot elszenvedo) {
    }

    public static void harc(Robot a, Robot b) {
        if (harcosok(a, b)) {
            Robot kezdo = kezdorobot(a, b);
            Robot szenvedo = kezdo.equals(a) ? b : a;
            kezdo.tamadas(szenvedo, szenvedo.getSebzes());
            System.out.println("* " + kezdo.getNev() + " megtámadta " + szenvedo.getNev() + "-t " + kezdo.sebzes(kezdo)
                    + " sebzést okozott, ezzel " + szenvedo.getNev() + " új életereje " + szenvedo.getEletero() + " lett ");

            szenvedo.tamadas(kezdo, kezdo.getSebzes());
            System.out.println("* " + szenvedo.getNev() + " megtámadta " + kezdo.getNev() + "-t " + szenvedo.sebzes(szenvedo)
                    + " sebzést okozott, ezzel " + kezdo.getNev() + " új életereje " + kezdo.getEletero() + " lett ");

        }
    }
}
