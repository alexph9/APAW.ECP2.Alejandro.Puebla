package es.upm.miw.apaw.api.businessControllers;

import es.upm.miw.apaw.api.daos.DaoFactory;
import es.upm.miw.apaw.api.dtos.ReviewDto;
import es.upm.miw.apaw.api.entities.Review;

public class ReviewBusinessController {

    public void create(ReviewDto reviewDto){
        Review review = new Review(reviewDto.isNegative(), reviewDto.getDescription());
        DaoFactory.getFactory().getReviewDao().save(review);
    }
}
