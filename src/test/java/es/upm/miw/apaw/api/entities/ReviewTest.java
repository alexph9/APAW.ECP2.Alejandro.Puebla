package es.upm.miw.apaw.api.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewTest {

    private Review review;

    @BeforeEach
    void before() { review = new Review(false, "Fantastic Song!"); }

    @Test
    void testIdIsNegativeDescription(){
        assertEquals(false, review.isNegative());
        assertEquals("Fantastic Song!", review.getDescription());
    }

    @Test
    void testSetNegative(){
        review.setNegative(true);
        assertEquals(true, review.isNegative());
    }

    @Test
    void testSetDescription(){
        review.setDescription("Poor Song!");
        assertEquals("Poor Song!", review.getDescription());
    }
}
