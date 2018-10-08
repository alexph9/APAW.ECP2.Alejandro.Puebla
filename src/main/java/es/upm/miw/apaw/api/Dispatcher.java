package es.upm.miw.apaw.api;

import es.upm.miw.apaw.api.daos.DaoFactory;
import es.upm.miw.apaw.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.api.dtos.ArtistDto;
import es.upm.miw.apaw.api.exceptions.ArgumentNotValidException;
import es.upm.miw.apaw.api.exceptions.RequestInvalidException;
import es.upm.miw.apaw.api.restControllers.ArtistRestController;
import es.upm.miw.apaw.http.HttpRequest;
import es.upm.miw.apaw.http.HttpResponse;

public class Dispatcher {

    private static final Object HttpStatus = new ArtistRestController() ;

    static {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private ArtistRestController artistRestController = new ArtistRestController();

    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case GET:
                    throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
                case PUT:
                    throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
                case PATCH:
                    throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
                case DELETE:
                    throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
                default:
                    throw new RequestInvalidException("method error: " + request.getMethod());
            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(es.upm.miw.apaw.http.HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {  // Unexpected
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(es.upm.miw.apaw.http.HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(ArtistRestController.ARTISTS)) {
            response.setBody(this.artistRestController.create((ArtistDto) request.getBody()));
        } else {
            throw new RequestInvalidException("method error: " + request.getMethod());
        }
    }
}
