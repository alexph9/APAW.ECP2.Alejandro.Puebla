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
        HttpRequest request = HttpRequest.builder().path(ArtistRestController.ARTISTS).body(new ArtistDto("U2", false)).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testArtistInvalidRequest() {
        HttpRequest request = HttpRequest.builder().path(ArtistRestController.ARTISTS).path("/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateArtistWithoutArtistDto() {
        HttpRequest request = HttpRequest.builder().path(ArtistRestController.ARTISTS).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateArtistWithoutArtistDtoName() {
        HttpRequest request = HttpRequest.builder().path(ArtistRestController.ARTISTS).body(new ArtistDto(null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateArtist() {
        String id = this.createArtist();
        HttpRequest request = HttpRequest.builder().path(ArtistRestController.ARTISTS).path(ArtistRestController.ID)
                .expandPath(id).body(new ArtistDto("Metallica")).put();
        new Client().submit(request);
    }

    @Test
    void testUpdateArtistWithoutArtistDto() {
        String id = this.createArtist();
        HttpRequest request = HttpRequest.builder().path(ArtistRestController.ARTISTS).path(ArtistRestController.ID)
                .expandPath(id).body(null).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateArtistBadRequestException() {
        HttpRequest request = HttpRequest.builder().path(ArtistRestController.ARTISTS).path(ArtistRestController.ID)
                .expandPath("incorrectPath").body(new ArtistDto("Metallica")).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }
}
