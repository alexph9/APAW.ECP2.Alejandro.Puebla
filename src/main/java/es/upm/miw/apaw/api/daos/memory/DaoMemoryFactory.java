package es.upm.miw.apaw.api.daos.memory;

import es.upm.miw.apaw.api.daos.ArtistDao;
import es.upm.miw.apaw.api.daos.DaoFactory;
import es.upm.miw.apaw.api.daos.ReviewDao;

public class DaoMemoryFactory extends DaoFactory {

    private ArtistDao artistDao;
    private ReviewDao reviewDao;

    @Override
    public ArtistDao getArtistDao() {
        if(artistDao == null) {
            artistDao = new ArtistDaoMemory();
        }
        return artistDao;
    }

    @Override
    public ReviewDao getReviewDao() {
        if(reviewDao == null) {
            reviewDao = new ReviewDaoMemory();
        }
        return reviewDao;
    }
}
