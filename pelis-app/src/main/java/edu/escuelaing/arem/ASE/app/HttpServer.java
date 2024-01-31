package edu.escuelaing.arem.ASE.app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(35000);
            System.out.println("Server listening on port 35000...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleRequest(clientSocket)).start();
                handleRequest(clientSocket);
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        serverSocket.close();
        
    }

    private static void handleRequest(Socket clientSocket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String inputLine, outputLine;
            String title = "";
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if(inputLine.contains("title?name")){
                    String[] firstSplit = inputLine.split("=");
                    title = (firstSplit[1].split("HTTP"))[0];
                }
                if (!in.ready()) {
                    break;
                }
            }
            if(!Objects.equals(title, "")){
                outputLine = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: application/json\r\n"
                        + "\r\n" +
                        "<style>\n" +
                        "table, th, td {\n" +
                        "  border:1px solid black;\n" +
                        "}\n" +
                        "</style>"+
                        Cache.inMemory(title);
            }else {
                outputLine = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Form Example</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "        <style>\n" +
                "            body {\n" +
                "                background-color: #00eeff;\n" +
                "            }\n" +
                "\n" +
                "            h1,label {\n" +
                "                color: rgb(0, 0, 0);\n" +
                "                font-size: 40px;\n" +
                "            }\n" +
                "\n" +
                "            form {\n" +
                "                margin-top: 20px;\n" +
                "            }\n" +
                "\n" +
                "            #getrespmsg {\n" +
                "                margin-top: 20px;\n" +
                "            }\n" +
                "\n" +
                "            input[type=\"button\"] {\n" +
                "                background-color: purple;\n" +
                "                color: white;\n" +
                "                border: none;\n" +
                "                padding: 10px 20px;\n" +
                "                text-align: center;\n" +
                "                text-decoration: none;\n" +
                "                display: inline-block;\n" +
                "                font-size: 16px;\n" +
                "                cursor: pointer;\n" +
                "            }\n" +
                "        </style>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <center><h1>MOVIE NAME</h1></center>\n" +
                "        <center><form action=\"/hello\">\n" +
                "            <center><label for=\"name\">Titulo:</label><br></center>\n" +
                "            <input type=\"text\" id=\"name\" name=\"name\" value=\"John\"><br><br>\n" +
                "            <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsg()\">\n" +
                "        </form></center>\n" +
                "        <div id=\"getrespmsg\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsg() {\n" +
                "                let nameVar = document.getElementById(\"name\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/title?name=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "    </body>\n" +
                "</html>";
            }
            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
