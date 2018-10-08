package es.upm.miw.apaw.api.businessControllers;

import es.upm.miw.apaw.api.daos.DaoFactory;
import es.upm.miw.apaw.api.dtos.ArtistDto;
import es.upm.miw.apaw.api.entities.Artist;
import es.upm.miw.apaw.api.exceptions.NotFoundException;

public class ArtistBusinessController {

    public String create(ArtistDto artistDto){
        Artist artist = new Artist(artistDto.getName(), true);
        DaoFactory.getFactory().getArtistDao().save(artist);
        return artist.getId();
    }

    public void updateName(String id, ArtistDto artistDto){
        Artist artist = DaoFactory.getFactory().getArtistDao().read(id).orElseThrow(() ->
                new NotFoundException("Artist id: " + id));
        artist.setName(artistDto.getName());
        DaoFactory.getFactory().getArtistDao().save(artist);
    }
}
