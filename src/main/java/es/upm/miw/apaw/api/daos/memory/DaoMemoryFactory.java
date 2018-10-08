package es.upm.miw.apaw.api.daos.memory;

import es.upm.miw.apaw.api.daos.ArtistDao;
import es.upm.miw.apaw.api.daos.DaoFactory;

public class DaoMemoryFactory extends DaoFactory {

    private ArtistDao artistDao;

    @Override
    public ArtistDao getArtistDao() {
        if(artistDao == null) {
            artistDao = new ArtistDaoMemory();
        }
        return artistDao;
    }
}
