package edu.escuelaing.arem.ASE.app;

import java.util.List;

/**
 * Clase que representa la información de una película obtenida de la API de OMDB.
 */
public class MovieInfo {
    private String Title;
    private String Year;
    private String Rated;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Poster;
    private String Awards;
    private String BoxOffice;
    private List<Rating> Ratings;


    /**
     * Obtiene el título de la película.
     * @return Título de la película.
     */
    public String getTitle() {
        return Title;
    }
    /**
     * Obtiene el año de la película.
     * @return año de la película.
     */
    public String getYear() {
        return Year;
    }
    /**
     * Obtiene calificacion de la película.
     * @return calificacion de la película.
     */
    public String getRated() {
        return Rated;
    }
    /**
     * Obtiene el lanzamiento de la película.
     * @return lanzamiento de la película.
     */
    public String getReleased() {
        return Released;
    }
    /**
     * Obtiene duración de la película.
     * @return duración de la película.
     */
    public String getRuntime() {
        return Runtime;
    }
    /**
     * Obtiene el genero de la película.
     * @return genero de la película.
     */
    public String getGenre() {
        return Genre;
    }
    /**
     * Obtiene el director de la película.
     * @return director de la película.
     */
    public String getDirector() {
        return Director;
    }
    /**
     * Obtiene el escritor de la película.
     * @return escritor de la película.
     */
    public String getWriter() {
        return Writer;
    }
    /**
     * Obtiene los actores de la película.
     * @return actores de la película.
     */
    public String getActors() {
        return Actors;
    }
    /**
     * Obtiene el argumento de la película.
     * @return argumento de la película.
     */
    public String getPlot() {
        return Plot;
    }
    /**
     * Obtiene el idioma de la película.
     * @return idioma de la película.
     */

    public String getLanguage() {
        return Language;
    }
    /**
     * Obtiene el pais de origen de la película.
     * @return pais de origen de la película.
     */
    public String getCountry() {
        return Country;
    }
    /**
     * Obtiene el poster de la película.
     * @return poster de la película.
     */
    public String getPoster() {
        return Poster;
    }
    /**
     * Obtiene los premios de la película.
     * @return premios de la película.
     */
    public String getAwards() {
        return Awards;
    }
    /**
     * Obtiene el dinero recaudado de la película.
     * @return dinero recaudado de la película.
     */
    public String getBoxOffice() {
        return BoxOffice;
    }
    /**
     * Obtiene la lista de clasificaciones de la película.
     * @return Lista de clasificaciones.
     */
    public List<Rating> getRatings() {
        return Ratings;
    }

    /**
     * Clase interna que representa una clasificación de la película.
     */
    public static class Rating {
        private String Source;
        private String Value;
        /**
         * Obtiene la fuente de la clasificación.
         * @return Fuente de la clasificación.
         */
        public String getSource() {
            return Source;
        }
        /**
         * Obtiene el valor de la clasificación.
         * @return Valor de la clasificación.
         */
        public String getValue() {
            return Value;
        }
    }
}


