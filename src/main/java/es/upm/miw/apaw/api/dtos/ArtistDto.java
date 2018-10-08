package es.upm.miw.apaw.api.dtos;

public class ArtistDto {


    private String name;

    private boolean isSoloSinger;

    public ArtistDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSoloSinger() {
        return isSoloSinger;
    }

    public void setSoloSinger(boolean soloSinger) {
        this.isSoloSinger = soloSinger;
    }

    @Override
    public String toString() {
        return "ArtistDto{" +
                "name='" + name + '\'' +
                ", isSoloSinger=" + isSoloSinger +
                '}';
    }
}
