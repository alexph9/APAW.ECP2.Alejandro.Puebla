package es.upm.miw.apaw.api.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Song {

    private String id;

    private String name;

    private LocalDateTime date;

    private Artist artist;

    private Genre genre;

    private List<Download> downloads;

    public Song(String name, Artist artist, Genre genre) {
        this.name = name;
        this.date = LocalDateTime.now();
        this.artist = artist;
        this.genre = genre;
        this.downloads = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre.toString();
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Download> getDownloads() {
        return downloads;
    }

    public void addDownload(Download download){
        this.downloads.add(download);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", artist=" + artist +
                ", genre=" + genre +
                ", downloads=" + downloads +
                '}';
    }
}
