package edu.escuelaing.arem.ASE.app;

import com.google.gson.Gson;
import java.net.*;
import java.io.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Cache {
    public static HashMap<String,String> movies = new HashMap<>();

    /**
     * Busca el titulo en de la memoria
     * @param titulo String del titulo de la pelicula
     * @return Si el tutulo se encuentra en memoria retorna la información
     * @throws IOException
     */
    public static String inMemory(String titulo) throws IOException {
        String n="";
        if (movies.containsKey(titulo)){
            n += movies.get(titulo);
        }else{
            String jsonMovie = HttpConnection.getMovie(titulo);
            Gson gson = new Gson();
            MovieInfo movieInfo = gson.fromJson(jsonMovie, MovieInfo.class);
            movies.put(titulo,n);

             n += "<strong>Title:</strong> " + movieInfo.getTitle() + "<br>";
            n += "<strong>Year:</strong> " + movieInfo.getYear() + "<br>";
            n += "<strong>Rated:</strong> " + movieInfo.getRated() + "<br>";
            n += "<strong>Released:</strong> " + movieInfo.getReleased() + "<br>";
            n += "<strong>Runtime:</strong> " + movieInfo.getRuntime() + "<br>";
            n += "<strong>Genre:</strong> " + movieInfo.getGenre() + "<br>";
            n += "<strong>Director:</strong> " + movieInfo.getDirector() + "<br>";
            n += "<strong>Writer:</strong> " + movieInfo.getWriter() + "<br>";
            n += "<strong>Actors:</strong> " + movieInfo.getActors() + "<br>";
            n += "<strong>Plot:</strong> " + movieInfo.getPlot() + "<br>";
            n += "<strong>Language:</strong> " + movieInfo.getLanguage() + "<br>";
            n += "<strong>Country:</strong> " + movieInfo.getCountry() + "<br>";
            n += "<strong>Awards:</strong> " + movieInfo.getAwards() + "<br>";
            n += "<strong>BoxOffice:</strong> " + movieInfo.getBoxOffice() + "<br>";

            String posterUrl = movieInfo.getPoster();
            if (posterUrl != null && !posterUrl.isEmpty()) {
                n += "<img src=\"" + posterUrl + "\" alt=\"Poster\"><br>";
            }

            List<MovieInfo.Rating> ratings = movieInfo.getRatings();
            if (ratings != null && !ratings.isEmpty()) {
                n += "<strong>Ratings:</strong><br>";
                for (MovieInfo.Rating rating : ratings) {
                    n += "&emsp;<strong>" + rating.getSource() + ":</strong> " + rating.getValue() + "<br>";
                }
            }
        }
        return n;
    }
}