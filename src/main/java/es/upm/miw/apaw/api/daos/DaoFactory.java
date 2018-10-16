package es.upm.miw.apaw.api.daos;

public abstract class DaoFactory {

    private static DaoFactory factory = null;

    public static DaoFactory getFactory(){
        return factory;
    }

    public static void setFactory(DaoFactory factory){ DaoFactory.factory = factory; }

    public abstract ArtistDao getArtistDao();

    public abstract ReviewDao getReviewDao();
}
