package es.upm.miw.apaw.api.daos.memory;

import es.upm.miw.apaw.api.daos.SongDao;
import es.upm.miw.apaw.api.entities.Song;

import java.util.HashMap;

public class SongDaoMemory extends GenericDaoMemory<Song> implements SongDao {

    public SongDaoMemory() { super(new HashMap<>());}

    @Override
    public String getId(Song song) {
        return song.getId();
    }

    @Override
    public void setId(Song song, String id) {
        song.setId(id);
    }
}
