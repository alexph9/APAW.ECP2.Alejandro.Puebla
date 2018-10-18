package es.upm.miw.apaw.api;

import es.upm.miw.apaw.api.daos.DaoFactory;
import es.upm.miw.apaw.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.api.dtos.ArtistDto;
import es.upm.miw.apaw.api.dtos.SongDto;
import es.upm.miw.apaw.api.dtos.SongIdNameDto;
import es.upm.miw.apaw.api.entities.Genre;
import es.upm.miw.apaw.api.restControllers.ArtistRestController;
import es.upm.miw.apaw.api.restControllers.SongRestController;
import es.upm.miw.apaw.http.Client;
import es.upm.miw.apaw.http.HttpException;
import es.upm.miw.apaw.http.HttpRequest;
import es.upm.miw.apaw.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SongIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    @Test
    void testCreateSong(){
        this.createSong("Song one");
    }

    private String createSong(String song){
        String artistId = this.createArtist();
        HttpRequest request = HttpRequest.builder().path(SongRestController.SONGS)
                .body(new SongDto(song, artistId, Genre.ROCK)).post();
        return (String) new Client().submit(request).getBody();
    }

    private String createArtist(){
        HttpRequest request = HttpRequest.builder().path(ArtistRestController.ARTISTS).body(new ArtistDto("U2")).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void createSongArtistIdNotFound(){
        HttpRequest request = HttpRequest.builder().path(SongRestController.SONGS)
                .body(new SongDto("Revolution",  "noexist", Genre.ROCK)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }

    @Test
    void createSongWithoutGenre(){
        String artistId = this.createArtist();
        HttpRequest request = HttpRequest.builder().path(SongRestController.SONGS)
                .body(new SongDto("Revolution",  artistId, null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testReadAll() {
        for (int i = 0; i < 5; i++) {
            this.createSong("song" + i);
        }
        HttpRequest request = HttpRequest.builder().path(SongRestController.SONGS).get();
        List<SongIdNameDto> songs = (List<SongIdNameDto>) new Client().submit(request).getBody();
        assertTrue(songs.size() >= 5);
    }

    @Test
    void testDelete() {
        String id = this.createSong("uno");
        HttpRequest request1 = HttpRequest.builder().path(SongRestController.SONGS).get();
        int count = ((List<SongIdNameDto>) new Client().submit(request1).getBody()).size();
        HttpRequest request2 = HttpRequest.builder().path(SongRestController.SONGS).path(ArtistRestController.ID)
                .expandPath(id).delete();
        new Client().submit(request2);
        assertTrue(((List<SongIdNameDto>) new Client().submit(request1).getBody()).size() < count);
    }

    @Test
    void testUpdateCategory() {
        String id = this.createSong("uno");
        HttpRequest request = HttpRequest.builder().path(SongRestController.SONGS).path(ArtistRestController.ID)
                .expandPath(id).path(SongRestController.GENRE).body(Genre.METAL).patch();
        new Client().submit(request);
    }

}
