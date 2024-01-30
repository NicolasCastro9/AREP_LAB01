package edu.escuelaing.arem.ASE.app;


import java.net.*;
import java.io.*;
import java.io.IOException;
import java.util.HashMap;

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
            n += HttpConnection.getMovie(titulo);
            movies.put(titulo,n);
        }
        return n;
    }
}