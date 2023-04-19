/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megoldas;

import java.util.Random;

public class Robot {

    private String nev;
    private String szin;
    private int eletero;
    private boolean harcose;
    private int sebzes;

    public Robot(String nev, String szin, int eletero, boolean harcose, int sebzes) {
        this.nev = nev;
        this.szin = szin;
        this.eletero = eletero;
        this.harcose = harcose;
        this.sebzes = sebzes;
    }

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

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    public boolean isHarcose() {
        return harcose;
    }

    public void setHarcose(boolean harcose) {
        this.harcose = harcose;
    }

    public int getSebzes() {
        return sebzes;
    }

    public void setSebzes(int sebzes) {
        this.sebzes = sebzes;
    }

    public static boolean Harcosok(Robot robot1, Robot robot2) {

        if (robot1.harcose && robot2.harcose) {
            return true;
        } else {
            return false;
        }
    }

    public static String Kezdorobot(Robot robot1, Robot robot2) {
        if (robot1.eletero > robot2.eletero) {
            return "robot2";
        } else if (robot1.eletero < robot2.eletero) {
            return "robot1";
        } else {
            if (robot1.sebzes > robot2.sebzes) {
                return "robot1";
            } else if (robot1.sebzes < robot2.sebzes) {
                return "robot2";
            } else {
                int szam1 = randomszam();
                int szam2 = randomszam();
                if (szam1 > szam2) {
                    return "robot1";
                } else {
                    return "robot2";
                }

            }
        }
    }

    public static int randomszam() {
        Random random = new Random();
        int x = random.nextInt();
        return x;
    }

    public static int veletlenEgeszSzam(int tol, int ig) {
        return (int) Math.floor(Math.random() * (ig - tol + 1) + tol);
    }

    public int sebzes(Robot robot) {
        return veletlenEgeszSzam(0, this.sebzes);
    }

    public void Tamadas(Robot robot) {
        int damage = this.sebzes(robot);
        robot.setEletero(robot.getEletero() - damage);

        Gyogyulas(damage);
    }

    public void Gyogyulas(int damage) {
        if (damage == this.sebzes) {
            this.setEletero(this.getEletero() + 2);
        }

    }

    public static void Harc(Robot robot1, Robot robot2) {
        if (Harcosok(robot1, robot2)) {
            String kezdorobot = Kezdorobot(robot1, robot2);
            boolean igaz = true;
            while (igaz) {
                if (kezdorobot.equals("robot1")) {
                    robot1.Tamadas(robot2);
                    if (robot2.eletero <= 0) {
                        System.out.println("Gyöztes: " + robot1.nev);
                        igaz = false;
                    } else {
                        robot2.Tamadas(robot1);
                    }

                } else {
                    robot2.Tamadas(robot1);
                    if (robot1.eletero <= 0) {
                        System.out.println("Gyöztes: " + robot2.nev);
                        igaz = false;
                    } else {
                        robot1.Tamadas(robot2);
                    }

                }

            }

        }

    }
}
