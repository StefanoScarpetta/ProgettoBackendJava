package Classi;

public class Source {
    private String source;

    public Source(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Source{" +
                "source='" + source + '\'' +
                '}';
    }
}
