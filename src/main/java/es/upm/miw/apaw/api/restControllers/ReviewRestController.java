package es.upm.miw.apaw.api.restControllers;

import es.upm.miw.apaw.api.businessControllers.ReviewBusinessController;
import es.upm.miw.apaw.api.dtos.ReviewDto;
import es.upm.miw.apaw.api.exceptions.ArgumentNotValidException;

public class ReviewRestController {

    public static final String REVIEWS = "/reviews";

    private ReviewBusinessController reviewBusinessController = new ReviewBusinessController();

    public void create(ReviewDto reviewDto){
        this.validate(reviewDto, "ReviewDto");
        this.validate(reviewDto.isNegative(), "ReviewDto isNegative");
        this.validate(reviewDto.getDescription(), "ReviewDto Description");
        this.reviewBusinessController.create(reviewDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }
}
