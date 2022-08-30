package Classi;

public class Updated {
    private String updated;

    public Updated(String updated) {
        this.updated = updated;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Updated{" +
                "updated='" + updated + '\'' +
                '}';
    }
}
