package es.upm.miw.apaw.api.restControllers;

import es.upm.miw.apaw.api.businessControllers.ArtistBusinessController;
import es.upm.miw.apaw.api.dtos.ArtistDto;
import es.upm.miw.apaw.api.exceptions.ArgumentNotValidException;

public class ArtistRestController {

    public static final String ARTISTS = "/artists";
    public static final String ID = "/{id}";

    private ArtistBusinessController artistBusinessController = new ArtistBusinessController();

    private void validateArtistDTO(ArtistDto artistDto){
        if(artistDto == null){
            throw new ArgumentNotValidException("ArtistDto is Null");
        } else if(artistDto.getName() == null) {
            throw new ArgumentNotValidException("ArtistDto name is Null");
        }
    }

    public String create(ArtistDto artistDto){
        this.validateArtistDTO(artistDto);
        return this.artistBusinessController.create(artistDto);
    }

    public void update(String id, ArtistDto artistDto){
        this.validateArtistDTO(artistDto);
        this.artistBusinessController.updateName(id, artistDto);
    }
}
