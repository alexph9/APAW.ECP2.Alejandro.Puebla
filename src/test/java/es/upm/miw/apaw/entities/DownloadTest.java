package es.upm.miw.apaw.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DownloadTest {

    private Download download;

    @BeforeEach
    void before() { download = new Download(2); }

    @Test
    void testPriceDate(){
        assertEquals(2, download.getPrice());
        assertNotNull(download.getDate());
    }
}
