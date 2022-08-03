package Classi;

public class DataInformation {

    private Information information;

    public DataInformation(Information information) {
        this.information = information;
    }

    public Information getInformation() {
        return information;
    }

    @Override
    public String toString() {
        return "DataInformation{" +
                "information=" + information +
                '}';
    }
}
