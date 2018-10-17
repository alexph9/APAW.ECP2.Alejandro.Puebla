package es.upm.miw.apaw.api.businessControllers;

import es.upm.miw.apaw.api.daos.DaoFactory;
import es.upm.miw.apaw.api.dtos.SongDto;
import es.upm.miw.apaw.api.entities.Artist;
import es.upm.miw.apaw.api.entities.Song;
import es.upm.miw.apaw.api.exceptions.NotFoundException;

public class SongBusinessController {

    public String create(SongDto songDto){
        Artist artist = DaoFactory.getFactory().getArtistDao().read(songDto.getArtistId()).orElseThrow(
                () -> new NotFoundException("Artist (" + songDto.getArtistId() + ")"));
        Song song = new Song(songDto.getName(), artist, songDto.getGenre());
        DaoFactory.getFactory().getSongDao().save(song);
        return song.getId();
    }
}