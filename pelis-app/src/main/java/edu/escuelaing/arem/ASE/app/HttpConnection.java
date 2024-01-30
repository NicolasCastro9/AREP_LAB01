package edu.escuelaing.arem.ASE.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String OMDB_API_URL = "http://www.omdbapi.com/";
    private static final String API_KEY = "a8496578";

    public static String getMovie(String title) throws IOException {
        String apiUrl = OMDB_API_URL + "?t=" + title + "&apikey=" + API_KEY;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = connection.getResponseCode();
            System.out.println("GET Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println(response.toString());
                return response.toString();
            } else {
                throw new IOException("GET request failed with response code: " + responseCode);
            }
        } finally {
            // Siempre cerrar la conexión para liberar recursos
            connection.disconnect();
        }
    }
}
