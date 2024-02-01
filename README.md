# ServidorHTTP Peliculas

Este es un proyecto Java que utiliza Maven para gestionar dependencias y construir el código. El proyecto realiza conexiones HTTP a la API de OMDB para obtener información sobre películas y utiliza una memoria caché para almacenar la información obtenida.

## Clases
HttpServer: Esta clase implementa un servidor HTTP básico que escucha en el puerto 35000. El servidor atiende las solicitudes de los clientes y responde según la información proporcionada en esas solicitudes.

Cache: Esta clase implementa un cache que actúa como una memoria para almacenar información de películas.

HttpConnection: clase que se utiliza para realizar conexiones HTTP con la API de OMDB y obtener información sobre películas. 

MovieInfo:  clase que representa la información de una película obtenida de la API de OMDB. 

## Pre-Requisitos

Asegúrate de tener instalado Java y Maven en tu máquina antes de ejecutar el proyecto.

## Instrucciones de Uso

1. Clona el repositorio a tu máquina local:
   ```
   git clone https://github.com/NicolasCastro9/AREP_LAB01.git
   ```
2. Navega hasta el directorio del proyecto donde se encuentra el pom.xml
   ```
   cd miprimera-app
   ```
3. Ejecuta el siguiente comando para compilar el proyecto y descargar las dependencias definidas en el archivo 
  ```
   mvn clean install
  ```
4. Desde la línea de comandos, ejecuta el siguiente comando Maven:
  ```
   mvn exec:java
  ```
5. En el navegador de Mozilla Firefox escribir la siguiente ruta para ver la funcionalidad de la aplicación
  ```
   http://localhost:35000/
  ```
![image](https://github.com/NicolasCastro9/AREP_LAB01/assets/98556822/301caaa6-f0e6-4cb1-af1f-3e0c658115ed)

![image](https://github.com/NicolasCastro9/AREP_LAB01/assets/98556822/26c12aab-1d92-4b00-a82e-111ca790ef9e)

![image](https://github.com/NicolasCastro9/AREP_LAB01/assets/98556822/6d6f1ce3-17e7-4f46-897a-00d54562b904)

## CONSTRUIDO CON

MAVEN -  framework de gestión de proyectos de software

## Dependencias
JUnit: Framework de pruebas unitarias para Java.

Gson: Biblioteca de Google para trabajar con JSON en Java.

## Autor
### Nicolás Castro Jaramillo

## Licencia
Este proyecto está bajo la licencia MIT.




   


