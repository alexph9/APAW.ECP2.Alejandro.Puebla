package es.upm.miw.apaw.api.restControllers;

import es.upm.miw.apaw.api.businessControllers.ArtistBusinessController;
import es.upm.miw.apaw.api.dtos.ArtistDto;
import es.upm.miw.apaw.api.exceptions.ArgumentNotValidException;

public class ArtistRestController {

    public static final String ARTISTS = "/artists";

    private ArtistBusinessController artistBusinessController = new ArtistBusinessController();

    private void validate(Object property, String message){
        if(property == null){
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }

    public String create(ArtistDto artistDto){
        this.validate(artistDto, "artistDto");
        this.validate(artistDto.getName(), "ArtistDto name");
        return this.artistBusinessController.create(artistDto);
    }
}
