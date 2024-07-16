# ForoHub

ForoHub es una aplicación desarrollada con Spring Boot que permite a los usuarios gestionar un foro de discusión. La aplicación incluye endpoints para autenticación y para gestionar los tópicos del foro.

## Requisitos

- Java 17 o superior
- Docker (opcional, para base de datos MySQL)

## Instalación

Clone el repositorio en su máquina local:

```bash
git clone https://github.com/Alexis-Rueda/foro-hub.git
```

## Configuración de Docker

Asegúrate de tener Docker y Docker Compose instalados en tu máquina.

### Archivo `docker-compose.yml`

```bash
docker-compose up -d
```

## Detener los servicios

Para detener y eliminar los contenedores de Docker, usa el siguiente comando:

```bash
docker-compose down
```
