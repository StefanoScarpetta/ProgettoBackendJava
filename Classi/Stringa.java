package Classi;

public class Stringa {
    private String stringa;

    public Stringa(String stringa) {
        this.stringa = stringa;
    }

    public String getStringa() {
        return stringa;
    }

    public void setStringa(String stringa) {
        this.stringa = stringa;
    }

    @Override
    public String toString() {
        return "Stringa{" +
                "stringa='" + stringa + '\'' +
                '}';
    }
}
