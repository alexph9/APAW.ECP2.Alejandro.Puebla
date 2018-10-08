package es.upm.miw.apaw.api.entities;

public class Artist {

    private String id;

    private String name;

    private boolean isSoloSinger;

    public Artist(String id, String name, boolean isSoloSinger) {
        this.id = id;
        this.name = name;
        this.isSoloSinger = isSoloSinger;
    }

    public void setId(String id){ this.id = id;}

    public String getId() {
        return id;
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
}
