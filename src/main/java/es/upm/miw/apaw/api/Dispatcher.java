package es.upm.miw.apaw.api;

import es.upm.miw.apaw.api.daos.DaoFactory;
import es.upm.miw.apaw.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.api.dtos.ArtistDto;
import es.upm.miw.apaw.api.dtos.ReviewDto;
import es.upm.miw.apaw.api.dtos.SongDto;
import es.upm.miw.apaw.api.entities.Genre;
import es.upm.miw.apaw.api.exceptions.ArgumentNotValidException;
import es.upm.miw.apaw.api.exceptions.NotFoundException;
import es.upm.miw.apaw.api.exceptions.RequestInvalidException;
import es.upm.miw.apaw.api.restControllers.ArtistRestController;
import es.upm.miw.apaw.api.restControllers.ReviewRestController;
import es.upm.miw.apaw.api.restControllers.SongRestController;
import es.upm.miw.apaw.http.HttpRequest;
import es.upm.miw.apaw.http.HttpResponse;

public class Dispatcher {

    static {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private ArtistRestController artistRestController = new ArtistRestController();
    private ReviewRestController reviewRestController = new ReviewRestController();
    private SongRestController songRestController = new SongRestController();

    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case GET:
                    this.doGet(request, response);
                    break;
                case PUT:
                    this.doPut(request);
                    break;
                case PATCH:
                    this.doPatch(request);
                    break;
                case DELETE:
                    this.doDelete(request);
                    break;
                default:
                    throw new RequestInvalidException("method error: " + request.getMethod());
            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(es.upm.miw.apaw.http.HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(es.upm.miw.apaw.http.HttpStatus.NOT_FOUND);
        } catch (Exception exception) {  // Unexpected
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(es.upm.miw.apaw.http.HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(ArtistRestController.ARTISTS)) {
            response.setBody(this.artistRestController.create((ArtistDto) request.getBody()));
        } else if(request.isEqualsPath(ReviewRestController.REVIEWS)){
            this.reviewRestController.create((ReviewDto) request.getBody());
        } else if(request.isEqualsPath(songRestController.SONGS)){
            this.songRestController.create((SongDto) request.getBody());
        } else {
            throw new RequestInvalidException("method error: " + request.getMethod());
        }
    }

    private void doPut(HttpRequest request) {
        if (request.isEqualsPath(ArtistRestController.ARTISTS + ArtistRestController.ID)) {
            this.artistRestController.update(request.getPath(1), (ArtistDto) request.getBody());
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doGet(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(SongRestController.SONGS)) {
            response.setBody(this.songRestController.readAll());
        } else {
            throw new RequestInvalidException("method error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doDelete(HttpRequest request) {
        if (request.isEqualsPath(SongRestController.SONGS + SongRestController.ID)) {
            this.songRestController.delete("1");
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doPatch(HttpRequest request) {
        if (request.isEqualsPath(SongRestController.SONGS + SongRestController.ID + SongRestController.GENRE)) {
            this.songRestController.updateCategory("1", (Genre) request.getBody());
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

}
