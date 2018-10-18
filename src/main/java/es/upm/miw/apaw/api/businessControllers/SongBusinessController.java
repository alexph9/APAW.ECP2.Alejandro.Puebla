package es.upm.miw.apaw.api.businessControllers;

import es.upm.miw.apaw.api.daos.DaoFactory;
import es.upm.miw.apaw.api.dtos.SongDto;
import es.upm.miw.apaw.api.dtos.SongIdNameDto;
import es.upm.miw.apaw.api.entities.Artist;
import es.upm.miw.apaw.api.entities.Song;
import es.upm.miw.apaw.api.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class SongBusinessController {

    public String create(SongDto songDto){
        Artist artist = DaoFactory.getFactory().getArtistDao().read(songDto.getArtistId()).orElseThrow(
                () -> new NotFoundException("Artist (" + songDto.getArtistId() + ")"));
        Song song = new Song(songDto.getName(), artist, songDto.getGenre());
        DaoFactory.getFactory().getSongDao().save(song);
        return song.getId();
    }

    public List<SongIdNameDto> readAll(){
        return DaoFactory.getFactory().getSongDao().findAll().stream().map(
                song -> new SongIdNameDto(song)
        ).collect(Collectors.toList());
    }

    public void delete(String id){ DaoFactory.getFactory().getSongDao().deleteById(id);}
}
