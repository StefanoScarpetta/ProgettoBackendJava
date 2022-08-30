package Classi;

public class Class {
    private String classe;

    public Class(String classe) {
        this.classe = classe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classe='" + classe + '\'' +
                '}';
    }
}
