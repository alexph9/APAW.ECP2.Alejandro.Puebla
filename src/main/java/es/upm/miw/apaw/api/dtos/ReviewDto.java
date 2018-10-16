package es.upm.miw.apaw.api.dtos;

public class ReviewDto {


    private boolean isNegative;
    private String description;

    public ReviewDto(boolean isNegative, String description) {
        this.isNegative = isNegative;
        this.description = description;
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
                "isNegative='" + isNegative + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
