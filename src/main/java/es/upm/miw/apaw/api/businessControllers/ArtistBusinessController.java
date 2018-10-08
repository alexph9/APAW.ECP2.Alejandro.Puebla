package es.upm.miw.apaw.api.businessControllers;

import es.upm.miw.apaw.api.daos.DaoFactory;
import es.upm.miw.apaw.api.dtos.ArtistDto;
import es.upm.miw.apaw.api.entities.Artist;

public class ArtistBusinessController {

    public String create(ArtistDto artistDto){
        Artist artist = new Artist(artistDto.getName(), true);
        DaoFactory.getFactory().getArtistDao().save(artist);
        return artist.getId();
    }
}
