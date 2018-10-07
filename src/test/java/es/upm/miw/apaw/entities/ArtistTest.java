package es.upm.miw.apaw.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArtistTest {

    private Artist artist;

    @BeforeEach
    void before(){ artist = new Artist("1", "U2", false);}

    @Test
    void testIdNameIsSoloSinger(){
        assertEquals("1", artist.getId());
        assertEquals("U2", artist.getName());
        assertEquals(false, artist.isSoloSinger());
    }

    @Test
    void testSetName(){
        artist.setName("Bono");
        assertEquals("Bono", artist.getName());
    }

    @Test
    void testChangeIsSoloSinger(){
        artist.setSoloSinger(true);
        assertEquals(true, artist.isSoloSinger());
    }

}

