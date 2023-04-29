package robotharc;

/**
 *
 * @author Tóth Milán
 */
public enum Szin {
    // Törli a konzolt
    TOROL("\033[H\033[2J"),
    // Visszaállít
    VISSZA("\033[0m"),
    // Szabályos színek
    FEKETE("\033[0;30m"),
    PIROS("\033[0;31m"),
    ZOLD("\033[0;32m"),
    SARGA("\033[0;33m"),
    KEK("\033[0;34m"),
    LILA("\033[0;35m"),
    CIAN("\033[0;36m"),
    FEHER("\033[0;37m");

    private String kod;

    Szin(String kod) {
        this.kod = kod;
    }

    public String get() {
        return kod;
    }

}
