package es.upm.miw.apaw.api;

import es.upm.miw.apaw.api.dtos.ArtistDto;
import es.upm.miw.apaw.api.restControllers.ArtistRestController;
import es.upm.miw.apaw.http.Client;
import es.upm.miw.apaw.http.HttpException;
import es.upm.miw.apaw.http.HttpRequest;
import es.upm.miw.apaw.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArtistIT {

    @Test
    void testCreateArtist() {
        this.createArtist();
    }

    private String createArtist() {
        HttpRequest request = HttpRequest.builder(ArtistRestController.ARTISTS).body(new ArtistDto("U2", false)).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testArtistInvalidRequest() {
        HttpRequest request = HttpRequest.builder(ArtistRestController.ARTISTS).path("/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateArtistWithoutUserDto() {
        HttpRequest request = HttpRequest.builder(ArtistRestController.ARTISTS).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateArtistWithoutUserDtoName() {
        HttpRequest request = HttpRequest.builder(ArtistRestController.ARTISTS).body(new ArtistDto(null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }
}
