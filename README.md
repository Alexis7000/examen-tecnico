# examen-tecnico
Desarrollo backend - microservicios
Este microservicio funciona con base de datos relacional en memoria H2

## Instalación

Sigue estos pasos para instalar y ejecutar el proyecto en tu entorno local.

1. Clonar el repositorio:
   git clone https://github.com/Alexis7000/examen-tecnico.git
2. ejecutar en el id

## USO

cuerpo del json desde el postman

ENTRADA:

POST /tarea
{
  "titulo": "tarea numero duno",
  "descripcion": "Aprender cómo crear un microservicio",
  "estado": "PENDIENTE",
  "fechaTarea": "2024-09-20"
}

SALIDA:

{
    "id": 1,
    "titulo": "tarea numero duno",
    "descripcion": "Aprender cómo crear un microservicio",
    "estado": "PENDIENTE",
    "fechaTarea": "2024-09-20"
}

## Control de errores
para llevar el control de errores hacemos lo siguiente (borrar el titulo, para ver la excepcion personalizda que arroja)

ENTRADA:

POST /tarea
{
  "descripcion": "Aprender cómo crear un microservicio",
  "estado": "PENDIENTE",
  "fechaTarea": "2024-09-20"
}


SALIDA:

{
    "message": "El título de la tarea no puede estar vacío."
}

