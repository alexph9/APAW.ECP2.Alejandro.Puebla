package es.upm.miw.apaw.api.dtos;

import es.upm.miw.apaw.api.entities.Song;

public class SongIdNameDto {

    private String id;

    private String name;


    public SongIdNameDto(Song song) {
        this.id = song.getId();
        this.name = song.getName();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SongIdNameDto{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
