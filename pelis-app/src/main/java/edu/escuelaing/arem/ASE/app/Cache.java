package edu.escuelaing.arem.ASE.app;
import com.google.gson.Gson;
import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Cache {
    public static HashMap<String,String> movies = new HashMap<>();
    public static String inMemory(String titulo) throws IOException {
        String n = "";

    if (movies.containsKey(titulo)) {
        // Si la información está en la memoria caché, obtén la información almacenada
        String jsonMovie = movies.get(titulo);
        n += buildHtmlFromJson(jsonMovie);
    } else {
        // Si la información no está en el caché, realiza la solicitud a la API de OMDB
        String jsonMovie = HttpConnection.getMovie(titulo);
        movies.put(titulo, jsonMovie);
        n += buildHtmlFromJson(jsonMovie);
    }

    // Devuelve la cadena construida
    return n;
    }
    private static String buildHtmlFromJson(String jsonMovie) {
        Gson gson = new Gson();
        MovieInfo movieInfo = gson.fromJson(jsonMovie, MovieInfo.class);
    
        // Construye la cadena con la información de la película
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<strong>Title:</strong> ").append(movieInfo.getTitle()).append("<br>");
        htmlBuilder.append("<strong>Year:</strong> ").append(movieInfo.getYear()).append("<br>");
        htmlBuilder.append("<strong>Rated:</strong> ").append(movieInfo.getRated()).append("<br>");
        htmlBuilder.append("<strong>Released:</strong> ").append(movieInfo.getReleased()).append("<br>");
        htmlBuilder.append("<strong>Runtime:</strong> ").append(movieInfo.getRuntime()).append("<br>");
        htmlBuilder.append("<strong>Genre:</strong> ").append(movieInfo.getGenre()).append("<br>");
        htmlBuilder.append("<strong>Director:</strong> ").append(movieInfo.getDirector()).append("<br>");
        htmlBuilder.append("<strong>Writer:</strong> ").append(movieInfo.getWriter()).append("<br>");
        htmlBuilder.append("<strong>Actors:</strong> ").append(movieInfo.getActors()).append("<br>");
        htmlBuilder.append("<strong>Plot:</strong> ").append(movieInfo.getPlot()).append("<br>");
        htmlBuilder.append("<strong>Language:</strong> ").append(movieInfo.getLanguage()).append("<br>");
        htmlBuilder.append("<strong>Country:</strong> ").append(movieInfo.getCountry()).append("<br>");
        htmlBuilder.append("<strong>Awards:</strong> ").append(movieInfo.getAwards()).append("<br>");
        htmlBuilder.append("<strong>BoxOffice:</strong> ").append(movieInfo.getBoxOffice()).append("<br>");
    
        String posterUrl = movieInfo.getPoster();
        if (posterUrl != null && !posterUrl.isEmpty()) {
            htmlBuilder.append("<img src=\"").append(posterUrl).append("\" alt=\"Poster\"><br>");
        }
    
        List<MovieInfo.Rating> ratings = movieInfo.getRatings();
        if (ratings != null && !ratings.isEmpty()) {
            htmlBuilder.append("<strong>Ratings:</strong><br>");
            for (MovieInfo.Rating rating : ratings) {
                htmlBuilder.append("&emsp;<strong>").append(rating.getSource()).append(":</strong> ").append(rating.getValue()).append("<br>");
            }
        }
    
        return htmlBuilder.toString();
    }
    
}