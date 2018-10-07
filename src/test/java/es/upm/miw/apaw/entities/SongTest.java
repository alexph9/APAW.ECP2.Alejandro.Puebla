package es.upm.miw.apaw.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SongTest {

    private Song song;
    private Artist artist;
    private Genre genre;

    @BeforeEach
    void before(){
        artist = new Artist("1", "U2", false);
        song = new Song("1", "One", artist, genre.ROCK );
    }

    @Test
    void testIdNameDateArtistGenre(){
        assertEquals("1", song.getId());
        assertEquals("One", song.getName());
        assertNotNull(song.getDate());
        assertEquals(artist, song.getArtist());
        assertEquals("ROCK", song.getGenre());
    }

    @Test
    void testSetArtist(){
        Artist artist2 = new Artist("2", "Bono", true);
        song.setArtist(artist2);
        assertEquals(artist2, song.getArtist());
    }

    @Test
    void testSetGenre(){
        song.setGenre(genre.POP);
        assertEquals("POP", song.getGenre());
    }

    @Test
    void testSetName(){
        song.setName("Beautiful Day");
        assertEquals("Beautiful Day", song.getName());
    }

}
