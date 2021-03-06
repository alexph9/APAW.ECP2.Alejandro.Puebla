package es.upm.miw.apaw.api.daos.memory;

import es.upm.miw.apaw.api.daos.ReviewDao;
import es.upm.miw.apaw.api.entities.Review;

import java.util.HashMap;

public class ReviewDaoMemory extends GenericDaoMemory<Review> implements ReviewDao {

    public ReviewDaoMemory(){ super(new HashMap<>()); }

    @Override
    public String getId(Review review) {
        return review.getId();
    }

    @Override
    public void setId(Review review, String id) {
        review.setId(id);
    }
}
