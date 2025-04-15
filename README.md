<h1 align="center" id="title">API Establecimientos</h1>

<p align="center"><img src="https://github.com/vape2205/java_springboot_establecimientossaludapi" alt="project-image"></p>

<p id="description">API para registro y consulta de establecimientos de salud</p>

  
  
<h2>🧐 Features</h2>

Caracteristicas

*   Crear establecimiento
*   Eliminar establecimiento
*   Modificar establecimiento
*   Listado de establecimientos
*   Busqueda por categoria

<h2>🛠️ Installation Steps:</h2>

<p>1. Agregar archivo de environment</p>

```
# Variables de entorno para la bd 
POSTGRES_DB=db_establecimientos 
POSTGRES_USER="Usuario de la base de datos" 
POSTGRES_PASSWORD="Password de la base de datos"
POSTGRES_PORT=5432  

# Variables de entorno para Spring Boot 
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/db_establecimientos 
SPRING_DATASOURCE_USERNAME="Usuario de la base de datos" 
SPRING_DATASOURCE_PASSWORD="Password de la base de datos"
SERVER_PORT=9000
```

<p>2. Ejecutar Docker Compose</p>

```
docker compose up -d --build
```

<h2>Endpoints</h2>

* Listar establecimientos
```
http://localhost:9000/api/establecimientos
```
* Listar establecimientos paginados
```
http://localhost:9000/api/establecimientos?page=1&size=20
```
* Cargar archivo establecimientos
```
curl --location 'http://localhost:9000/api/establecimientos/upload' \
--header 'Content-Disposition: attachment; filename=<<Nombre archivo>>' \
--form 'file=@"/<<Ruta archivo>>"'
```
  
<h2>💻 Built with</h2>

Tecnologias usadas en este proyecto:

*   Spring Boot
*   Postgres