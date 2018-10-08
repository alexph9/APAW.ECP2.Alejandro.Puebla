package es.upm.miw.apaw.api.daos.memory;

import es.upm.miw.apaw.api.daos.ArtistDao;
import es.upm.miw.apaw.api.entities.Artist;

import java.util.HashMap;

public class ArtistDaoMemory extends GenericDaoMemory<Artist> implements ArtistDao {

    public ArtistDaoMemory(){ super(new HashMap<>());}

    @Override
    public String getId(Artist artist) {
        return artist.getId();
    }

    @Override
    public void setId(Artist artist, String id) {
        artist.setId(id);
    }
}
