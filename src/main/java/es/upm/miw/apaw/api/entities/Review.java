package es.upm.miw.apaw.api.entities;

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

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", isNegative='" + isNegative + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}