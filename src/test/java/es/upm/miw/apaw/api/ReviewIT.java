package es.upm.miw.apaw.api;

import es.upm.miw.apaw.api.daos.DaoFactory;
import es.upm.miw.apaw.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.api.dtos.ReviewDto;
import es.upm.miw.apaw.api.restControllers.ReviewRestController;
import es.upm.miw.apaw.http.Client;
import es.upm.miw.apaw.http.HttpException;
import es.upm.miw.apaw.http.HttpRequest;
import es.upm.miw.apaw.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReviewIT {

    @BeforeAll
    static void before(){
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    @Test
    void testCreateReview(){
        HttpRequest request = HttpRequest.builder(ReviewRestController.REVIEWS)
                .body(new ReviewDto(false, "Incredible Song!")).post();
        new Client().submit(request).getBody();
    }

    @Test
    void createReviewWithoutReviewDto(){
        HttpRequest request = HttpRequest.builder(ReviewRestController.REVIEWS).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testArtistInvalidRequest() {
        HttpRequest request = HttpRequest.builder(ReviewRestController.REVIEWS).path("/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }


}
