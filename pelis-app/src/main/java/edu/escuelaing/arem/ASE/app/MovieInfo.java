package edu.escuelaing.arem.ASE.app;

import java.util.List;

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

    // Agregar getters para cada atributo

    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }

    public String getRated() {
        return Rated;
    }
    public String getReleased() {
        return Released;
    }
    public String getRuntime() {
        return Runtime;
    }
    public String getGenre() {
        return Genre;
    }
    public String getDirector() {
        return Director;
    }
    public String getWriter() {
        return Writer;
    }

    public String getActors() {
        return Actors;
    }

    public String getPlot() {
        return Plot;
    }

    public String getLanguage() {
        return Language;
    }

    public String getCountry() {
        return Country;
    }
    public String getPoster() {
        return Poster;
    }

    public String getAwards() {
        return Awards;
    }
    public String getBoxOffice() {
        return BoxOffice;
    }

    public List<Rating> getRatings() {
        return Ratings;
    }

    // Clase interna para representar la calificación
    public static class Rating {
        private String Source;
        private String Value;

        public String getSource() {
            return Source;
        }

        public String getValue() {
            return Value;
        }
    }
}


