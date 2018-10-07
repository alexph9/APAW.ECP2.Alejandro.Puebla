package es.upm.miw.apaw.entities;
public class Review {

    private String id;

    private boolean isNegative;

    private String description;

    public Review(String id, boolean isNegative, String description) {
        this.id = id;
        this.isNegative = isNegative;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public boolean isNegative() {
        return isNegative;
    }

    public void setNegative(boolean negative) {
        isNegative = negative;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
