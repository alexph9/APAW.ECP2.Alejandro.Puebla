package es.upm.miw.apaw.api.restControllers;

import es.upm.miw.apaw.api.businessControllers.SongBusinessController;
import es.upm.miw.apaw.api.dtos.SongDto;
import es.upm.miw.apaw.api.dtos.SongIdNameDto;
import es.upm.miw.apaw.api.entities.Genre;
import es.upm.miw.apaw.api.exceptions.ArgumentNotValidException;

import java.util.List;

public class SongRestController {

    public static final String SONGS = "/songs";
    public static final String ID = "/{id}";
    public static final String GENRE = "/genre";

    private SongBusinessController songBusinessController = new SongBusinessController();

    public String create(SongDto songDto){
        this.validate(songDto, "songDto");
        this.validate(songDto.getName(), "songDto name");
        this.validate(songDto.getGenre(), "songDto genre");
        this.validate(songDto.getArtistId(), "songDto artist id");
        return songBusinessController.create(songDto);

    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }

    public List<SongIdNameDto> readAll() { return songBusinessController.readAll();}

    public void delete(String id){ this.songBusinessController.delete(id);}

    public void updateCategory(String songId, Genre genre) {
        this.validate(genre, "genre");
        this.songBusinessController.updateGenre(songId, genre);
    }
}
