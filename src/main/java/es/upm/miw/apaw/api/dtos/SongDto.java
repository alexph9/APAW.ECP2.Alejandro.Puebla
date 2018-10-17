package es.upm.miw.apaw.api.dtos;

import es.upm.miw.apaw.api.entities.Genre;

public class SongDto {

    private String name;

    private String artistId;

    private Genre genre;

    public SongDto(String name, String artistId, Genre genre) {
        this.name = name;
        this.artistId = artistId;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getGenre() {
        return genre.toString();
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", artistId=" + artistId +
                ", genre=" + genre +
                '}';
    }
}
